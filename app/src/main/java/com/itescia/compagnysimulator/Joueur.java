package com.itescia.compagnysimulator;

/**
 * <b>Classe représentant l'utilisateur du jeu</b>
 *
 * @author casag
 * @version Prototype
 */

public class Joueur {
    /**
     * Le nom du joueur du joueur
     * @see Joueur#getNomJoueur()
     * @see Joueur#setNomJoueur(String)
     */
    private String nomJoueur;

    public Joueur(String nomJoueur){
        this.nomJoueur = nomJoueur;
    }

    /**
     * Retourne le nom du joueur
     * @return le nom du joueur courant
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * Met à jour le nom du joueur
     * @param nomJoueur
     *        Le nouveau nom du joueur
     */
    public void setNomJoueur(String nomJoueur) {

        this.nomJoueur = nomJoueur;
    }

}
