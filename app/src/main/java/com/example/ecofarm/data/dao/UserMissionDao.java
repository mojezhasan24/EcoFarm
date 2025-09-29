package com.example.ecofarm.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ecofarm.data.model.UserMission;

import java.util.List;

@Dao
public interface UserMissionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(UserMission userMission);

    @Query("SELECT COUNT(*) FROM user_missions WHERE userId = :userId")
    LiveData<Integer> getCompletedCount(long userId);

    @Query("SELECT userId, COUNT(*) as count FROM user_missions GROUP BY userId ORDER BY count DESC")
    List<UserMissionCount> getLeaderboardCountsSync();

    class UserMissionCount {
        public long userId;
        public int count;
    }
}


