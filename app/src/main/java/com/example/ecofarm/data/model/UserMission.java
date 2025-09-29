package com.example.ecofarm.data.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_missions", indices = {@Index(value = {"userId", "missionId"}, unique = true)})
public class UserMission {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public long userId;
    public long missionId;
    public long completedAt;

    public UserMission(long userId, long missionId, long completedAt) {
        this.userId = userId;
        this.missionId = missionId;
        this.completedAt = completedAt;
    }
}


