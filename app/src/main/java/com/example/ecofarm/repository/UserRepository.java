package com.example.ecofarm.repository;

import androidx.lifecycle.LiveData;

import com.example.ecofarm.data.AppDatabase;
import com.example.ecofarm.data.dao.UserDao;
import com.example.ecofarm.data.model.User;
import com.example.ecofarm.data.prefs.SessionManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final UserDao userDao;
    private final SessionManager sessionManager;

    @Inject
    public UserRepository(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
    }

    public long signUp(String name, String email, String passwordHash) throws Exception {
        User existing = userDao.getByEmailSync(email);
        if (existing != null) {
            throw new Exception("Email already registered");
        }
        User user = new User(name, email, passwordHash, 0);
        long id = userDao.insert(user);
        sessionManager.setLoggedInUserId(id);
        return id;
    }

    public long login(String email, String passwordHash) throws Exception {
        User user = userDao.getByEmailSync(email);
        if (user == null || !passwordHash.equals(user.passwordHash)) {
            throw new Exception("Invalid credentials");
        }
        sessionManager.setLoggedInUserId(user.id);
        return user.id;
    }

    public void logout() {
        sessionManager.logout();
    }

    public boolean isLoggedIn() { return sessionManager.isLoggedIn(); }

    public LiveData<User> getLoggedInUser() {
        long id = sessionManager.getLoggedInUserId();
        return userDao.getById(id);
    }

    public void addPointsToLoggedInUser(int points) {
        long id = sessionManager.getLoggedInUserId();
        if (id != -1) {
            userDao.addPoints(id, points);
        }
    }
}
