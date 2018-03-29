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
        nombre = 200;
    }

    public synchronized static int getInstance() {
        if (instance == null) {
            instance = new Ressources();
        }
        return instance.nombre;
    }

    /**
     * Additionne le nombre donné en paramètre au nombre de ressources.
     * @param nb
     * @author casag
     */
    public synchronized static void ajout(int nb) {
        if(Ressources.getInstance() + nb > 100) {
            Ressources.setInstance(100);
        } else {
            instance.nombre += nb;
        }
    }

    /**
     * Met à jour l'instance selon le nombre donné en paramètre
     * @param nb
     * @author casag
     */
    public synchronized static void setInstance(int nb) {
        instance.nombre = nb;
    }

}