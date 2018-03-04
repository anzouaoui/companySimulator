package com.itescia.compagnysimulator;

/**
 * <b> Classe représentant les ressources </b>
 *
 * @author casag
 * @version Prototype
 */

public class Ressources {

    private static Ressources instance = null;
    private int nombre;

    private Ressources() {
        nombre = 0;
    }

    public synchronized static Ressources getInstance() {
        if (instance == null) {
            instance = new Ressources();
        }
        return instance;
    }

    /**
     * Additionne le nombre donné en paramètre au nombre de ressources.
     * @param nombre
     * @author casag
     */
    public synchronized void ajout(int nombre) {
        nombre += nombre;
    }
}