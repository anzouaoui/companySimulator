package com.itescia.compagnysimulator.Employes;

/**
 * <b> Classe représentant un employé du pôle sécurité (sécurité physique : vigils...)</b> <br>
 * Hérite de la classe Employe
 *
 * @see Employe
 * @author casag
 * @version Prototype
 */

public class Securite extends Employe {

    /** Constructeur de l'employé de sécurité <br>
     * Hérite du constructeur de la super classe
     * @param sexe : Le sexe de l'employé
     */
    public Securite(char sexe){
        super(sexe);
    }

}
