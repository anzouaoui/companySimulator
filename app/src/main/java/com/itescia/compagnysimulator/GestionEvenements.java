package com.itescia.compagnysimulator;

import android.app.Activity;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gbon on 04/05/2018.
 */

/**
 * <b> Classe permettant de gérer les évènements</b>
 *
 * @author gbon
 */
public final class GestionEvenements {
    /** L'instance unique GestionEvenement
     * @see GestionEvenements#getGestionEvenements()
     *
     * @author gbon
     */
    private static GestionEvenements e;
    private Entreprise entreprise;
    private ArrayList<Evenement> collectionEvenements;
    private Timer _t;

    private GestionEvenements() {}

    /**
     * Permet de définir la variable entreprise et d'initialiser la collection d'évènements
     *
     * @author gbon, casag
     */
    public void initialize(Entreprise entreprise){
        this.entreprise = entreprise;
        this.collectionEvenements = new ArrayList<Evenement>();

        Evenement e2 = new Evenement(2, "Les employés ne se sont pas remis du dernier apéro...", "Ouvrir la salle de repos", 0, "Faire intervenir la médecine du travail", 150);
        collectionEvenements.add(e2);
    }

    /**
     * Permet de récupérer l'instance de GestionEvenements
     *
     * @return instance de GestionEvenements
     *
     * @author gbon
     */
    public synchronized static GestionEvenements getGestionEvenements() {
        if (GestionEvenements.e == null) {
            e = new GestionEvenements();
        }
        return e;
    }

    /**
     * Permet d'effectuer les traitements en fonction du choix de l'utilisateur lors d'un évènement
     *
     * @param numEvent : numero identifiant de l'évènement
     * @param numChoix : chiffre correspondant au choix du joueur (1 ou 2)
     *
     * @author gbon, casag
     */
    public void doEvent(int numEvent, int numChoix, MainActivity ma) {
        switch (numEvent){
            case 1: // Parite           @see MainActivity.GestionEvenements
                if (numChoix == 1){
                    //do smthg
                } else {
                    //do smthg else
                }
                break;
            case 2: // Trop d'apéros    @see Entreprise.OrganiserApero
                if(numChoix == 1) { // Ouverture de la salle de sieste
                    Ressources.setInstance(Ressources.getInstance() - 15);
                    Toast.makeText(ma, "Le repos des employés a occasionné une baisse des ressources...", Toast.LENGTH_LONG).show();
                } else { // Intervention médecine du travail
                    if(entreprise.payer(getEventByNum(2).getPrix2())) {
                        Toast.makeText(ma, "Les employés vont bien mieux !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... La salle de repos a été ouverte.", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(2, 1, ma);
                    }
                }
                break;
        }
    }

    /**
     * Retourne un evenement de la collection en fonction de son numéro
     * @param num
     * @return Evenement
     * @author casag
     */
    public Evenement getEventByNum(int num) {
        Evenement e = null;
        try {
            for (Evenement evColl : collectionEvenements) {
                if (evColl.getNumero() == num) {
                    e = evColl;
                }
            }
        } catch(Exception ex) {
            String err = ex.toString();
        }
        return e;
    }

}
