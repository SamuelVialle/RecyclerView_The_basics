package com.samuelvialle.recyclerviewthebasics;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerVerticalAdapter extends RecyclerView.Adapter<MyRecyclerVerticalAdapter.MyViewHolder> {
    /**
     * Atributs globaux attentions aux s se sont les tableaux ;)
     **/
    private Context context;
    private String[] interns, descriptions;
    private int[] avatars;
    /**
     * Constructeur vide pour la bonne pratique
     **/
    public MyRecyclerVerticalAdapter() {
    }
    /**
     * Constructeur avec 4 paramètres le contexte, et les 3 tableaux : interns, descriptions et les avatars
     **/
    public MyRecyclerVerticalAdapter(Context context, String[] interns, String[] descriptions, int[] avatars) {
        this.context = context;
        this.interns = interns;
        this.descriptions = descriptions;
        this.avatars = avatars;
    }

    /**
     * Méthodes ajoutées automatiquement lors de la création de la classe
     **/
    @NonNull
    @Override
    public MyRecyclerVerticalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** Création du layout inflater dans le context où il est créé */
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        /** on va remplir layout avec notre custom layout 3 params
         * le fichier layout // la vue parent // à false pour ne pas être attaché à son parent
         *  On va insérer cette inflater dans une view **/
        View view = layoutInflater.inflate(R.layout.item_recycler_vertical, parent, false);
        /** comme ça on peut renvoyer la nouvelle vue - il faut l'instancier la vue en paramètre de
         * MyRecyclerViewHolder vue que l'on est dans la méthode du MyRecyclerViewHolder**/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerVerticalAdapter.MyViewHolder holder, int position) {
//        position = holder.getAdapterPosition();
        /** On utilise object holder qui hérite de MyRecyclerViewHolder pour peupler nos items **/
        /** Ajout du texte **/
        holder.tvTitle.setText(interns[position]);
        holder.tvDescription.setText(descriptions[position]);
        /** Ajout de l'image avec setImagesRessouces **/
        holder.ivAvatar.setImageResource(avatars[position]);

        /** Ajout du listener sur tout le container (contenant) de notre viewHolder **/
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Ajout d'un Intent pour passer à la seconde vue **/
                /** On passe le context où la méthode est exécutée puis la clase de destination **/
                Intent intent = new Intent(context, DetailActivity.class);
                /** On envoie nos datas avec putExtra la clé et la valeur à transmettre **/
                intent.putExtra("intern", interns[position]);
                intent.putExtra("description", descriptions[position]);
                intent.putExtra("avatar", avatars[position]);
                /** On lance l'activité depuis le context en lui passant l'intent **/
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        /** Nombre d'items de la liste en comptant le nombre d'images avec lenght **/
        return avatars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar;
        private TextView tvTitle, tvDescription;
        private ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            /** Le contenu **/
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            /** Le contenant **/
            mainLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
