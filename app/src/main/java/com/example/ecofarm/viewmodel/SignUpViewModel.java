package com.example.ecofarm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecofarm.data.AppDatabase;
import com.example.ecofarm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignUpViewModel extends ViewModel {
    private final UserRepository userRepository;

    private final MutableLiveData<Boolean> signUpSuccess = new MutableLiveData<>(false);
    private final MutableLiveData<String> error = new MutableLiveData<>(null);

    @Inject
    public SignUpViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<Boolean> getSignUpSuccess() { return signUpSuccess; }
    public LiveData<String> getError() { return error; }

    public void signUp(String name, String email, String password, String confirm) {
        if (!password.equals(confirm)) {
            error.setValue("Passwords do not match");
            return;
        }
        new Thread(() -> {
            try {
                String hash = AppDatabase.hash(password);
                userRepository.signUp(name, email, hash);
                signUpSuccess.postValue(true);
            } catch (Exception e) {
                error.postValue(e.getMessage());
            }
        }).start();
    }
}

