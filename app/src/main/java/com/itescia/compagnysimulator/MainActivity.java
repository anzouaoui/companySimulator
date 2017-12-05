package com.itescia.compagnysimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itescia.compagnysimulator.Employes.Comptabilite;
import com.itescia.compagnysimulator.Employes.Direction;
import com.itescia.compagnysimulator.Employes.Marketing;
import com.itescia.compagnysimulator.Employes.Production;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        double parite;
        int level;
        Joueur j = new Joueur("Célia") ;
        Entreprise e = new Entreprise("company");

        Direction d1 = new Direction('M');
        Marketing m1 = new Marketing('F');
        Comptabilite c1 = new Comptabilite('M');
        e.getEmployes().add(d1);
        e.getEmployes().add(m1);
        e.getEmployes().add(c1);

        parite = e.getParite();

        Production p1 = new Production('F');
        e.getEmployes().add(p1);

        parite = e.getParite();

        e.levelUp();

        level = e.getNiveau();

        e.levelUp();

    }
}
