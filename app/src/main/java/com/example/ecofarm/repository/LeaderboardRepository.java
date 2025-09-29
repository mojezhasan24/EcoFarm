package com.example.ecofarm.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ecofarm.data.dao.UserDao;
import com.example.ecofarm.data.dao.UserMissionDao;
import com.example.ecofarm.data.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LeaderboardRepository {
    private final UserDao userDao;
    private final UserMissionDao userMissionDao;

    @Inject
    public LeaderboardRepository(UserDao userDao, UserMissionDao userMissionDao) {
        this.userDao = userDao;
        this.userMissionDao = userMissionDao;
    }

    public LiveData<List<User>> getLeaderboard() {
        // Simple approach: fetch users and order by points (already reflects completions via UserRepository.addPoints)
        return userDao.getLeaderboard();
    }
}

