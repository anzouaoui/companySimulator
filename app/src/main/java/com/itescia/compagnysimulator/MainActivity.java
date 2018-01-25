package com.itescia.compagnysimulator;


import android.graphics.Typeface;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itescia.compagnysimulator.Employes.Commercial;
import com.itescia.compagnysimulator.Employes.Comptabilite;
import com.itescia.compagnysimulator.Employes.Direction;
import com.itescia.compagnysimulator.Employes.Marketing;
import com.itescia.compagnysimulator.Employes.Production;
import com.itescia.compagnysimulator.Employes.Securite;

public class MainActivity extends AppCompatActivity {

    TextView textViewLevel, textViewArgent, textViewHomme, textViewAddRessources;
    Typeface typefaceLevel, typefaceRessource;
    ProgressBar progressBarReputation, progressBarSecurite, progressBarFormation, progressBarBonheur, progressBarRessources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        initialize();
    }

    /**
     * Fonction permettant d'initialiser les éléments du graphique principale
     */
    private void initialize() {
        //ELEMENTS TEXTES
        textViewLevel = (TextView) findViewById(R.id.TextViewLevel);
        typefaceLevel = Typeface.createFromAsset(getAssets(), "font/fipps_regular.ttf");
        textViewLevel.setTypeface(typefaceLevel);
        textViewArgent = (TextView) findViewById(R.id.TextViewArgent);
        textViewHomme = (TextView) findViewById(R.id.TextViewHomme);
        textViewAddRessources = (TextView) findViewById(R.id.TextViewAddRessources);
        typefaceRessource = Typeface.createFromAsset(getAssets(), "font/Pixeled.ttf");
        textViewArgent.setTypeface(typefaceRessource);
        textViewHomme.setTypeface(typefaceRessource);
        textViewAddRessources.setTypeface(typefaceRessource);

        //ELEMENTS PROGRESSBAR
        progressBarBonheur = (ProgressBar) findViewById(R.id.ProgressBarBonheur);
        progressBarBonheur.setProgress(30);
        progressBarFormation = (ProgressBar) findViewById(R.id.ProgressBarFormation);
        progressBarFormation.setProgress(30);
        progressBarReputation = (ProgressBar) findViewById(R.id.ProgressBarReputation);
        progressBarReputation.setProgress(30);
        progressBarRessources = (ProgressBar) findViewById(R.id.ProgressBarRessources);
        progressBarRessources.setProgress(30);
        progressBarSecurite = (ProgressBar) findViewById(R.id.ProgressBarSecurite);
        progressBarSecurite.setProgress(30);
    }
}
