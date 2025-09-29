package com.example.ecofarm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecofarm.R;
import com.example.ecofarm.data.model.User;

public class LeaderboardAdapter extends ListAdapter<User, LeaderboardAdapter.VH> {

    public LeaderboardAdapter(@NonNull java.util.List<User> initial) {
        super(DIFF);
        submitList(initial);
    }

    private static final DiffUtil.ItemCallback<User> DIFF = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.totalPoints == newItem.totalPoints && oldItem.name.equals(newItem.name);
        }
    };

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        User u = getItem(position);
        holder.rank.setText(String.valueOf(position + 1));
        holder.name.setText(u.name);
        holder.points.setText(String.valueOf(u.totalPoints));
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView rank, name, points;
        VH(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.tvRank);
            name = itemView.findViewById(R.id.tvName);
            points = itemView.findViewById(R.id.tvPoints);
        }
    }
}

