package com.example.ecofarm.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ecofarm.data.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    long insert(User user);

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    User getByEmailSync(String email);

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    LiveData<User> getById(long id);

    @Query("SELECT * FROM users")
    List<User> getAllSync();

    @Query("SELECT * FROM users ORDER BY totalPoints DESC, name ASC")
    LiveData<List<User>> getLeaderboard();

    @Query("UPDATE users SET totalPoints = totalPoints + :points WHERE id = :userId")
    void addPoints(long userId, int points);
}
