package com.example.ecofarm.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "missions")
public class Mission {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String title;

    public String description;

    public int points;

    public boolean completed;

    public Mission(@NonNull String title, String description, int points, boolean completed) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.completed = completed;
    }
}
