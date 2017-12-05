package com.itescia.compagnysimulator.Employes;

import com.itescia.compagnysimulator.Entreprise;

/**
 * <b> Classe représentant un employé</b>
 *
 * @author casag
 * @version Prototype
 */
public class Employe {

    /** Niveau de formation de l'employé
     * @see Employe#getNiveauFormation()
     * @see Employe#setNiveauFormation(int)
     */
    private int niveauFormation;

    /** Sexe de l'employé. 'F' pour une femme et 'H' pour un homme. <br>
     * Permet notamment de déterminer la parité dans l'entreprise.
     * @see Employe#getSexe()
     * @see Employe#setSexe(char)
     * @see Entreprise#getParite()
     */
    private char sexe;

    /** Constructeur de l'employé <br>
     * Le niveau de formation est fixé à 0.
     * @param sexe : Le sexe de l'employé
     */
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

