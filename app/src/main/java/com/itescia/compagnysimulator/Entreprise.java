package com.itescia.compagnysimulator;
import com.itescia.compagnysimulator.Employes.Commercial;
import com.itescia.compagnysimulator.Employes.Communication;
import com.itescia.compagnysimulator.Employes.Comptabilite;
import com.itescia.compagnysimulator.Employes.Employe;
import com.itescia.compagnysimulator.Employes.Production;
import com.itescia.compagnysimulator.Employes.Securite;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


import java.util.ArrayList;
import java.util.List;
import java.lang.*;

/**
 * <b> Classe représentant l'entreprise du joueur</b>
 *
 * @see Joueur
 *
 * @author casag, gbon
 * @version Prototype
 */

public class Entreprise {
    /** Nom de l'entreprise
     *
     * @see Entreprise#getNomEntreprise()
     * @see Entreprise#setNomEntreprise(String)
     */
    private String nomEntreprise;

    /** Niveau général de l'entreprise
     *
     * @see Entreprise#getNiveau()
     * @see Entreprise#setNiveau(double)
     */
    private double niveau;

    /** Taux de bonheur dans l'entreprise. <br>
     *  Dépend du niveau de formation général des employés, de la réputation, <br>
     *  du taux global de sécurité et du niveau de qualité des conditions de travail
     *
     * @see Entreprise#getBonheur()
     * @see Entreprise#setBonheur(double)
     * @see Entreprise#getNiveauMoyenFormation()
     */
    private double bonheur;

    /** Argent possédé dans l'entreprise <br>
     *  S'incrémente constamment en fonction du niveau de compétences des employés
     *  et du niveau de bonheur : <br>
     *  40% Comptabilité | 30% bonheur | 10% Production | 10% Commercial | 10% Communication
     *
     * @see Entreprise#getArgent()
     * @see Entreprise#setArgent(int)
     */
    private int argent;

    /** Taux de réputation de l'entreprise <br>
     * S'améliorera ou se déteriorera en fonction d'actions à lancer (campagnes de com...)
     * ou d'évènements aléatoire (grèves...)
     *
     * @see Entreprise#getReputation()
     * @see Entreprise#setReputation(double)
     */
    private double reputation;

    /**
     * Taux de formation en sécurité informatique des employés de l'entreprise
     */
    private double tauxFormationSecuInfo;

    //private int niveauSecuPhysique; //dépend des employés sécurité : voir fonction


    /** Niveau de qualité des conditions de travail <br>
     * S'améliorera en montant de niveau ou en lançant des actions visant
     * à l'améliorer (achat de sièges confortables...)
     *
     * @see Entreprise#getTauxQualConditionTravail()
     * @see Entreprise#setTauxQualConditionTravail(double)
     */
    private double tauxQualConditionTravail;

    /**
     * Niveau actuel du mobilier de bureau
     */
    private int niveauMobilier;

    /**
     * Nom/marque actuelle du mobilier de bureau
     */
    private String nomMobilier;

    /**
     * Nombre d'heures passées depuis la dernière intervention de la médecine du travail
     */
    private int derniereInterventionMedecineTravail;

    /**
     * Nombre d'heures passées depuis la dernière intervention du personnel de ménage
     */
    private int derniereInterventionMenage;

    /**
     * Date du dernier apéro organisé
     */
    private Date dernierApero;

    private int nombreApero;

    /**
     * Dernière félicitation aléatoire d'un employé
     */
    private Date derniereFelicitation;

    /** 
     * Liste des employés de l'entreprise
     *
     * @see Employe
     * @see Entreprise#getEmployes()
     * @see Entreprise#setEmployes(List)
     */

    //private int niveauSecuPhysique; //dépend des employés sécurité : voir fonction

    /** Niveau de sécurité informatique <br>
     * S'augmentera en améliorant anti-virus, pare feu...
     *
     * @see Entreprise#getTauxSecuInfo()
     * @see Entreprise#setTauxSecuInfo(double)
     */
    private double tauxSecuInfo;

