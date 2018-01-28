package com.itescia.compagnysimulator;


import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itescia.compagnysimulator.Employes.Commercial;
import com.itescia.compagnysimulator.Employes.Comptabilite;
import com.itescia.compagnysimulator.Employes.Direction;
import com.itescia.compagnysimulator.Employes.Marketing;
import com.itescia.compagnysimulator.Employes.Production;
import com.itescia.compagnysimulator.Employes.Securite;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView textViewLevel, textViewArgent, textViewHomme, textViewAddRessources, textViewNomJoueur;
    Typeface typefaceLevel, typefaceRessource;
    ProgressBar progressBarReputation, progressBarSecurite, progressBarFormation, progressBarBonheur, progressBarRessources;
    Timer _t;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
        bindListener();
        incrementeArgent();
    }

    /**
     * Fonction permettant d'initialiser les éléments du graphique principale
     */
    private void initialize() {
        //ELEMENTS TEXTES
        textViewLevel = (TextView) findViewById(R.id.TextViewLevel);
        typefaceLevel = Typeface.createFromAsset(getAssets(), "font/fipps_regular.ttf");
        textViewNomJoueur = (TextView) findViewById(R.id.TextViewNomJoueur);
        textViewLevel.setTypeface(typefaceLevel);
        textViewNomJoueur.setTypeface(typefaceLevel);
        textViewNomJoueur.setVisibility(View.GONE);
        textViewArgent = (TextView) findViewById(R.id.TextViewArgent);
        textViewArgent.setText("0");
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

    /**
     * Fonction permettant d'initialiser les événements liés aux éléments du graphique
     */
    private void bindListener() {
        textViewLevel.setOnClickListener(textViewLevelListener);
    }

    /**
     * Fonction permettant d'incrémenter automatiquement l'argent
     */
    private void incrementeArgent() {
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 10000) {
                            textViewArgent.setText(String.valueOf(count));
                        } else {
                            _t.cancel();
                        }
                    }
                });
            }
        }, 500, 500);
    }


    private View.OnClickListener textViewLevelListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettaant d'afficher le nom du joueur
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                textViewNomJoueur.setVisibility(View.VISIBLE);
                show = true;
            } else {
                textViewNomJoueur.setVisibility(View.GONE);
                show = false;
            }
        }
    };
}
