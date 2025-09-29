package com.example.ecofarm.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String name;

    @NonNull
    public String email;

    @NonNull
    public String passwordHash;

    public int totalPoints;

    public User(@NonNull String name, @NonNull String email, @NonNull String passwordHash, int totalPoints) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.totalPoints = totalPoints;
    }
}
