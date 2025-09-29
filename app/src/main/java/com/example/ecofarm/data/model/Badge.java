package com.example.ecofarm.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "badges")
public class Badge {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String name;

    public String description;

    public int requiredPoints;

    public Badge(@NonNull String name, String description, int requiredPoints) {
        this.name = name;
        this.description = description;
        this.requiredPoints = requiredPoints;
    }
}
