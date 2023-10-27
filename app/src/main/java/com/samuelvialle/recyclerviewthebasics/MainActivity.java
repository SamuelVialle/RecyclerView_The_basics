package com.samuelvialle.recyclerviewthebasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // VARS
    private RecyclerView rvVertical, rvHorizontal;
    private String[] interns, descriptions;

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

    private void init(){
        rvVertical = findViewById(R.id.rv_vertical);
        rvHorizontal = findViewById(R.id.rv_horizontal);
        interns = getResources().getStringArray(R.array.interns);
        descriptions = getResources().getStringArray(R.array.descriptions);
    }

    private void fillRecyclerVertical(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);

        rvVertical.setLayoutManager(linearLayoutManager);

        MyRecyclerVerticalAdapter adapter = new MyRecyclerVerticalAdapter(
                this,interns, descriptions, avatars);

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
        init();
        fillRecyclerVertical();
        fillRecyclerHorizontal();
    }
}