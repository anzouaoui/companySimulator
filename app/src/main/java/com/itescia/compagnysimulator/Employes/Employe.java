package com.itescia.compagnysimulator.Employes;

import com.itescia.compagnysimulator.Entreprise;

/**
 * <b> Classe représentant un employé</b>
 *
 * @author casag
 * @version Prototype
 */
public class Employe {

    /** Niveau de formation de l'employé (MAX : 5)
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
        this.niveauFormation = 1;
        this.setSexe(sexe);
    }

    /**
     * Incrémente si possible le niveau de formation de l'employé
     * @param entreprise : l'entreprise du joueur (nécessaire pour accéder au niveau de l'entreprise à ne pas dépasser à travers verificationIncrementNiveauFormation)
     * @param nb : de combien le niveau de formation doit être augmenté
     * @author casag, gbon
     */
    public void incrementNiveauFormation(int nb, Entreprise entreprise){
            if((this.getNiveauFormation() + nb) < 5) {
                this.niveauFormation += nb;
            } else {
                this.niveauFormation = 5;
            }
    }

    /**
     * Vérifie que l'incrémentation du niveau de formation de l'employé ne dépassera pas le niveau de l'entreprise
     * @param entreprise : l'entreprise du joueur (nécessaire pour accéder au niveau de l'entreprise à ne pas dépasser)
     * @param nb : entier représentant le niveau de formation censé être ajouté au niveau actuel
     * @return possibiliteIncrement : true si l'augmentation du niveau de formation de l'employé ne dépasse pas celui de l'entreprise, false dans le cas contraire
     * @author gbon
     */
    public boolean verificationIncrementNiveauFormation(int nb, Entreprise entreprise) {
        boolean possibiliteIncrement = false;
        if(this.niveauFormation + nb < entreprise.getNiveau()) {
            possibiliteIncrement = true;
        }
        return  possibiliteIncrement;
    }

    public int getNiveauFormation() {
        return niveauFormation;
    }

    /**
     * Met à jour le niveau de formation. Ne peut excéder 5.
     * @param niveauFormation
     */
    public void setNiveauFormation(int niveauFormation) {
        if(niveauFormation <= 5){
            this.niveauFormation = niveauFormation;
        } else {
            this.niveauFormation = 5;
        }
    }

    public char getSexe() { return sexe;}

    public void setSexe(char sexe) { this.sexe = sexe; }

}