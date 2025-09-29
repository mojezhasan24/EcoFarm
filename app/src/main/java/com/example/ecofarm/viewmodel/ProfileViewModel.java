package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.model.Badge;
import com.example.ecofarm.data.model.User;
import com.example.ecofarm.repository.BadgeRepository;
import com.example.ecofarm.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ProfileViewModel extends ViewModel {
    private final UserRepository userRepository;
    private final BadgeRepository badgeRepository;

    @Inject
    public ProfileViewModel(UserRepository userRepository, BadgeRepository badgeRepository) {
        this.userRepository = userRepository;
        this.badgeRepository = badgeRepository;
    }

    public LiveData<User> getUser() { return userRepository.getLoggedInUser(); }
    public LiveData<List<Badge>> getBadges() { return badgeRepository.getAllBadges(); }
}

