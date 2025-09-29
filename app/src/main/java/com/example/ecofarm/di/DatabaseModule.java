package com.example.ecofarm.di;

import android.content.Context;

import com.example.ecofarm.data.AppDatabase;
import com.example.ecofarm.data.dao.BadgeDao;
import com.example.ecofarm.data.dao.MissionDao;
import com.example.ecofarm.data.dao.UserDao;
import com.example.ecofarm.data.prefs.SessionManager;
import com.example.ecofarm.data.dao.UserMissionDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context context) {
        return AppDatabase.getInstance(context);
    }

    @Provides
    public UserDao provideUserDao(AppDatabase db) {
        return db.userDao();
    }

    @Provides
    public MissionDao provideMissionDao(AppDatabase db) {
        return db.missionDao();
    }

    @Provides
    public BadgeDao provideBadgeDao(AppDatabase db) {
        return db.badgeDao();
    }

    @Provides
    @Singleton
    public SessionManager provideSessionManager(@ApplicationContext Context context) {
        return new SessionManager(context);
    }

    @Provides
    public UserMissionDao provideUserMissionDao(AppDatabase db) {
        return db.userMissionDao();
    }
}
