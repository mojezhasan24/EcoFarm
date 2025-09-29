package com.example.ecofarm.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ecofarm.data.model.Mission;

import java.util.List;

@Dao
public interface MissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Mission mission);

    @Query("SELECT * FROM missions ORDER BY id DESC")
    LiveData<List<Mission>> getAll();

    @Query("SELECT * FROM missions WHERE id = :id")
    LiveData<Mission> getById(long id);

    @Update
    int update(Mission mission);

    @Query("DELETE FROM missions")
    void clearAll();
}
