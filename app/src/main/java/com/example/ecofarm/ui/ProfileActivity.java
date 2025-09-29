package com.example.ecofarm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecofarm.R;
import com.example.ecofarm.repository.UserRepository;
import com.example.ecofarm.viewmodel.ProfileViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileActivity extends AppCompatActivity {

    private ProfileViewModel viewModel;

    @Inject
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPoints = findViewById(R.id.tvPoints);
        Button btnLogout = findViewById(R.id.btnLogout);

        viewModel.getUser().observe(this, user -> {
            if (user != null) {
                tvName.setText(user.name);
                tvEmail.setText(user.email);
                tvPoints.setText(String.valueOf(user.totalPoints));
            }
        });

        btnLogout.setOnClickListener(v -> {
            userRepository.logout();
            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        });
    }
}

