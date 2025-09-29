package com.example.ecofarm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecofarm.R;
import com.example.ecofarm.data.model.Mission;

public class MissionsAdapter extends ListAdapter<Mission, MissionsAdapter.VH> {

    public interface OnMissionClickListener {
        void onMissionClicked(Mission mission);
    }

    private final OnMissionClickListener listener;

    public MissionsAdapter(@NonNull java.util.List<Mission> initial, OnMissionClickListener listener) {
        super(DIFF);
        this.listener = listener;
        submitList(initial);
    }

    private static final DiffUtil.ItemCallback<Mission> DIFF = new DiffUtil.ItemCallback<Mission>() {
        @Override
        public boolean areItemsTheSame(@NonNull Mission oldItem, @NonNull Mission newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Mission oldItem, @NonNull Mission newItem) {
            return oldItem.title.equals(newItem.title) && oldItem.completed == newItem.completed && oldItem.points == newItem.points;
        }
    };

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mission, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Mission m = getItem(position);
        holder.title.setText(m.title);
        holder.points.setText(String.valueOf(m.points));
        holder.itemView.setOnClickListener(v -> listener.onMissionClicked(m));
        holder.status.setText(m.completed ? holder.itemView.getContext().getString(R.string.completed) : holder.itemView.getContext().getString(R.string.pending));
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView title; TextView points; TextView status;
        VH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            points = itemView.findViewById(R.id.tvPoints);
            status = itemView.findViewById(R.id.tvStatus);
        }
    }
}

