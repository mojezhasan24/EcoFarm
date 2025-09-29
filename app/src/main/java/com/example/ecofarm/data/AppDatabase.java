package com.example.ecofarm.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ecofarm.data.dao.BadgeDao;
import com.example.ecofarm.data.dao.MissionDao;
import com.example.ecofarm.data.dao.UserDao;
import com.example.ecofarm.data.dao.UserMissionDao;
import com.example.ecofarm.data.model.Badge;
import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.data.model.User;
import com.example.ecofarm.data.model.UserMission;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Mission.class, Badge.class, UserMission.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract MissionDao missionDao();
    public abstract BadgeDao badgeDao();
    public abstract UserMissionDao userMissionDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "ecoharvester.db")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    seedInitialData(context.getApplicationContext());
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static void seedInitialData(Context context) {
        ExecutorService io = Executors.newSingleThreadExecutor();
        io.execute(() -> {
            AppDatabase db = getInstance(context);
            // Seed missions
            db.missionDao().clearAll();
            db.badgeDao().clearAll();

            db.missionDao().insert(new Mission("Plant a Tree", "Plant a sapling in your area", 50, false));
            db.missionDao().insert(new Mission("Beach Cleanup", "Collect and dispose plastic waste at a beach", 80, false));
            db.missionDao().insert(new Mission("Recycle Drive", "Organize a recycling drive in your community", 60, false));

            db.badgeDao().insert(new Badge("Green Starter", "Earn 100 points", 100));
            db.badgeDao().insert(new Badge("Eco Warrior", "Earn 300 points", 300));
            db.badgeDao().insert(new Badge("Planet Guardian", "Earn 600 points", 600));

            // Seed sample users for leaderboard
            db.userDao().insert(new User("Alice", "alice@example.com", hash("password"), 220));
            db.userDao().insert(new User("Bob", "bob@example.com", hash("password"), 340));
            db.userDao().insert(new User("Charlie", "charlie@example.com", hash("password"), 120));
        });
    }

    public static String hash(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            return String.valueOf(input.hashCode());
        }
    }
}
