package com.itescia.compagnysimulator;

import java.util.concurrent.TimeUnit;

/**
 * Created by casag on 11/04/2018.
 */

public class Temps {
    private static Temps t = null;
    private long startTime;
    private long estimatedTimeMillis;
    private String time;

    public Temps () {
        startTime = System.currentTimeMillis();
    }

    /**
     * Permet de récupérer le temps écoulé
     * @return temps écoulé
     * @author casag
     */
    public synchronized static long getTemps() {
        if (t == null) {
            t = new Temps();
        }
        t.estimatedTimeMillis = System.currentTimeMillis() - t.startTime;
        return t.estimatedTimeMillis;
    }



}
