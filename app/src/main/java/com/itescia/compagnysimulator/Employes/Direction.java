package com.itescia.compagnysimulator.Employes;

/**
 * <b> Classe représentant un employé du pôle direction</b> <br>
 * Hérite de la classe Employe
 *
 * @see Employe
 * @author casag
 * @version Prototype
 */

public class Direction extends Employe {

    /** Constructeur de l'employé de direction <br>
     * Hérite du constructeur de la super classe
     * @param sexe : Le sexe de l'employé
     */
    public Direction(char sexe){
        super(sexe);
    }
}
