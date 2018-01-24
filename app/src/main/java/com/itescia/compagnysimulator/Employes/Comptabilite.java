package com.itescia.compagnysimulator.Employes;

/**
 * <b> Classe représentant un employé du pôle comptabilité </b> <br>
 * Hérite de la classe Employe
 *
 * @see Employe
 * @author casag
 * @version Prototype
 */

public class Comptabilite extends Employe {

    /** Constructeur de l'employé comptable <br>
     * Hérite du constructeur de la super classe
     * @param sexe : Le sexe de l'employé
     */
    public Comptabilite(char sexe){
        super(sexe);
    }
}
