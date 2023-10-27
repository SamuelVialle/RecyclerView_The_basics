package com.samuelvialle.recyclerviewthebasics;

import android.content.Context;
import android.view.ContentInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerHorizontalAdapter extends RecyclerView.Adapter<MyRecyclerHorizontalAdapter.MyViewHolder> {

    private Context context;

    private String[] interns;
    private int[] avatars;

    public MyRecyclerHorizontalAdapter() {
    }

    public MyRecyclerHorizontalAdapter(Context context, String[] interns, int[] avatars) {
        this.context = context;
        this.interns = interns;
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public MyRecyclerHorizontalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recycler_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerHorizontalAdapter.MyViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        holder.tvTitle.setText(interns[position]);
        holder.ivAvatar.setImageResource(avatars[position]);
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView ivAvatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
