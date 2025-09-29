package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.AppDatabase;
import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.data.model.User;
import com.example.ecofarm.data.prefs.SessionManager;
import com.example.ecofarm.repository.MissionRepository;
import com.example.ecofarm.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DashboardViewModel extends ViewModel {
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final SessionManager sessionManager;

    private final LiveData<List<Mission>> missions;
    private final LiveData<User> user;

    @Inject
    public DashboardViewModel(MissionRepository missionRepository, UserRepository userRepository, SessionManager sessionManager) {
        this.missionRepository = missionRepository;
        this.userRepository = userRepository;
        this.sessionManager = sessionManager;
        this.missions = missionRepository.getAllMissions();
        this.user = userRepository.getLoggedInUser();
    }

    public LiveData<List<Mission>> getMissions() { return missions; }
    public LiveData<User> getUser() { return user; }

    public void completeMission(Mission mission) {
        if (!mission.completed) {
            missionRepository.completeMission(mission);
            userRepository.addPointsToLoggedInUser(mission.points);
        }
    }
}
