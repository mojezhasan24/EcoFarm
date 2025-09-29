package com.example.ecofarm.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecofarm.R;
import com.example.ecofarm.ui.adapter.LeaderboardAdapter;
import com.example.ecofarm.viewmodel.LeaderboardViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LeaderboardActivity extends AppCompatActivity {

    private LeaderboardViewModel viewModel;
    private LeaderboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        RecyclerView rv = findViewById(R.id.rvLeaderboard);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LeaderboardAdapter(new ArrayList<>());
        rv.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);
        viewModel.getLeaderboard().observe(this, users -> {
            adapter.submitList(users);
        });
    }
}

