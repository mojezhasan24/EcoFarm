package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.AppDatabase;
import com.example.ecofarm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final UserRepository userRepository;

    private final MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>(false);
    private final MutableLiveData<String> error = new MutableLiveData<>(null);

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<Boolean> getLoginSuccess() { return loginSuccess; }
    public LiveData<String> getError() { return error; }

    public void login(String email, String password) {
        new Thread(() -> {
            try {
                String hash = AppDatabase.hash(password);
                userRepository.login(email, hash);
                loginSuccess.postValue(true);
            } catch (Exception e) {
                error.postValue(e.getMessage());
            }
        }).start();
    }
}

