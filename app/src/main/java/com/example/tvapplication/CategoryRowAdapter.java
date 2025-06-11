package com.example.tvapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryRowAdapter extends RecyclerView.Adapter<CategoryRowAdapter.CategoryViewHolder> {

    private final Context context;
    private final OnMovieSelectedListener listener;
    private final List<MovieModel.Result> categoryList = new ArrayList<>();

    public interface OnMovieSelectedListener {
        void onMovieSelected(MovieModel.Result.Detail item);
    }

    public CategoryRowAdapter(Context context, OnMovieSelectedListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setCategoryList(List<MovieModel.Result> newList) {
        Log.d("CategoryRowAdapter", "setCategoryList: received " + (newList != null ? newList.size() : 0) + " items");
        categoryList.clear();
        if (newList != null) {
            categoryList.addAll(newList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_row, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategoryTitle;
        RecyclerView recyclerInner;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategoryTitle = itemView.findViewById(R.id.txt_category_title);
            recyclerInner = itemView.findViewById(R.id.recycler_inner);
        }

        void bind(MovieModel.Result category) {
            txtCategoryTitle.setText(category.getTitle());
            recyclerInner.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerInner.setFocusable(true);
            recyclerInner.setFocusableInTouchMode(true);
            recyclerInner.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
            recyclerInner.setHasFixedSize(true);
            recyclerInner.setClipToPadding(false);
            recyclerInner.setClipChildren(false);
            MovieAdapter adapter = new MovieAdapter(category.getDetails(), listener);
            recyclerInner.setAdapter(adapter);
        }
    }
}

