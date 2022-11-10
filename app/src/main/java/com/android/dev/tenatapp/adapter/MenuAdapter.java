package com.android.dev.tenatapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.dev.tenatapp.R;
import com.android.dev.tenatapp.databinding.LayoutMenuBinding;
import com.android.dev.tenatapp.model.Menu;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ArrayList<Menu> menuList;

    public MenuAdapter(ArrayList<Menu> menuList) {
        this.menuList = menuList;
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
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutMenuBinding binding;
        public ViewHolder(@NonNull LayoutMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            Menu menu = menuList.get(position);
            binding.tvTitle.setText(menu.getTitle());
            binding.tvTime.setText(menu.getTime());
            binding.ivDishImage.setBackgroundResource(menu.getDishImage());

            switch (position){
                case 1:
                    binding.rlMenu.setBackgroundResource(R.drawable.lunch_background);
                    break;
                case 2:
                    binding.rlMenu.setBackgroundResource(R.drawable.dinner_background);
                    break;
            }
        }
    }
}