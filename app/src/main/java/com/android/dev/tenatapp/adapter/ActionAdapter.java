package com.android.dev.tenatapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.dev.tenatapp.databinding.LayoutMenuBinding;
import com.android.dev.tenatapp.model.Action;

import java.util.ArrayList;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ViewHolder> {

    private ArrayList<Action> actionList;

    public ActionAdapter(ArrayList<Action> actionList) {
        this.actionList = actionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutMenuBinding binding = LayoutMenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return actionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutMenuBinding binding;
        public ViewHolder(@NonNull LayoutMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            Action action = actionList.get(position);
            binding.tvTitle.setText(action.getTitle());
            binding.ivDishImage.setBackgroundResource(action.getDishImage());
        }
    }
}