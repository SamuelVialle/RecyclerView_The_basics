package com.samuelvialle.recyclerviewthebasics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerVerticalAdapter extends RecyclerView.Adapter<MyRecyclerVerticalAdapter.MyViewHolder> {

    private Context context;
    private String[] interns, descriptions;
    private int[] avatars;

    public MyRecyclerVerticalAdapter() {
    }

    public MyRecyclerVerticalAdapter(Context context, String[] interns, String[] descriptions, int[] avatars) {
        this.context = context;
        this.interns = interns;
        this.descriptions = descriptions;
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public MyRecyclerVerticalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recycler_vertical, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerVerticalAdapter.MyViewHolder holder, int position) {
        /** On utilise object holder qui hérite de MyRecyclerViewHolder pour peupler nos items **/
        /** Ajout du texte **/
        holder.tvTitle.setText(interns[position]);
        holder.tvDescription.setText(descriptions[position]);
        /** Ajout de l'image avec setImagesRessouces **/
        holder.ivAvatar.setImageResource(avatars[position]);
    }

    @Override
    public int getItemCount() {
        /** Nombre d'items de la liste en comptant le nombre d'images avec lenght **/
        return avatars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvTitle, tvDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
