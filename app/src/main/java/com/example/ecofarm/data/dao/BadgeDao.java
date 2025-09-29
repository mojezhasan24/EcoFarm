package com.example.ecofarm.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ecofarm.data.model.Badge;

import java.util.List;

@Dao
public interface BadgeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Badge badge);

    @Query("SELECT * FROM badges ORDER BY requiredPoints ASC")
    LiveData<List<Badge>> getAll();

    @Query("DELETE FROM badges")
    void clearAll();
}
