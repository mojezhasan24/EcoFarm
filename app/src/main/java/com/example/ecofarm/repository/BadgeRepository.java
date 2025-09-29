package com.example.ecofarm.repository;

import androidx.lifecycle.LiveData;

import com.example.ecofarm.data.dao.BadgeDao;
import com.example.ecofarm.data.model.Badge;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BadgeRepository {
    private final BadgeDao badgeDao;

    @Inject
    public BadgeRepository(BadgeDao badgeDao) {
        this.badgeDao = badgeDao;
    }

    public LiveData<List<Badge>> getAllBadges() {
        return badgeDao.getAll();
    }
}

