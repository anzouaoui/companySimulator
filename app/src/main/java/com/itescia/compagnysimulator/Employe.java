package com.itescia.compagnysimulator;

/**
 * Created by casag on 21/11/2017.
 */

public class Employe {

    private int niveauFormation;

    private char sexe;

    public Employe(char sexe){
        this.niveauFormation = 0;
        this.setSexe(sexe);
    }

    public int getNiveauFormation() {
        return niveauFormation;
    }

    public void setNiveauFormation(int niveauFormation) {
        this.niveauFormation = niveauFormation;
    }

    public char getSexe() { return sexe;}

    public void setSexe(char sexe) { this.sexe = sexe; }


}

