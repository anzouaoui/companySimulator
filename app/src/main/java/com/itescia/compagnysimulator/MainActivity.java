package com.itescia.compagnysimulator;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewLevel, textViewArgent, textViewHomme, textViewAddRessources;
    Typeface typefaceLevel, typefaceRessource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        initialze();
    }

    private void initialze() {
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

    }
}