    /**
     * Niveau actuel de l'antivirus
     */
    private int niveauAntivirus;

    /**
     * Nom actuel de l'antivirus (ex: "Nom VX.X")
     */
    private String nomAntivirus;

    /**
     * Nombre d'heures passées depuis la dernière MAJ du firewall
     */
    private int derniereMAJFirewall;

    /**
     * Nombre d'heures passées depuis la dernière MAJ du système
     */
    private int derniereMAJSysteme;

    private List<Employe> employes;

    private int indiceDecrem;

    private int indiceIncremArgent;

    /** Constructeur de l'entreprise <br>
     * Le niveau est fixé à 1. <br>
     * Le bonheur est fixé à 0.5 (moyenne) <br>
     * L'argent est fixé à 5000.
     *
     * @param nomEntreprise : Le nom de l'entreprise
     */
    public Entreprise (String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.niveau = 1;
        this.bonheur = 0.5;
        this.argent = 100;
        this.reputation = 0.5;
        this.tauxSecuInfo = 0.5;
        this.tauxFormationSecuInfo = 0.5;
        this.tauxQualConditionTravail = 0.5;
        this.niveauAntivirus = 1;
        this.nomAntivirus = "Aviro v1.1";
        this.derniereMAJFirewall = 0;
        this.derniereMAJSysteme = 0;
        this.nomMobilier = "Ikeo";
        this.niveauMobilier = 1;
        this.derniereInterventionMedecineTravail = 0;
        this.derniereInterventionMenage = 0;
        this.dernierApero = null;
        this.nombreApero = 0;
        this.derniereFelicitation = null;
        this.employes = new ArrayList<Employe>();
        this.indiceDecrem = 1;
        this.indiceIncremArgent = 10;
        Ressources.getInstance();
    }

    /**
     * Augmente le niveau du nombre donné en paramètre
     *
     * @param nombre
     * @author casag
     */
    /*public void levelUp(double nombre) {
        setNiveau(this.niveau + nombre);
    }*/

    /**
     * Soustrait le nombre donné en paramètre à l'argent.
     *
     * @param number : prix
     * @return booléen : false si le joueur n'a pas assez d'argent pour payer.
     * @author casag
     */
    public boolean payer(int number) {
        boolean done = false;
        if (this.argent >= number) {
            setArgent(this.argent - number);
            done = true;
        }
        return done;
    }

