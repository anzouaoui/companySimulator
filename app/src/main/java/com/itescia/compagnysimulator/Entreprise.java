package com.itescia.compagnysimulator;
import com.itescia.compagnysimulator.Employes.Commercial;
import com.itescia.compagnysimulator.Employes.Comptabilite;
import com.itescia.compagnysimulator.Employes.Direction;
import com.itescia.compagnysimulator.Employes.Employe;
import com.itescia.compagnysimulator.Employes.Marketing;
import com.itescia.compagnysimulator.Employes.Production;
import com.itescia.compagnysimulator.Employes.RD;
import com.itescia.compagnysimulator.Employes.Securite;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


import java.lang.reflect.Constructor;
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
     * @see Entreprise#levelUp(double)
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
     *  40% Comptabilité | 30% bonheur | 10% Production | 10% Commercial | 10% Marketing
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
     * @see Entreprise#setReputation(int)
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
        this.argent = 1;
        this.reputation = 0.5;
        this.tauxSecuInfo = 0.5;
        this.tauxFormationSecuInfo = 0;
        this.tauxQualConditionTravail = 0.5;
        this.niveauAntivirus = 1;
        this.nomAntivirus = "Aviro v1.0";
        this.derniereMAJFirewall = 0;
        this.nomMobilier = "Ikeo";
        this.niveauMobilier = 1;
        this.derniereFelicitation = null;
        this.employes = new ArrayList<Employe>();
        this.indiceDecrem = 1;
        Ressources.getInstance();
    }

    /**
     * Augmente le niveau du nombre donné en paramètre
     *
     * @param nombre
     * @author casag
     */
    public void levelUp(double nombre) {
        setNiveau(this.niveau + nombre);
    }

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
                case "Direction" :
                    if(emp instanceof Direction){
                        somme += emp.getNiveauFormation();
                        nbEmp += 1;
                    }
                    break;
                case "Marketing" :
                    if(emp instanceof Marketing){
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
                case "RD" :
                    if(emp instanceof RD){
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
        this.bonheur = ((getNiveauMoyenFormation()/5) + getReputation() + getNiveauMoyenDomaine("Securite)") + getTauxQualConditionTravail())/4;
        setBonheur(((getNiveauMoyenFormation()/5) + getReputation() + getNiveauMoyenDomaine("Securite)") + getTauxQualConditionTravail())/4);
    }

    /** Retourne le taux de rapidité d'incrémentation de l'argent <br>
     * 40% Comptabilité | 30% bonheur | 10% Production | 10% Commercial | 10% Marketing
     *
     * @return taux : taux de rapidité d'incrémentation
     * @author casag
     */
    public double getRapiditeIncrementation(){
        double taux = 0;
        double compt = 0, bonh = 0, prod = 0, comm = 0, mark = 0;
        compt = getNiveauMoyenDomaine("Comptabilite") /5;
        bonh = getBonheur();
        prod = getNiveauMoyenDomaine("Production") / 5;
        comm = getNiveauMoyenDomaine("Commercial") / 5;
        mark = getNiveauMoyenDomaine("Marketing") / 5;

        taux = compt * (40.0/100.0) + bonh * (30.0/100.0) + prod * (10.0/100.0) + comm  * (10.0/100.0) + mark * (10.0/100.0);
        return taux;
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
            case "Direction" :
                employes.add(new Direction(sexe));
                break;
            case "Marketing" :
                employes.add(new Marketing(sexe));
                break;
            case "Production" :
                employes.add(new Production(sexe));
                break;
            case "RD" :
                employes.add(new RD(sexe));
                break;
            case "Securite" :
                employes.add(new Securite(sexe));
                break;
        }
        //Mise à jour du taux de formation en sécurité informatique
        if (tauxFormationSecuInfo != 0){
            tauxFormationSecuInfo = tauxFormationSecuInfo *(1.0-(1.0/(employes.size())));
        }

        levelUp(0.15);
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
        levelUp(0.10);
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
        int sommeAmeliorationMobilier = getNiveauAntivirus() * 1500;
        return sommeAmeliorationMobilier;
    }

    /**
     * Permet de gérer l'amélioration du mobilier.<br>.
     * Vérifie si le joueur peut payer la somme correspondante à l'amélioration du niveau de mobilier supérieur
     * et modifie le niveau en conséquence ainsi que le nom/marque du mobilier.<br>
     * Le niveau max du mobilier est 10
     *
     * @author gbon
     */
    public void ameliorerMobilier() {
        if (getNiveauMobilier()<10) {
            int sommeAPayer = determinerSommeAmeliorationMobilier();
            // Test si le joueur à assez d'argent pour payer l'amélioration
            if (payer(sommeAPayer)) {
                setNiveauMobilier(getNiveauMobilier() + 1);
                setNomMobilier(changerNomMobilier(getNiveauMobilier()));
                augmenterTauxConditTravail(0.45);
                levelUp(0.35);
            }
            levelUp(0.15);
        }
    }

    /**
     * Permet d'obtenir le nom/marque du mobilier correspondant à son niveau.<br>
     * La marque est différente pour chaque niveau.
     * @param niveauMobilier : le niveau du mobilier actuel dont on souhaite connaitre le nom
     *
     * @return nouveauNom : le nouveau nom de la marque du mobilier
     * @author gbon
     */
    public String changerNomMobilier(int niveauMobilier) {
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
        return nouveauNom;
    }

    /**
     * Organise un apéro si le joueur a les moyens.
     * Augmente de 30% la qualité des conditions de travail.
     * @return booléen : true si 3h sont passées depuis dernier et si assez d'argent
     *
     * @author casag, gbon
     */
    public boolean organiserApero() {
        boolean done = false;
        Date now = new Date();
        if (dernierApero != null) {
            //récupération du nombre d'heures entre la date du dernier apéro et maintenant
            long secs = (now.getTime() - this.dernierApero.getTime()) / 1000;
            long hours = 0;
            hours = secs / 3600;
            //si la différence est d'au moins 3h
            if (hours >= 3) {
                // et si le joueur peut payer
                if (this.payer(300)) {
                    setDernierApero(now);
                    augmenterTauxConditTravail(0.30);
                    levelUp(0.15);
                    setNombreApero(getNombreApero() + 1);
                    done = true;
                    // si le joueur organise trop d'apéro (30 ou plus au total), certains de ses employés deviennent alcooliques et d'autres passeront leur temps à s'amuser
                    if (getNombreApero() >= 30) {
                        // ce qui entrainera une importante baisse de la productivité/ conditions de travail
                        setTauxQualConditionTravail(-0.50);
                    }
                }
            }
        } else {
            if (this.payer(300)) {
                setDernierApero(now);
                augmenterTauxConditTravail(0.30);
                levelUp(0.15);
                setNombreApero(1);
                done = true;
            }
            if (this.payer(300)) {
                augmenterTauxConditTravail(0.30);
                levelUp(0.15);
                done = true;
            }
        }
        return done;
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
                levelUp(0.10);
                done = true;
            }
        } else {
            setDerniereFelicitation(now);
            augmenterTauxConditTravail(0.15);
            levelUp(0.10);
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
        levelUp(0.10);
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
     * @author gbon
     */
    public void ameliorerAntivirus() {
        if (getNiveauAntivirus()<99) {
            int sommeAPayer = determinerSommeAmeliorationAntivirus();
            // Test si le joueur à assez d'argent pour payer l'amélioration
            if (payer(sommeAPayer)) {
                setNiveauAntivirus(getNiveauAntivirus() + 1);
                setNomAntivirus(changerNomAntivirus(getNiveauAntivirus()));
                augmenterTauxSecuInfo(0.15);
                levelUp(0.15);
            }
        }
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
    public String changerNomAntivirus(int niveauAntivirus) {
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
        return nouveauNom;
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
            levelUp(0.15);
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
            levelUp(0.15);
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

    public void setReputation(int reputation) {
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

}
