package com.itescia.compagnysimulator;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by casag on 21/11/2017.
 */

public class Entreprise {

    private String nomEntreprise;
    private int niveau;
    private int bonheur;
    private int argent;
    private int nbEmployes;
    private int reputation;
    private int niveauSecuPhysique; //dépend des employés sécurité
    private int niveauSecuInfo; //augmentée en améliorant anti-virus, pare feu...
    private int niveauQualConditionTravail;
    private List<Employe> employes;
    private List<Ressource> ressources;

    public Entreprise (String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.niveau = 1;
        this.bonheur = 50;
        this.argent = 5000;
        this.reputation = 0;
        this.niveauSecuPhysique = 0;
        this.niveauSecuInfo = 0;
        this.niveauQualConditionTravail = 0;
        this.employes = new ArrayList<Employe>();
        this.ressources = new ArrayList<>();
    }

    /*
     * Augmente de niveau l'entreprise
     */
    public void levelUp () {
        this.niveau += 1;
    }

    /*
     * Retourne le taux de femmes dans l'entreprise
     */
    public int getParite(){
        int parite = 0;
        int nbFemmes = 0;
        int nbHommes = 0;
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

    /*
     * Retourne le niveau moyen de sécurité
     */
    public int getNiveauSecu(){
        int niveau = 0;
        niveau = (niveauSecuPhysique + niveauSecuInfo + niveauQualConditionTravail) / 3;
        return niveau;
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

    public int getBonheur() {
        return bonheur;
    }

    public void setBonheur(int bonheur) {
        this.bonheur = bonheur;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    public void setNbEmployes(int nbEmployes) {
        this.nbEmployes = nbEmployes;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getNiveauSecuPhysique() {
        return niveauSecuPhysique;
    }

    public void setNiveauSecuPhysique(int niveauSecuPhysique) {
        this.niveauSecuPhysique = niveauSecuPhysique;
    }

    public int getNiveauSecuInfo() {
        return niveauSecuInfo;
    }

    public void setNiveauSecuInfo(int niveauSecuInfo) {
        this.niveauSecuInfo = niveauSecuInfo;
    }

    public int getNiveauQualConditionTravail() {
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

    public List<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        this.ressources = ressources;
    }




}
