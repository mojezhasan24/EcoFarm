package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.repository.MissionRepository;
import com.example.ecofarm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MissionDetailViewModel extends ViewModel {
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Inject
    public MissionDetailViewModel(MissionRepository missionRepository, UserRepository userRepository) {
        this.missionRepository = missionRepository;
        this.userRepository = userRepository;
    }

    public LiveData<Mission> getMission(long id) {
        return missionRepository.getMissionById(id);
    }

    public void complete(Mission mission) {
        if (!mission.completed) {
            missionRepository.completeMission(mission);
            userRepository.addPointsToLoggedInUser(mission.points);
        }
    }
}

