package com.samuelvialle.recyclerviewthebasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /**
     * Attributs globaux
     **/
    private RecyclerView rvVertical, rvHorizontal;
    /**
     * Déclaration des tableaux de String
     **/
    private String[] interns, descriptions;
    /**
     * Déclaration du tableau des images
     **/
    private int[] avatars = {
            R.drawable.stagiaire_01,
            R.drawable.stagiaire_02,
            R.drawable.stagiaire_03,
            R.drawable.stagiaire_04,
            R.drawable.stagiaire_05,
            R.drawable.stagiaire_06,
            R.drawable.stagiaire_07,
            R.drawable.stagiaire_08,
            R.drawable.stagiaire_09,
            R.drawable.stagiaire_010,
            R.drawable.stagiaire_011,
            R.drawable.stagiaire_012,
            R.drawable.stagiaire_013,
            R.drawable.stagiaire_014
    };

    /**
     * Méthode pour initialiser le design et les données avec le code
     **/
    private void init(){
        rvVertical = findViewById(R.id.rv_vertical);
        rvHorizontal = findViewById(R.id.rv_horizontal);
        // Liens vers les tableaux du fichier strings
        interns = getResources().getStringArray(R.array.interns);
        descriptions = getResources().getStringArray(R.array.descriptions);
    }

    private void fillRecyclerVertical(){
        // Ajout d'un nouveau LinearLayout pour contenir les vues du RecyclerView
        // On peut alors choisir l'orientation vertical ou horizontal et inverser la sélection
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        // Ajout du linearLayoutManager au recyclerView
        rvVertical.setLayoutManager(linearLayoutManager);
        // Déclaration de l'adapter
        MyRecyclerVerticalAdapter adapter = new MyRecyclerVerticalAdapter(
                this,interns, descriptions, avatars);
        // Ajout de l'adapteur au recyclerView
        rvVertical.setAdapter(adapter);
    }

    private void fillRecyclerHorizontal(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);
        rvHorizontal.setLayoutManager(linearLayoutManager);

        MyRecyclerHorizontalAdapter adapter = new MyRecyclerHorizontalAdapter(
                this, interns, avatars);
        rvHorizontal.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** Appel des méthodes **/
        init();
        fillRecyclerVertical();
        fillRecyclerHorizontal();
    }
}