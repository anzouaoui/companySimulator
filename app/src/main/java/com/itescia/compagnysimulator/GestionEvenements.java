package com.itescia.compagnysimulator;

import java.util.ArrayList;
import java.util.List;

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
    private static GestionEvenements e = null;

    /** L'entreprise du joueur
     *
     * @author gbon
     */
    private Entreprise entreprise;

    /** La collection d'évènements
     *
     * @author gbon
     */
    private ArrayList<Evenement> collectionEvenements;

    private GestionEvenements() {}

    /**
     * Permet de définir la variable entreprise et d'initialiser la collection d'évènements
     *
     * @author gbon
     */
    public void initialize(Entreprise entreprise){
        this.entreprise = entreprise;
        this.collectionEvenements = new ArrayList<Evenement>();
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
     * @author gbon
     */
    public void doEvent(int numEvent, int numChoix) {
        switch (numEvent){
            case 1:
                if (numChoix == 1){
                    //do smthg
                } else {
                    //do smthg else
                }
                break;
            case 2:
                break;
        }
    }

}
