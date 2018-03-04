package com.itescia.compagnysimulator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by anoukzouaoui on 26/02/2018.
 */

public class StartActivity extends AppCompatActivity {
    TextView textViewLabelNomJoueur, textViewLabelNomEntreprise;

    EditText editTextNomJoueur, editTextNomEntreprise;

    ImageButton imageButtonStart;

    Typeface typefaceLevel, typefaceRessource, typefaceLvl, typefaceMaj;

    public final static String EXTRA_NOM_JOUEUR = "Nom du joueur";
    public final static String EXTRA_NOM_ENTREPRISE = "Nom de l'entreprise";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
        bindListener();
    }

    /**
     * Fonction permettant d'initialiser les éléments du graphique principale
     */
    private void initialize() {
        typefaceLevel = Typeface.createFromAsset(getAssets(), "font/fipps_regular.ttf");
        typefaceRessource = Typeface.createFromAsset(getAssets(), "font/Pixeled.ttf");
        typefaceLvl = Typeface.createFromAsset(getAssets(), "font/retganon.ttf");
        //typefaceMaj = Typeface.createFromAsset(getAssets(), "font/pixelArial.ttf");

        //ELEMENTS TEXTES
        textViewLabelNomJoueur = (TextView) findViewById(R.id.TextViewLabelNomJoueur);
        textViewLabelNomEntreprise = (TextView) findViewById(R.id.TextViewLabelNomEntreprise);

        textViewLabelNomJoueur.setTypeface(typefaceLevel);
        textViewLabelNomEntreprise.setTypeface(typefaceLevel);

        //ELEMENTS SAISI TEXTES
        editTextNomJoueur = (EditText) findViewById(R.id.EditTextNomJoueur);
        editTextNomEntreprise = (EditText) findViewById(R.id.EditTextNomEntreprise);

        //ELEMENTS IMAGE BUTTON
        imageButtonStart = (ImageButton) findViewById(R.id.ImageButtonStart);
    }

    /**
     * Fonction permettant d'initialiser les événements liés aux éléments du graphique
     */
    private void bindListener() {
        imageButtonStart.setOnClickListener(imageButtonStartListener);
    }

    private View.OnClickListener imageButtonStartListener = new View.OnClickListener() {
        /**
         * Fonction permettant de commencer le jeu
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            Intent intentStart = new Intent(StartActivity.this, MainActivity.class);
            intentStart.putExtra(EXTRA_NOM_JOUEUR, editTextNomJoueur.getText().toString());
            intentStart.putExtra(EXTRA_NOM_ENTREPRISE, editTextNomEntreprise.getText().toString());
            startActivity(intentStart);
        }
    };
}
