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

        double parite, niveauMoyFormation, niveauMoyFormMark;
        int level;
        // Création joueur et entreprise
        Joueur j = new Joueur("Célia") ;
        Entreprise e = new Entreprise("company");

        // Création employés
        Direction d1 = new Direction('M');
        Marketing m1 = new Marketing('F');
        Marketing m2 = new Marketing('F');
        Comptabilite c1 = new Comptabilite('M');
        Production p1 = new Production('F');

        //Ajout des employés à la collection d'employés
        e.getEmployes().add(d1);
        e.getEmployes().add(m1);
        e.getEmployes().add(m2);
        e.getEmployes().add(c1);
        e.getEmployes().add(p1);

        //Incrémentation de leurs niveau de formation
        d1.incrementNiveauFormation(1);
        m1.incrementNiveauFormation(1);
        m2.incrementNiveauFormation(3);

        //Taux de parité dans l'entreprise
        parite = e.getParite();

        niveauMoyFormation = e.getNiveauMoyenFormation();
        niveauMoyFormMark = e.getNiveauMoyenMarketing();

        e.levelUp();

        level = e.getNiveau();

    }
}
