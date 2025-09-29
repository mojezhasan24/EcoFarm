package com.example.ecofarm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecofarm.R;
import com.example.ecofarm.viewmodel.SignUpViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignUpActivity extends AppCompatActivity {

    private SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        EditText nameEt = findViewById(R.id.etName);
        EditText emailEt = findViewById(R.id.etEmail);
        EditText passwordEt = findViewById(R.id.etPassword);
        EditText confirmEt = findViewById(R.id.etConfirm);
        Button signUpBtn = findViewById(R.id.btnSignUp);
        TextView goLogin = findViewById(R.id.tvGoLogin);

        signUpBtn.setOnClickListener(v -> {
            viewModel.signUp(
                    nameEt.getText().toString().trim(),
                    emailEt.getText().toString().trim(),
                    passwordEt.getText().toString(),
                    confirmEt.getText().toString()
            );
        });

        goLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        viewModel.getSignUpSuccess().observe(this, success -> {
            if (success != null && success) {
                startActivity(new Intent(this, DashboardActivity.class));
                finish();
            }
        });

        viewModel.getError().observe(this, err -> {
            if (err != null) {
                Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

