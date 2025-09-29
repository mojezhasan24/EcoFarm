package com.example.ecofarm.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecofarm.R;
import com.example.ecofarm.data.model.Mission;
import com.example.ecofarm.viewmodel.MissionDetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MissionDetailActivity extends AppCompatActivity {

    private MissionDetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_detail);

        long id = getIntent().getLongExtra("mission_id", -1);
        if (id == -1) { finish(); return; }

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvDesc = findViewById(R.id.tvDescription);
        TextView tvPoints = findViewById(R.id.tvPoints);
        Button btnComplete = findViewById(R.id.btnComplete);

        viewModel = new ViewModelProvider(this).get(MissionDetailViewModel.class);
        viewModel.getMission(id).observe(this, mission -> {
            if (mission == null) return;
            tvTitle.setText(mission.title);
            tvDesc.setText(mission.description);
            tvPoints.setText(String.valueOf(mission.points));
            btnComplete.setEnabled(!mission.completed);
            btnComplete.setOnClickListener(v -> {
                viewModel.complete(mission);
                finish();
            });
        });
    }
}

