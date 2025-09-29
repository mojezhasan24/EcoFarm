package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.model.User;
import com.example.ecofarm.repository.LeaderboardRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LeaderboardViewModel extends ViewModel {
    private final LeaderboardRepository leaderboardRepository;

    @Inject
    public LeaderboardViewModel(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public LiveData<List<User>> getLeaderboard() {
        return leaderboardRepository.getLeaderboard();
    }
}

