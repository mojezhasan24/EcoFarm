package com.example.ecofarm.repository;

import androidx.lifecycle.LiveData;

import com.example.ecofarm.data.dao.MissionDao;
import com.example.ecofarm.data.dao.UserMissionDao;
import com.example.ecofarm.data.prefs.SessionManager;
import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.data.model.UserMission;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MissionRepository {
    private final MissionDao missionDao;
    private final UserMissionDao userMissionDao;
    private final SessionManager sessionManager;

    @Inject
    public MissionRepository(MissionDao missionDao, UserMissionDao userMissionDao, SessionManager sessionManager) {
        this.missionDao = missionDao;
        this.userMissionDao = userMissionDao;
        this.sessionManager = sessionManager;
    }

    public LiveData<List<Mission>> getAllMissions() {
        return missionDao.getAll();
    }

    public LiveData<Mission> getMissionById(long id) {
        return missionDao.getById(id);
    }

    public void completeMission(Mission mission) {
        mission.completed = true;
        missionDao.update(mission);
        long userId = sessionManager.getLoggedInUserId();
        if (userId != -1) {
            userMissionDao.insert(new UserMission(userId, mission.id, System.currentTimeMillis()));
        }
    }
}

