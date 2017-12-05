package com.itescia.compagnysimulator;
import com.itescia.compagnysimulator.Employes.Employe;
import com.itescia.compagnysimulator.Employes.Securite;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> Classe représentant l'entreprise du joueur</b>
 *
 * @see Joueur
 *
 * @author casag
 * @version Prototype
 */

public class Entreprise {
    /** Nom de l'entreprise
     * @see Entreprise#getNomEntreprise()
     * @see Entreprise#setNomEntreprise(String)
     */
    private String nomEntreprise;

    /** Niveau général de l'entreprise
     * @see Entreprise#getNiveau()
     * @see Entreprise#setNiveau(int)
     */
    private int niveau;

    /** Taux de bonheur dans l'entreprise. <br>
     *  Dépend du niveau de formation général des employés, de la réputation, <br>
     *  du taux global de sécurité et du niveau de qualité des conditions de travail
     * @see Entreprise#getBonheur()
     * @see Entreprise#setBonheur(int)
     * @see Entreprise#getNiveauMoyenFormation()
     * @see Entreprise#getNiveauSecuGlobal()
     * @see Entreprise#levelUp()
     */
    private double bonheur;

    /** Argent possédé dans l'entreprise <br>
     *  S'incrémente constamment en fonction du niveau de compétences des employés
     *  et du niveau de bonheur : <br>
     *  40% Comptabilité | 30% bonheur | 10% Production | 10% Commercial | 10% Marketing
     * @see Entreprise#getArgent()
     * @see Entreprise#setArgent(int)
     */
    private double argent;

    /** Niveau de réputation de l'entreprise <br>
     * S'améliorera ou se déteriorera en fonction d'actions à lancer (campagnes de com...)
     * ou d'évènements aléatoire (grèves...)
     * @see Entreprise#getReputation()
     * @see Entreprise#setReputation(int)
     */
    private double reputation;

    /** Niveau de réputation de l'entreprise <br>
     * S'améliorera ou se déteriorera en fonction d'actions à lancer (campagnes de com...)
     * ou d'évènements aléatoire (grèves...)
     * @see Entreprise#getReputation()
     * @see Entreprise#setReputation(int)
     */

    //private int niveauSecuPhysique; //dépend des employés sécurité : voir fonction

    /** Niveau de sécurité informatique <br>
     * S'augmentera en améliorant anti-virus, pare feu...
     * @see Entreprise#getNiveauSecuInfo()
     * @see Entreprise#setNiveauSecuInfo(int)
      */
    private double niveauSecuInfo;

    /** Niveau de qualité des conditions de travail <br>
     * S'améliorera en montant de niveau ou en lançant des actions visant
     * à l'améliorer (achat de sièges confortables...)
     * @see Entreprise#getNiveauQualConditionTravail()
     * @see Entreprise#setNiveauQualConditionTravail(int)
     */
    private double niveauQualConditionTravail;

    /** Liste des employés de l'entreprise
     * @see Employe
     * @see Entreprise#getEmployes()
     * @see Entreprise#setEmployes(List)
     */
    private List<Employe> employes;

    /** Ressources de l'entreprise
     * @see Ressources
     * @see Entreprise#getRessources()
     * @see Entreprise#setRessources(List)
     */
    private List<Ressources> ressources;

    /** Constructeur de l'entreprise <br>
     * Le niveau est fixé à 1. <br>
     * Le bonheur est fixé à 0.5 (moyenne) <br>
     * L'argent est fixé à 5000.
     * @param nomEntreprise : Le nom de l'entreprise
     */
    public Entreprise (String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.niveau = 1;
        this.bonheur = 0.5;
        this.argent = 5000;
        this.reputation = 0;
        this.niveauSecuInfo = 0;
        this.niveauQualConditionTravail = 0;
        this.employes = new ArrayList<Employe>();
        this.ressources = new ArrayList<>();
    }

    /**
     * Incrémente le niveau
     * @author casag
     */
    public void levelUp () {
        this.niveau += 1;
    }

    /**
     * Retourne le taux de femmes dans l'entreprise
     * @return parité : Taux de femmes dans l'entreprise
     * @author casag
     */
    public double getParite(){
        double parite = 0;
        double nbFemmes = 0;
        double nbHommes = 0;
        for (Employe e : employes) {
            if (e.getSexe() == 'F') {
                nbFemmes += 1;
            } else {
                nbHommes += 1;
            }
        }
        parite = nbFemmes / (nbFemmes + nbHommes);
        return parite;
    }

    /**
     * Retourne le niveau de formation moyen des employés
     * @return niveauGlobal : niveau de formation moyen des employés
     * @author casag
     */
    public double getNiveauMoyenFormation(){
        int nbEmp = 0 ;
        int somme = 0 ;
        double niveauGlobal;
        //Parcours de la liste d'employés
        for (Employe emp : employes) {
            //On additionne le niveau de formation de chaque employé et on les compte
            somme += emp.getNiveauFormation();
            nbEmp += 1;
        }
        //Calcul moyenne
        niveauGlobal = somme / nbEmp;
        return niveauGlobal;
    }

    /**
     * Retourne le niveau de formation moyen des employés de sécurité
     * @return niveauGlobal : niveau de formation moyen des employés de sécurité
     * @author casag
     */
    public double getNiveauMoyenSecuPhysique() {
        int nbEmp = 0 ;
        int somme = 0 ;
        double niveauGlobal;
        //Parcours de la liste d'employés
        for (Employe emp : employes) {
            //On additionne le niveau de formation de chaque employé de sécurité et on les compte
            if(emp instanceof Securite){
                somme += emp.getNiveauFormation();
                nbEmp += 1;
            }
        }
        //Calcul moyenne
        niveauGlobal = somme / nbEmp;
        return niveauGlobal;
    }

    /**
     * Retourne le niveau moyen de sécurité dans l'entreprise <br>
     * Prend en compte le niveau de sécurité physique par rapport aux compétences
     * des employés de sécurité, le niveau de sécurité informatique et le niveau
     * de qualité de travail.
     * @return niveau : Niveau de sécurité global
     * @author casag
     */
    public double getNiveauSecuGlobal(){
        double niveau = 0;
        niveau = (getNiveauMoyenSecuPhysique() + niveauSecuInfo + niveauQualConditionTravail) / 3;
        return niveau;
    }

    public void incremArgent(){
        this.argent +=1;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public double getBonheur() {
        return bonheur;
    }

    public void setBonheur(int bonheur) {
        this.bonheur = bonheur;
    }

    public double getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }


    public double getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public double getNiveauSecuInfo() {
        return niveauSecuInfo;
    }

    public void setNiveauSecuInfo(int niveauSecuInfo) {
        this.niveauSecuInfo = niveauSecuInfo;
    }

    public double getNiveauQualConditionTravail() {
        return niveauQualConditionTravail;
    }

    public void setNiveauQualConditionTravail(int niveauQualConditionTravail) {
        this.niveauQualConditionTravail = niveauQualConditionTravail;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Ressources> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressources> ressources) {
        this.ressources = ressources;
    }




}
