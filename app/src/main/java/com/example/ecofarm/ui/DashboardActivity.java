package com.example.ecofarm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecofarm.R;
import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.ui.adapter.MissionsAdapter;
import com.example.ecofarm.viewmodel.DashboardViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardActivity extends AppCompatActivity implements MissionsAdapter.OnMissionClickListener {

    private DashboardViewModel viewModel;
    private MissionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        viewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        TextView tvName = findViewById(R.id.tvUserName);
        TextView tvPoints = findViewById(R.id.tvUserPoints);
        RecyclerView rv = findViewById(R.id.rvMissions);
        ImageButton btnProfile = findViewById(R.id.btnProfile);
        ImageButton btnLeaderboard = findViewById(R.id.btnLeaderboard);

        adapter = new MissionsAdapter(new ArrayList<>(), this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        btnLeaderboard.setOnClickListener(v -> startActivity(new Intent(this, LeaderboardActivity.class)));

        viewModel.getUser().observe(this, user -> {
            if (user != null) {
                tvName.setText(user.name);
                tvPoints.setText(String.valueOf(user.totalPoints));
            }
        });

        viewModel.getMissions().observe(this, missions -> {
            adapter.submitList(missions);
        });
    }

    @Override
    public void onMissionClicked(Mission mission) {
        Intent i = new Intent(this, MissionDetailActivity.class);
        i.putExtra("mission_id", mission.id);
        startActivity(i);
    }
}

