package com.samuelvialle.recyclerviewthebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    /** Attributs globaux  **/
    TextView stagiaire, desc;
    ImageView avatar;

    /** On crée 2 String pour stocker data1 et data2  et un int pour l'image **/
    String s_stagiaire, s_desc;
    int img_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /** 29 fbc des attributs **/
        stagiaire = (TextView) findViewById(R.id.tv2_stagiaire);
        desc = (TextView) findViewById(R.id.tv2_desc);
        avatar = (ImageView) findViewById(R.id.iv2_avatar);

        getData();
        setData();

    }

    /** Méthode pour récupérer les datas depuis Intent **/
    private void getData(){
        /** On vérifie que l'intent à bien des datas à passer **/
        if(getIntent().hasExtra("intern")
                && getIntent().hasExtra("description")
                && getIntent().hasExtra("avatar")){

            /** on récupère les datas et on les stocke **/
            s_stagiaire = getIntent().getStringExtra("intern");
            s_desc = getIntent().getStringExtra("description");
            img_avatar = getIntent().getIntExtra("avatar", 1 );
        } else {
            /** sinon on affiche un Toast **/
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    /** Méthode setData pour afficher les datas dans les bons emplacements **/
    private void setData(){
        stagiaire.setText(s_stagiaire);
        desc.setText(s_desc);
        /** pour l'imageView on vue utiliser setImagesRessources avec comme param le int **/
        avatar.setImageResource(img_avatar);
    }
}