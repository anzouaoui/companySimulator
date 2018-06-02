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

        // Evénements déclenchés par le joueurs ou les stats :
        Evenement e2 = new Evenement(2, "Les employés ne se sont pas remis du dernier apéro...", "Ouvrir la salle de repos", 0, "Faire intervenir la médecine du travail", 150);
        collectionEvenements.add(e2);

        // Evénements aléatoires :
        Evenement e101 = new Evenement(101, "Plusieurs de vos employés souhaiteraient avoir un babyfoot dans la salle de repos", "Acheter un babyfoot", 500, "Leur dire de se remettre au travail", 0);
        collectionEvenements.add(e101);
        Evenement e102 = new Evenement(102, "La machine à cafés vient de tomber en panne", "Ne rien faire", 0, "Appeler un réparateur", 200);
        collectionEvenements.add(e102);
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
        switch (numEvent) {
            case 1: // Parite           @see MainActivity.GestionEvenements
                if (numChoix == 1) {
                    //do smthg
                } else {
                    //do smthg else
                }
                break;
            case 2: // Trop d'apéros    @see Entreprise.OrganiserApero
                if (numChoix == 1) { // Ouverture de la salle de sieste
                    Ressources.setInstance(Ressources.getInstance() - 15);
                    Toast.makeText(ma, "Le repos des employés a occasionné une baisse des ressources...", Toast.LENGTH_LONG).show();
                } else { // Intervention médecine du travail
                    if (entreprise.payer(getEventByNum(2).getPrix2())) {
                        Toast.makeText(ma, "Les employés vont bien mieux !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... La salle de repos a été ouverte.", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(2, 1, ma);
                    }
                }
                break;
            case 101: // Choix achat babyfoot
                if (numChoix == 1) { // Acheter babyfoot
                    if (entreprise.payer(getEventByNum(101).getPrix1())) {
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                        entreprise.augmenterTauxConditTravail(0.15);
                        Toast.makeText(ma, "Vos employés sont ravis du nouveau babyfoot en salle de repos !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... mais vos employés comprennent et ne vous en veulent pas", Toast.LENGTH_LONG).show();
                    }
                } else { // Refus d'acheter le babyfoot
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                    entreprise.augmenterTauxConditTravail(-0.15);
                    Toast.makeText(ma, "Vos employés sont vraiment décus que vous leur refusier le babyfoot", Toast.LENGTH_LONG).show();
                }
                break;
            case 102: // Machine à cafés en panne
                if (numChoix == 1) { // Ne rien faire
                    entreprise.setBonheur(entreprise.getBonheur() - 0.20);
                    entreprise.augmenterTauxConditTravail(-0.15);
                    Toast.makeText(ma, "Vos employés sont en manque de leur dose de caféine quotidienne", Toast.LENGTH_LONG).show();
                } else { // Faire réparer machine
                    if (entreprise.payer(getEventByNum(102).getPrix2())) {
                        entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                        Toast.makeText(ma, "Vos employés vont pouvoir continuer à boire plus de cafés que de raison !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(102, 1, ma);
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
