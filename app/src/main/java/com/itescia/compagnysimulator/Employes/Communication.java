package com.itescia.compagnysimulator.Employes;

/**
 * <b> Classe représentant un employé du pôle marketing</b> <br>
 * Hérite de la classe Employe
 *
 * @see Employe
 * @author casag
 * @version Prototype
 */

public class Communication extends Employe {

    /** Constructeur de l'employé de marketing <br>
     * Hérite du constructeur de la super classe
     * @param sexe : Le sexe de l'employé
     */
    public Communication(char sexe){
        super(sexe);
    }
}