    /**
     * Retourne le taux de femmes dans l'entreprise
     *
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
     * Retourne le niveau de formation moyen des employés du service donné en paramètre.
     *
     * @param service : service
     * @return niveauGlobal : niveau de formation moyen
     * @author casag
     */
    public double getNiveauMoyenDomaine(String service) {
        int nbEmp = 0 ;
        double somme = 0 ;
        double niveauGlobal = 0;
        //Parcours de la liste d'employés
        for (Employe emp : employes) {
            //On additionne le niveau de formation de chaque employé de sécurité et on les compte
            switch (service) {
                case "Commercial" :
                    if(emp instanceof Commercial){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
                case "Comptabilite" :
                    if(emp instanceof Comptabilite){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
                case "Communication" :
                    if(emp instanceof Communication){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
                case "Production" :
                    if(emp instanceof Production){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
                case "Securite" :
                    if(emp instanceof Securite){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
            }
        }
        //Calcul moyenne
        if(nbEmp != 0) {
            niveauGlobal = somme / nbEmp;
        }
        return niveauGlobal;
    }

    /**
     * Retourne le niveau de formation moyen des employés
     *
     * @return niveauGlobal : niveau de formation moyen des employés
     * @author casag
     */
    public double getNiveauMoyenFormation(){
        double nbEmp = 0 ;
        double somme = 0 ;
        double niveauGlobal = 0;
        //Parcours de la liste d'employés
        for (Employe emp : employes) {
            //On additionne le niveau de formation de chaque employé et on les compte
            somme += emp.getNiveauFormation();
            nbEmp += 1;
        }
        //Calcul moyenne
        if(nbEmp != 0) {
            niveauGlobal = somme / nbEmp;
        }
        return niveauGlobal;
    }

    /**
     * Incrémente l'argent de 1
     *
     * @author casag
     */
    public void incremArgent(){
        setArgent(this.argent +1);
    }

    /**
     * Mise à jour du taux de bonheur <br>
     * Dépend du niveau de formation général des employés, de la réputation, <br>
     * du taux global de sécurité et du niveau de qualité des conditions de travail
     *
     * @author casag
     */
    public void setTauxBonheur(){
        //this.bonheur = ((getNiveauMoyenFormation()/5) + getReputation() + getNiveauMoyenDomaine("Securite)") + getTauxQualConditionTravail())/4;
        setBonheur(((getNiveauMoyenFormation()/5) + getReputation() + getNiveauMoyenDomaine("Securite)") + getTauxQualConditionTravail())/4);
    }

    /** Retourne le taux de rapidité d'incrémentation de l'argent <br>
     * 25% Comptabilité | 75% Performance globale
     *
     * @return taux : taux de rapidité d'incrémentation
     * @author casag
     */
    public double getTauxIncremArgent(){
        double taux = 0;
        double tauxPerf = getTauxGlobal();
        double compt = getNiveauMoyenDomaine("Comptabilite") /5;
        double commerc = getNiveauMoyenDomaine("Commercial") /5;
        taux = compt * (25.0/100.0) + commerc * (20.0/100.0) + tauxPerf * (55.0/100.0);
        return taux;
    }

    /**
     * Retourne la quantité de ressources retirée : prend en compte le niveau moyen de formation du service production
     * @return quantité de ressources retirée
     * @author casag
     */
    public int getDiminutionRess() {
        int dim;
        double prod = getNiveauMoyenDomaine("Production") /5;
        dim = (int)(getIndiceDecrem() * (1.0-prod));
        return dim;
    }

    /** Permet d'ajouter un nouvel employé à la collection <br>
     * La création d'un employé se fait en fonction du nom de son service
     * ainsi que son sexe (F/H), tous deux transmis en paramètres
     *
     * @author gbon, casag
     */
    public void Recruter (String service, char sexe) {
        switch (service) {
            case "Commercial" :
                employes.add(new Commercial(sexe));
                break;
            case "Comptabilite" :
                employes.add(new Comptabilite(sexe));
                break;
            case "Communication" :
                employes.add(new Communication(sexe));
                break;
            case "Production" :
                employes.add(new Production(sexe));
                break;
            case "Securite" :
                employes.add(new Securite(sexe));
                break;
        }
        //Mise à jour du taux de formation en sécurité informatique
        if (tauxFormationSecuInfo != 0){
            tauxFormationSecuInfo = tauxFormationSecuInfo *(1.0-(1.0/(employes.size())));
        }
    }

    /**
     * Permet de vérifier si la parité est gloablement respectée à partir de 3 employés (proportion de 40-60)
     *
     * @return 0 si la parité est globalement respectée, 1 s'il y a plus d'hommes que de femmes ou 2 dans le cas contraire
     * @author gbon
     */
    public int verifierParite() {
        int respectParite = 0;
        if(getEmployes().size() > 3 && (getParite() < 0.4 || getParite() > 0.6)) {
            if (getParite() < 0.4){
                respectParite = 1;
            } else {
                respectParite = 2;
            }
        }
        return respectParite;
    }

    /**
     * Permet de lancer une campagne de communication
     *
     * @return true si campagne effectuée, false dans le cas contraire
     * @author gbon
     */
    public boolean lancerCampagneCom() {
        boolean reussi = false;
        if(payer(150)) {
            setReputation(getReputation() + 0.15);
            reussi = true;
        }
        return reussi;
    }

    /**
     * Augmente le taux de qualité des conditions de travail. <br>
     *     Améliorer fournitures = 0.30                       <br>
     *     Intervention médecin du travail = 0.20             <br>
     *     Intervention ménage = 0.10                         <br>
     *     Organiser apéro = 0.30                             <br>
     *     Félicitations d'un employé = 0.10                  <br>
     *
     * @param taux
     * @author casag
     */
    public void augmenterTauxConditTravail (double taux) {
        //Si le taux est à 0, on l'initialise à 10%
        if(tauxQualConditionTravail == 0){
            setTauxQualConditionTravail(taux);
        }else { //sinon, on l'augmente du taux
            if(tauxQualConditionTravail*(1+taux) >= 1) {
                setTauxQualConditionTravail(1);
            } else {
                setTauxQualConditionTravail(tauxQualConditionTravail * (1+taux));
            }
        }
    }

    /**
     * Permet de déterminer la somme à payer pour améliorer le mobilier de bureau.<br>.
     * Vérifie si le joueur peut payer la somme correspondante à l'amélioration du niveau supérieur du mobilier.
     * La règle de calcul est : +1500 par niveau
     *
     * @return sommeAmeliorationMobilier : valeur entière à payer pour améliorer le niveau de mobilier
     * @author gbon
     */
    public int determinerSommeAmeliorationMobilier() {
        int sommeAmeliorationMobilier = getNiveauMobilier() * 1500;
        return sommeAmeliorationMobilier;
    }

    /**
     * Permet de gérer l'amélioration du mobilier.<br>.
     * Vérifie si le joueur peut payer la somme correspondante à l'amélioration du niveau de mobilier supérieur
     * et modifie le niveau en conséquence ainsi que le nom/marque du mobilier.<br>
     * Le niveau max du mobilier est 10
     *
     * @return reussi : 0 si pas assez d'argent, 1 si niveau max atteind et 2 si réussi
     * @author gbon
     */
    public int ameliorerMobilier() {
        int reussi = 0;
        int sommeAPayer = determinerSommeAmeliorationMobilier();
        // Test si le joueur à assez d'argent pour payer l'amélioration
        if (payer(sommeAPayer)) {
            reussi = 1;
            // Test du niveau (niveau max : 10)
            if (getNiveauMobilier()<10) {
                setNiveauMobilier(getNiveauMobilier() + 1);
                changerNomMobilier(getNiveauMobilier());
                augmenterTauxConditTravail(0.45);
                reussi = 2;
            }
        }
        return reussi;
    }

    /**
     * Permet d'obtenir le nom/marque du mobilier correspondant à son niveau.<br>
     * La marque est différente pour chaque niveau.
     * @param niveauMobilier : le niveau du mobilier actuel dont on souhaite connaitre le nom
     *
     * @return nouveauNom : le nouveau nom de la marque du mobilier
     * @author gbon
     */
    public void changerNomMobilier(int niveauMobilier) {
        String nouveauNom = "";
        switch (niveauMobilier) {
            case 1:
                nouveauNom = "Ikeo";
                break;
            case 2:
                nouveauNom = "Manutan";
                break;
            case 3:
                nouveauNom = "Office Pro";
                break;
            case 4:
                nouveauNom = "Vitro";
                break;
            case 5:
                nouveauNom = "Herman Milheures";
                break;
            case 6:
                nouveauNom = "Voltax";
                break;
            case 7:
                nouveauNom = "Caray";
                break;
            case 8:
                nouveauNom = "Knoll";
                break;
            case 9:
                nouveauNom = "Haworth";
                break;
            case 10:
                nouveauNom = "Ironcase";
                break;
        }
        nomMobilier = nouveauNom;
    }

    /**
     * Organise un apéro si le joueur a les moyens.
     * Augmente de 30% la qualité des conditions de travail.
     *
     * @return resultat : 0 si le joueur n'a pas assez d'argent, 1 s'il n'y a pas assez de temps écoulé depuis le dernier apéro et 2 si réussi
     *
     * @author casag, gbon
     */
    public int organiserApero() {
        int resultat = 0;
        Date now = new Date();
        if (dernierApero != null) {
            // si le joueur peut payer
            if (this.payer(100)) {
                resultat = 1;
                //récupération du nombre d'heures entre la date du dernier apéro et maintenant
                long secs = (now.getTime() - this.dernierApero.getTime()) / 1000;
                long hours = 0;
                long minutes;
                minutes = secs / 60;
                hours = secs / 3600;
                // si la différence est d'au moins 3h
                if (minutes >= 3) {
                    setDernierApero(now);
                    augmenterTauxConditTravail(0.30);
                    setNombreApero(getNombreApero() + 1);
                    resultat = 2;
                    // si le joueur organise trop d'apéro (10 ou plus au total), certains de ses employés deviennent alcooliques et d'autres passeront leur temps à s'amuser
                    if (getNombreApero() >= 10) {
                        // ce qui entrainera une importante baisse de la productivité/ conditions de travail
                        setTauxQualConditionTravail(-0.50);
                        resultat = 3;
                    }
                } else {
                    resultat = 4;
                }
            }
        } else {
            if (this.payer(100)) {
                setDernierApero(now);
                augmenterTauxConditTravail(0.30);
                setNombreApero(1);
                resultat = 2;
            }
        }
        return resultat;
    }

    /**
     * Félicite un employé et augmente de 15% la qualité des conditions de travail
     * (minimum 2 heures entre chaques félicitations)
     *
     * @return booléen : false si cela fait moins de deux heures
     * @author casag
     */
    public boolean feliciterEmploye(){
        boolean done = false;
        Date now = new Date();
        if (derniereFelicitation != null) {
            //récupération du nombre d'heures entre les dernières félicitations et maintenant
            long secs = (now.getTime() - this.derniereFelicitation.getTime()) / 1000;
            long hours = 0;
            hours = secs / 3600;
            //si ça fait au moins 2h
            if(hours >= 2) {
                setDerniereFelicitation(now);
                augmenterTauxConditTravail(0.15);
                done = true;
            }
        } else {
            setDerniereFelicitation(now);
            augmenterTauxConditTravail(0.15);
            done = true;
        }
        return done;
    }

    /**
     * Augmente le taux de la sécurité informatique.                 <br>
     *     Améliorer antivirus = 0.15                                <br>
     *     Firewall = 0.30                                           <br>
     *     MÀJ systèmes = 0.30                                       <br>
     *     Former employes = voir formerSecuInfo()                   <br>
     *     Sous-traiter pen-tester = voir pentesting()               <br>
     *
     * @param taux
     * @author casag
     */
    public void augmenterTauxSecuInfo(double taux) {
        //Si le taux est à 0, on l'initialise au taux
        if (tauxSecuInfo == 0) {
            setTauxSecuInfo(taux);
        } else { //sinon, on l'augmente de 20%
            if (tauxSecuInfo * (1 + taux) >= 1) {
                setTauxSecuInfo(1);
            } else {
                setTauxSecuInfo(tauxSecuInfo * (1 + taux));
            }
        }
    }

    /**
     * Permet de déterminer la somme à payer pour améliorer le niveau d'antivirus.<br>.
     * Vérifie si le joueur peut payer la somme correspondante à l'amélioration du niveau d'antivirus supérieur.
     * La règle de calcul est : +150 par niveau d'antivirus
     *
     * @return sommeAmeliorationAntivirus : valeur entière à payer pour améliorer le niveau d'antivirus
     * @author gbon
     */
    public int determinerSommeAmeliorationAntivirus() {
        int sommeAmeliorationAntivirus = getNiveauAntivirus() * 150;
        return sommeAmeliorationAntivirus;
    }

    /**
     * Permet de gérer l'amélioration de l'antivirus.<br>.
     * Vérifie si le joueur peut payer la somme correspondante à l'amélioration du niveau d'antivirus supérieur
     * et modifie le niveau en conséquence ainsi que le nom de l'antivirus.<br>
     * Le niveau max de l'antivirus est 99
     *
     * @return reussi : 0 si pas assez d'argent, 1 si niveau max atteind et 2 si réussi
     * @author gbon
     */
    public int ameliorerAntivirus() {
        int reussi = 0;
        int sommeAPayer = determinerSommeAmeliorationAntivirus();
        // Test si le joueur à assez d'argent pour payer l'amélioration
        if (payer(sommeAPayer)){
            reussi = 1;
            // Test du niveau de l'antivirus (niveau max : 99)
             if (getNiveauAntivirus()<99){
                setNiveauAntivirus(getNiveauAntivirus() + 1);
                changerNomAntivirus(getNiveauAntivirus());
                augmenterTauxSecuInfo(0.15);
                reussi = 2;
            }
        }
        return reussi;
    }

    /**
     * Permet d'obtenir le nom de l'antivirus correspondant à son niveau.<br>
     * Changement de marque d'antivirus tous les 10 niveaux jusqu'au niveau 100.
     * Le nom se compose ainsi "Marque v1.X" ou X représente le chiffre des unités du niveau de l'antivirus
     * @param niveauAntivirus : le niveau de l'antivirus actuel dont on souhaite connaitre le nom
     *
     * @return nouveauNom : le nouveau nom de l'antivirus, au format "Marque v1.X"
     * @author gbon
     */
    public void changerNomAntivirus(int niveauAntivirus) {
        String nouveauNom = "";
        // Détermination de la marque de l'antivirus selon le niveau de l'antivirus (par palier de 10 jusqu'à 100)
        if (niveauAntivirus <10) {
            nouveauNom = "Aviro";
        } else if (niveauAntivirus <20) {
            nouveauNom = "Trend macro";
        } else if (niveauAntivirus <30) {
            nouveauNom = "Avist";
        } else if (niveauAntivirus <40) {
            nouveauNom = "Twentycent";
        } else if (niveauAntivirus <50) {
            nouveauNom = "Mcofee";
        } else if (niveauAntivirus <60) {
            nouveauNom = "G-Secure";
        } else if (niveauAntivirus <70) {
            nouveauNom = "Penguin";
        } else if (niveauAntivirus <80) {
            nouveauNom = "Nurton Security";
        } else if (niveauAntivirus <90) {
            nouveauNom = "Caspersky";
        } else if (niveauAntivirus <100) {
            nouveauNom = "Botdefender";
        }
        nouveauNom += " v1.";
        // Détermination de la version de l'antivirus (chiffre des unités du niveau de l'antivirus, pour compléter "v1.X")
        nouveauNom += Integer.toString(niveauAntivirus%10);
        nomAntivirus = nouveauNom;
    }

    public void actualiserDerniereMAJFirewall() {
        derniereMAJFirewall ++;
        augmenterTauxSecuInfo(-0.15);
    }

    /**
     * Forme les employés de sécurité (taux = 100%)
     * Décremente l'argent (fonction payer)
     * @author casag
     */
    public boolean formerSecuInfo(){
        boolean done = false;
        //Si le joueur a les moyens
        if(this.payer(300)) {
            setTauxFormationSecuInfo(1);
            augmenterTauxSecuInfo(0.15);
            done = true;
        }
        return done;
    }

    /**
     * Génère un nombre aléatoire (nombre de failles trouvées)
     * Augmente le taux de sécurité informatique en fonction du nombre généré :
     * Plus il y a de failles trouvées, plus le taux de sécurité informatique est augmenté
     *
     * @return randomNum : retourne le nombre de failles trouvées, et si le joueur n'a pas les moyens de payer, retourne 0
     * @author casag
     */
    public int pentesting() {
        int randomNum = 0;

        if (this.payer(500)) {
            randomNum = ThreadLocalRandom.current().nextInt(1, 50 + 1);

            if (randomNum <= 10) {
                augmenterTauxSecuInfo(0.10);
            } else if (randomNum > 10 && randomNum <= 25) {
                augmenterTauxSecuInfo(0.25);
            } else {
                augmenterTauxSecuInfo(0.40);
            }
        }
        return randomNum;
    }
      
     /* 
     * Permet d'acheter des ressources
     *
     * @param nombre
     * @return booléen
     * @author casag
     */
    public boolean acheterRessources(int nombre) {
        boolean ok = false;
        switch (nombre) {
            case 5 :   Ressources.ajout(5);
                        payer(50);
                        ok = true; break;
            case 10 :  Ressources.ajout(10);
                        payer(90);
                        ok = true; break;
            case 20 :  Ressources.ajout(20);
                        payer(180);
                        ok = true; break;
        }
        return ok;
    }

    /*
     * Permet de diminuer le nombre de ressources
     *
     * @param nombre
     * @author gbon
     */
    public void diminuerRessources(int nombre) {
        if(Ressources.getInstance()< nombre) {
            Ressources.setInstance(0);
        } else {
            Ressources.setInstance(Ressources.getInstance() - nombre);
        }
    }

    /**
     * Retourne le taux de sécurité global
     * @return taux sécu global
     * @author casag
     */
    public double getTauxSecuGlobal() {
        double taux;
        taux = (getNiveauMoyenDomaine("securite") + getTauxQualConditionTravail() + getTauxSecuInfo())/3;
        return taux;
    }

    /**
     * Retourne le taux de performance global de l'entreprise
     * @return taux global
     */
    public double getTauxGlobal(){
        double taux;
        taux = (getReputation() + getTauxSecuGlobal() + getNiveauMoyenFormation() + getBonheur()) / 4;
        return taux;
    }


    /* getters and setters */

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public double getNiveau() {
        return niveau;
    }

    /**
     * Met à jour le niveau.
     * Observe s'il passe à l'unité supérieure.
     *
     * @param niveau
     * @author casag
     */
    public void setNiveau(double niveau) {
        double ancienNiveau = getNiveau();

        this.niveau = niveau;

        if(ancienNiveau <= 2 && niveau >= 2) {

        }else if (ancienNiveau <= 3 && niveau >= 3){

        } else if (ancienNiveau <= 4 && niveau >= 4) {

        } else if (ancienNiveau <= 5 && niveau >= 5) {

        }
    }

    public boolean EmployeExiste(String cat) {
        boolean exists = false;
        for(Employe emp : employes) {
            switch (cat) {
                case "Commercial":
                    if (emp instanceof Commercial) {
                        exists = true;
                    }
                    break;
                case "Comptabilite":
                    if (emp instanceof Comptabilite) {
                        exists = true;
                    }
                    break;
                case "Communication":
                    if (emp instanceof Communication) {
                        exists = true;
                    }
                    break;
                case "Production":
                    if (emp instanceof Production) {
                        exists = true;
                    }
                    break;
                case "Securite":
                    if (emp instanceof Securite) {
                        exists = true;
                    }
                    break;
            }
            if(exists == true) {
                break;
            }
        }
        return exists;
    }

    public Character getGenre (String cat) {
        Character genre = null;
        for(Employe emp : employes) {
            switch (cat) {
                case "Commercial":
                    if (emp instanceof Commercial) {
                        genre = emp.getSexe();
                    }
                    break;
                case "Comptabilite":
                    if (emp instanceof Comptabilite) {
                        genre = emp.getSexe();
                    }
                    break;
                case "Communication":
                    if (emp instanceof Communication) {
                        genre = emp.getSexe();
                    }
                    break;
                case "Production":
                    if (emp instanceof Production) {
                        genre = emp.getSexe();
                    }
                    break;
                case "Securite":
                    if (emp instanceof Securite) {
                        genre = emp.getSexe();
                    }
                    break;
            }
            if(genre != null) {
                break;
            }
        }
        return genre;
    }

    public Employe getEmployeByService(String cat) {
        Employe e = null;
        for(Employe emp : employes) {
            switch (cat) {
                case "Commercial":
                    if (emp instanceof Commercial) {
                        e = emp;
                    }
                    break;
                case "Comptabilite":
                    if (emp instanceof Comptabilite) {
                        e = emp;
                    }
                    break;
                case "Communication":
                    if (emp instanceof Communication) {
                        e = emp;
                    }
                    break;
                case "Production":
                    if (emp instanceof Production) {
                        e = emp;
                    }
                    break;
                case "Securite":
                    if (emp instanceof Securite) {
                        e = emp;
                    }
                    break;
            }
            if(e != null) {
                break;
            }
        }
        return e;
    }

    public double getBonheur() {
        return bonheur;
    }

    public void setBonheur(double bonheur) {
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

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    public double getTauxSecuInfo() {
        return tauxSecuInfo;
    }

    public void setTauxSecuInfo(double niveauSecuInfo) {
        this.tauxSecuInfo = niveauSecuInfo;
    }

    public int getNiveauAntivirus() {
        return niveauAntivirus;
    }

    public void setNiveauAntivirus(int niveauAntivirus) { this.niveauAntivirus = niveauAntivirus; }

    public String getNomAntivirus() {
        return nomAntivirus;
    }

    public void setNomAntivirus(String nomAntivirus) {
        this.nomAntivirus = nomAntivirus;
    }

    public int getDerniereMAJFirewall() { return derniereMAJFirewall; }

    public void setDerniereMAJFirewall(int derniereMAJFirewall) { this.derniereMAJFirewall = derniereMAJFirewall; }

    public int getDerniereMAJSysteme() { return derniereMAJSysteme; }

    public void setDerniereMAJSysteme(int derniereMAJSysteme) { this.derniereMAJSysteme = derniereMAJSysteme; }

    public double getTauxFormationSecuInfo() {
        return tauxFormationSecuInfo;
    }

    public void setTauxFormationSecuInfo(double tauxFormationSecuInfo) { this.tauxFormationSecuInfo = tauxFormationSecuInfo; }

    public double getTauxQualConditionTravail() {
        return tauxQualConditionTravail;
    }

    public void setTauxQualConditionTravail(double tauxQualConditionTravail) {
        this.tauxQualConditionTravail = tauxQualConditionTravail;
    }

    public int getNiveauMobilier() {
        return niveauMobilier;
    }

    public void setNiveauMobilier(int niveauMobilier) {
        this.niveauMobilier = niveauMobilier;
    }

    public String getNomMobilier() {
        return nomMobilier;
    }

    public void setNomMobilier(String nomMobilier) {
        this.nomMobilier = nomMobilier;
    }

    public int getDerniereInterventionMedecineTravail() { return derniereInterventionMedecineTravail; }

    public void setDerniereInterventionMedecineTravail(int derniereInterventionMedecineTravail) { this.derniereInterventionMedecineTravail = derniereInterventionMedecineTravail; }

    public int getDerniereInterventionMenage() { return derniereInterventionMenage; }

    public void setDerniereInterventionMenage(int derniereInterventionMenage) { this.derniereInterventionMenage = derniereInterventionMenage; }

    public Date getDernierApero() { return dernierApero; }

    public void setDernierApero(Date dernierApero) { this.dernierApero = dernierApero; }

    public int getNombreApero() { return nombreApero; }

    public void setNombreApero(int nombreApero) { this.nombreApero = nombreApero; }

    public Date getDerniereFelicitation() {
        return derniereFelicitation;
    }

    public void setDerniereFelicitation(Date derniereFelicitation) { this.derniereFelicitation = derniereFelicitation; }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public int getIndiceDecrem() {
        return indiceDecrem;
    }

    public void setIndiceDecrem(int indiceDecrem) {
        this.indiceDecrem = indiceDecrem;
    }

    public int getIndiceIncremArgent() {
        return indiceIncremArgent;
    }

    public void setIndiceIncremArgent(int indiceIncremArgent) {
        this.indiceIncremArgent = indiceIncremArgent;
    }

}
