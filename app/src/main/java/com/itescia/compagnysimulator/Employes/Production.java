package com.itescia.compagnysimulator.Employes;

/**
 * <b> Classe représentant un employé du pôle production</b> <br>
 * Hérite de la classe Employe
 *
 * @see Employe
 * @author casag
 * @version Prototype
 */

public class Production extends Employe {

    /** Constructeur de l'employé de production <br>
     * Hérite du constructeur de la super classe
     * @param sexe : Le sexe de l'employé
     */
    public Production(char sexe){
        super(sexe);
    }
}
