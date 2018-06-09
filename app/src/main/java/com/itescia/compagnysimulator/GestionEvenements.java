package com.itescia.compagnysimulator;

import android.app.Activity;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by gbon on 04/05/2018.
 */

/**
 * <b> Classe permettant de gérer les évènements</b>
 *
 * @author gbon
 */
public final class GestionEvenements {
    /** L'instance unique GestionEvenement
     * @see GestionEvenements#getGestionEvenements()
     *
     * @author gbon
     */
    private static GestionEvenements e;
    private Entreprise entreprise;
    private ArrayList<Evenement> collectionEvenements;
    private Timer _t;

    private GestionEvenements() {}

    /**
     * Permet de définir la variable entreprise et d'initialiser la collection d'évènements
     *
     * @author gbon, casag
     */
    public void initialize(Entreprise entreprise){
        this.entreprise = entreprise;
        this.collectionEvenements = new ArrayList<Evenement>();

        // Evénements déclenchés par le joueurs ou les stats :
        Evenement e2 = new Evenement(2, "Les employés ne se sont pas remis du dernier apéro...", "Ouvrir la salle de repos", 0, "Faire intervenir la médecine du travail", 150);
        collectionEvenements.add(e2);

        // A intégrer
        //Evenement e3 = new Evenement(3, "Le nouvel employé s'avère moins compétent que prévu", "Le remplacer par un autre", 0, "Lui payer une formation complémentaire", 100);
        //collectionEvenements.add(e3);

        // Evénements aléatoires :
        Evenement e101 = new Evenement(101, "Plusieurs de vos employés souhaiteraient avoir un babyfoot dans la salle de repos", "Acheter un babyfoot", 500, "Leur dire de se remettre au travail", 0);
        collectionEvenements.add(e101);
        Evenement e102 = new Evenement(102, "La machine à cafés vient de tomber en panne", "Ne rien faire", 0, "Appeler un réparateur", 200);
        collectionEvenements.add(e102);
        Evenement e103 = new Evenement(103, "Une grève nationale des transports vient d'être annoncée", "Proposer la mise en place du télétravail aux employés", 0, "Leur demander de venir au bureau quand même", 0);
        collectionEvenements.add(e103);
        Evenement e104 = new Evenement(104, "Un hacker menace de bloquer votre système informatique en échange d'une rançon", "Lui payer la rançon", 750, "Ne pas céder à la menace", 0);
        collectionEvenements.add(e104);
        Evenement e105 = new Evenement(105, "Vous surprenez un employé qui semble en train de voler dans la réserve", "Le réprimander", 0, "Ne pas réagir", 0);
        collectionEvenements.add(e105);
        Evenement e106 = new Evenement(106, "Un employé vient vous voir et en accuse un autre de lui avoir volé son aggrafeuse", "Sanctionner le prétendu voleur", 0, "Laisser les employés régler cette affaire entre eux", 0);
        collectionEvenements.add(e106);
        Evenement e107 = new Evenement(107, "Un employé souhaite une augmentation pour avoir travailler dur ces derniers temps", "L'augmenter", 50, "Simplement lui dire de continuer de travailler comme cela", 0);
        collectionEvenements.add(e107);
        Evenement e108 = new Evenement(108, "Vos employés se plaignent de la nourriture de la cantine jugée immonde", "Leur répondre de ramener leur propre gamelle", 0, "Les inviter au restaurant", 200);
        collectionEvenements.add(e108);
        Evenement e109 = new Evenement(109, "Un jeune étudiant désire effectuer un stage au sein de votre entreprise", "L'embaucher malgré sa faible expérience", 150, "Lui rire au nez", 0);
        collectionEvenements.add(e109);
        Evenement e110 = new Evenement(110, "Des employés ont été surpris en train de jouer en réseau à Counter Strike", "Organiser un tournois inter services", 0, "Les réprimander", 0);
        collectionEvenements.add(e110);
        Evenement e111 = new Evenement(111, "Le stagiaire vient vous demander s'il peut participer à des évènements plus important de votre entreprise", "L'inviter à la prochaine réunion importante", 0, "Lui demander d'aller chercher les cafés pour l'équipe", 0);
        collectionEvenements.add(e111);
        Evenement e112 = new Evenement(112, "Un développeur regarde Thrones of Game en streaming, ce qui monopolise la majeure partie de la bande passante du réseau internet", "Regarder les derniers épisodes inédits avec lui", 0, "Le sanctionner", 0);
        collectionEvenements.add(e112);
        Evenement e113 = new Evenement(113, "Un employé va bientôt quitter l'entreprise", "Lui dire au revoir et bonne continuation", 0, "Organiser un pôt de départ", 50);
        collectionEvenements.add(e113);
        Evenement e114 = new Evenement(114, "Les toilettes du premier étage sont bouchées", "Attendre qu'elles se débouchent", 0, "Appeller un plombier", 100);
        collectionEvenements.add(e114);
        Evenement e115 = new Evenement(115, "Un événement sportif vous demande de le sponsoriser", "Accepter l'offre", 500, "Décliner en prétextant que vous n'avez pas d'argent à inutilement gacher", 0);
        collectionEvenements.add(e115);
        Evenement e116 = new Evenement(116, "Un commercial a réussi à otenir un gros contrat", "Simplement le féliciter et lui dire de continuer comme cela", 0, "Lui accorder une prime", 100);
        collectionEvenements.add(e116);
        Evenement e117 = new Evenement(117, "Une invasion de rats a été signalée dans le bâtiment", "Appeler une société de dératisation", 250, "Adopter un chat pour qu'il chasse les rats", 0);
        collectionEvenements.add(e117);
        Evenement e118 = new Evenement(118, "Un employé a été dénoncé car il effectue régulièrement du shopping en ligne au lieu de travailler", "Le rappeler à l'ordre", 0, "Lui demander s'il a déniché des bons plans dont vous pourriez vous aussi profiter", 0);
        collectionEvenements.add(e118);
        Evenement e119 = new Evenement(119, "Vous surprenez un employé en train de dormir dans la réserve au lieu de travailler", "Le laisser dormir car il doit avoir besoin de sommeil", 0, "Le réveiller et le réprimander", 0);
        collectionEvenements.add(e119);
        Evenement e120 = new Evenement(120, "Un employé lit à son bureau au lieu de travailler", "Lui conseiller un autre livre", 0, "Lui confisquer son livre", 0);
        collectionEvenements.add(e120);
        Evenement e121 = new Evenement(121, "Vous surprenez un employé sur le réseau social LifeInvader qui prétends alors faire des recherches professionnelles", "Le réprimander et lui demander de se remettre au travail", 0, "Lui dire qu'il n'y a aucun soucis", 0);
        collectionEvenements.add(e121);
        Evenement e122 = new Evenement(122, "Votre comptable a détourné de l'argent de la société parce qu'il en avait besoin pour un investissement qui pourrait rapporter le double", "Le renvoyer pour faute grave", 0, "Lui demander si vous pourriez participer", 0);
        collectionEvenements.add(e122);
        Evenement e123 = new Evenement(123, "Des salariés falsifient leurs feuilles de temps", "Leur faire récupérer toutes les heures non travaillées", 0, "Leur demander d'arrêter immédiatement sous peine de sanctions", 0);
        collectionEvenements.add(e123);
        Evenement e124 = new Evenement(124, "Vous surprenez plusieurs employés en train de comploter pour faire partir un employé qu'ils n'apprécient pas", "Les sanctionnez en leur disant que cela est inadmissible", 0, "Comploter avec eux car vous non plus ne l'appréciez pas vraiment", 0);
        collectionEvenements.add(e124);
        Evenement e125 = new Evenement(125, "Une oeuvre caritative fait appel à vous par mail pour l'aider à soutenir sa cause", "Faire un don", 500, "Faire semblant de ne pas avoir reçu le mail", 0);
        collectionEvenements.add(e125);
        Evenement e126 = new Evenement(126, "Vous venez de gagner un très gros contrat avec un client important", "Garder une partie de la somme pour s'acheter une voiture de luxe", 0, "Donner une prime à chaque employé", 0);
        collectionEvenements.add(e126);
        Evenement e127 = new Evenement(127, "Un employé en progression a mal effectué son travail du à des lacunes de compétences", "L'encourager à persévérer", 0, "Le mettre de côté pour les projets", 0);
        collectionEvenements.add(e127);
        Evenement e128 = new Evenement(128, "Deux employés travaillant sur le même projet ne s'entendent pas", "Leur demander de se réconcilier rapidement et de travailler ensemble", 0, "Changer une des deux personnes du projet", 0);
        collectionEvenements.add(e128);
        Evenement e129 = new Evenement(129, "Vous tombez sur une offre de séjour pour entreprise à la montagne", "Réserver le séjour", 400, "Ne rien faire", 0);
        collectionEvenements.add(e129);
        Evenement e130 = new Evenement(130, "Vous recevez une offre de promotion pour améliorer votre antivirus", "Bénéficier de la promotion", 300, "La laisser passer", 0);
        collectionEvenements.add(e130);
    }

    /**
     * Permet de récupérer l'instance de GestionEvenements
     *
     * @return instance de GestionEvenements
     *
     * @author gbon
     */
    public synchronized static GestionEvenements getGestionEvenements() {
        if (GestionEvenements.e == null) {
            e = new GestionEvenements();
        }
        return e;
    }

    /**
     * Permet d'effectuer les traitements en fonction du choix de l'utilisateur lors d'un évènement
     *
     * @param numEvent : numero identifiant de l'évènement
     * @param numChoix : chiffre correspondant au choix du joueur (1 ou 2)
     *
     * @author gbon, casag
     */
    public void doEvent(int numEvent, int numChoix, MainActivity ma) {
        switch (numEvent) {
            case 1: // Parite           @see MainActivity.GestionEvenements
                if (numChoix == 1) {
                    //do smthg
                } else {
                    //do smthg else
                }
                break;

            case 2: // Trop d'apéros    @see Entreprise.OrganiserApero
                if (numChoix == 1) { // Ouverture de la salle de sieste
                    Ressources.setInstance(Ressources.getInstance() - 15);
                    Toast.makeText(ma, "Le repos des employés a occasionné une baisse des ressources...", Toast.LENGTH_LONG).show();
                } else { // Intervention médecine du travail
                    if (entreprise.payer(getEventByNum(2).getPrix2())) {
                        Toast.makeText(ma, "Les employés vont bien mieux !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... La salle de repos a été ouverte.", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(2, 1, ma);
                    }
                }
                break;

            case 101: // Choix achat babyfoot
                if (numChoix == 1) { // Acheter babyfoot
                    if (entreprise.payer(getEventByNum(101).getPrix1())) {
                        Toast.makeText(ma, "Vos employés sont ravis du nouveau babyfoot en salle de repos !", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                        entreprise.augmenterTauxConditTravail(0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... mais vos employés comprennent et ne vous en veulent pas", Toast.LENGTH_LONG).show();
                    }
                } else { // Refus d'acheter le babyfoot
                    Toast.makeText(ma, "Vos employés sont vraiment décus que vous leur refusier le babyfoot", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                    entreprise.augmenterTauxConditTravail(-0.15);

                }
                break;

            case 102: // Machine à cafés en panne
                if (numChoix == 1) { // Ne rien faire
                    Toast.makeText(ma, "Vos employés sont en manque de leur dose de caféine quotidienne", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.20);
                    entreprise.augmenterTauxConditTravail(-0.15);
                } else { // Faire réparer machine
                    if (entreprise.payer(getEventByNum(102).getPrix2())) {
                        Toast.makeText(ma, "Vos employés vont pouvoir continuer à boire plus de cafés que de raison !", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(102, 1, ma);
                    }
                }
                break;

            case 103: // Grève générale des transports
                if (numChoix == 1) { // Mise en place du télétravail
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Vos employés profitent du télétravail pour ne pas travailler", Toast.LENGTH_LONG).show();
                        entreprise.setIndiceIncremArgent(entreprise.getIndiceIncremArgent() - 5);
                    } else {
                        Toast.makeText(ma, "Vos employés sont satisfaits de l'amménagement proposé", Toast.LENGTH_LONG).show();
                    }
                    entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                } else { // Leur demander de venir au bureau
                    Toast.makeText(ma, "Certains de vos employés ne peuvent pas venir travailler en raison de la grève", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                    entreprise.setIndiceIncremArgent(entreprise.getIndiceIncremArgent() - 5);
                }
                break;

            case 104: // Menace d'un hacker
                if (numChoix == 1) { // Payer rançon
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Vous payez le hacker mais celui-ci bloque tout de même votre système", Toast.LENGTH_LONG).show();
                        entreprise.augmenterTauxConditTravail(-0.50);
                    } else {
                        if (entreprise.payer(getEventByNum(104).getPrix1())) {
                            Toast.makeText(ma, "Vous payez le hacker qui vous laisse tranquille", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ma, "Vous n'avez pas assez d'argent... Le hacker bloque votre système", Toast.LENGTH_LONG).show();
                            entreprise.augmenterTauxConditTravail(-0.50);
                        }
                    }
                } else { // Ne pas céder
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Le hacker s'avère en réalité être un adolescent qui ne sait pas pirater", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Suite à votre refus, le hacker bloque votre système informatique", Toast.LENGTH_LONG).show();
                        entreprise.augmenterTauxConditTravail(-0.50);
                    }
                }
                break;

            case 105: // Employé semble voler dans la réserve
                if (numChoix == 1) { // Le réprimander
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "L'employé était simplement en train de venir chercher du matériel pour travailler et n'apprécie pas votre jugement", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                    } else {
                        Toast.makeText(ma, "L'employé s'excuse et repose tout le matériel dans la réserve", Toast.LENGTH_LONG).show();
                    }
                } else { // Ne pas réagir
                    Toast.makeText(ma, "L'employé repart avec du matériel qu'il a volé", Toast.LENGTH_LONG).show();
                    entreprise.diminuerRessources(15);
                }
                break;

            case 106: // Employé accuse un autre de vol d'aggrafeuse
                if (numChoix == 1) { // Sanctionner le prétendu voleur
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Après discussion, il s'agissait d'un mensonge visant à pénaliser l'autre employé, qui est très déçu de votre réaction", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                    } else {
                        Toast.makeText(ma, "L'employé vient s'excuser de son comportement", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                    }
                } else { // Les laisser règler cela
                    Toast.makeText(ma, "Les employés ne sont pas parvenus à s'expliquer et cela dégrade l'ambiance de l'équipe", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                }
                break;

            case 107: // Employé souhaite augmentation
                if (numChoix == 1) { // L'augmenter
                    if (entreprise.payer(getEventByNum(107).getPrix1())) {
                        Toast.makeText(ma, "L'employé est ravi de son augmentation", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... mais votre employé comprend la situation et apprécie votre geste", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                    }
                } else { // Simplement lui dire de continuer
                    Toast.makeText(ma, "L'employé est très déçu de votre réaction", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                }
                break;

            case 108: // Employés se plaignent de la cantine
                if (numChoix == 1) { // Leur dire de ramener leurs gamelles
                    Toast.makeText(ma, "Vos employés n'apprécient pas vraiment votre suggestion", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                    entreprise.augmenterTauxConditTravail(- 0.10);
                } else { // Les inviter au restaurant
                    if (entreprise.payer(getEventByNum(108).getPrix2())) {
                        Toast.makeText(ma, "Vous invitez vos employés au restaurant, ce qui leur fait oublier la qualité de la cantine", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... vos employés apprécient votre attention", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.05);
                    }
                }
                break;

            case 109: // Jeune étudiant demande à être stagiaire
                if (numChoix == 1) { // L'embaucher
                    if (entreprise.payer(getEventByNum(109).getPrix1())) {
                        Toast.makeText(ma, "Vous acceptez volontier cette main d'oeuvre moins qualifiée et donc moins chère, mais qui est toujours la bienvenue", Toast.LENGTH_LONG).show();
                        entreprise.setReputation(entreprise.getReputation() + 0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent... vous êtes contraint de refuser sa requête", Toast.LENGTH_LONG).show();
                    }
                } else { // Lui rire au nez
                    Toast.makeText(ma, "Le jeune étudiant a posté votre réaction sur les réseaux sociaux, ce quidonne une image négative à votre entreprise", Toast.LENGTH_LONG).show();
                    entreprise.setReputation(entreprise.getReputation() - 0.15);
                }
                break;

            case 110: // Employés surpris à jouer à CS
                if (numChoix == 1) { // Organiser tournois inter services
                    Toast.makeText(ma, "Votre initiative est appréciée par les employés et cet évènement va renforcer les liens d'équipe", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                    entreprise.setReputation(entreprise.getReputation() + 0.15);
                } else { // Les réprimander
                    Toast.makeText(ma, "Vous réprimandez les employés fautifs qui se remettent au travail", Toast.LENGTH_LONG).show();
                }
                break;

            case 111: // Stagiaire demande à participer à évènements plus important
                if (numChoix == 1) { // L'inviter à la prochaine réunion
                    Toast.makeText(ma, "Votre geste est bien perçu et le stagiaire promouvoit votre entreprise sur les réseaux sociaux", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                    entreprise.setReputation(entreprise.getReputation() + 0.15);
                } else { // Lui demander d'aller chercher les cafés
                    Toast.makeText(ma, "Le stagiaire mécontent relègue votre réaction sur les réseaux sociaux, ce qui déterriore l'image de votre entreprise", Toast.LENGTH_LONG).show();
                    entreprise.setReputation(entreprise.getReputation() - 0.15);
                }
                break;

            case 112: // Développeur regarde Thrones of Game en streaming
                if (numChoix == 1) { // Regarder avec lui
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Vous recevez une amende de 500$ de la part d'Hodipa pour avoir regardé en streaming du contenu piraté", Toast.LENGTH_LONG).show();
                        if (entreprise.payer(500)){} else {
                            entreprise.setArgent(0);
                        }
                    } else {
                        Toast.makeText(ma, "Vous regardez les derniers épisodes piratés en streaming, ce qui ravi le développeur et partage cela sur le web", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                        entreprise.setReputation(entreprise.getReputation() + 0.15);
                    }
                } else { // Le sanctionner
                    Toast.makeText(ma, "Vous sanctionnez le développeur qui pour se vanger laisse des failles de sécurité dans le système informatique", Toast.LENGTH_LONG).show();
                    entreprise.setTauxSecuInfo(entreprise.getTauxSecuInfo() - 0.20);
                }
                break;

            case 113: // Employé va bientôt quitter l'entreprise
                if (numChoix == 1) { // Lui dire au revoir et bonne continuation
                    Toast.makeText(ma, "Vous lui serrez une poignée de main et lui souhaitez une bonne continuation", Toast.LENGTH_LONG).show();
                } else { // Organiser pôt de départ
                    if (entreprise.payer(getEventByNum(113).getPrix2())) {
                        Toast.makeText(ma, "Vous organisez un pôt de départ convivial avec l'ensemble de vos employés", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(113, 1, ma);
                    }
                }
                break;

            case 114: // Toilettes bouchées
                if (numChoix == 1) { // Attendre
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Les toilettes bouchées ont entrainées une innondation dans le bâtiment et 500$ des frais de réparation des dégâts", Toast.LENGTH_LONG).show();
                        if (entreprise.payer(500)) {
                        } else {
                            entreprise.setArgent(0);
                        }
                    } else {
                        Toast.makeText(ma, "Les sanitaires ont étés indisponibles pendant un certain moment mais ont finis par se déboucher par chance", Toast.LENGTH_LONG).show();
                        entreprise.setTauxQualConditionTravail(- 0.15);
                    }
                } else { // Appeler plombier
                    if (entreprise.payer(getEventByNum(114).getPrix2())) {
                        Toast.makeText(ma, "Vous appelez un plombier qui débouche les sanitaires", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(114, 1, ma);
                    }
                }
                break;

            case 115: // Evênement sportif à sponso
                if (numChoix == 1) { // Le sponsoriser
                    if (entreprise.payer(getEventByNum(115).getPrix1())) {
                        Toast.makeText(ma, "Vous sponsorisez l'évènement sportif, ce qui promouvoit l'image de votre entreprise", Toast.LENGTH_LONG).show();
                        entreprise.setReputation(entreprise.getReputation() + 0.20);
                    } else {
                        Toast.makeText(ma, "Vous expliquez que vous n'avez simplement pas assez d'argent", Toast.LENGTH_LONG).show();
                    }
                } else { // Refuser
                    Toast.makeText(ma, "Votre refus est mal perçu par les médias", Toast.LENGTH_LONG).show();
                    entreprise.setReputation(entreprise.getReputation() - 0.20);
                }
                break;

            case 116: // Commercial a obtenu un gros contrat
                if (numChoix == 1) { // Simplement le féliciter
                    Toast.makeText(ma, "Vous le félicitez simplement mais celui-ci est déçu de ne pas avoir obtenu de prime", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                } else { // Lui accorder une prime
                    if (entreprise.payer(getEventByNum(116).getPrix2())) {
                        Toast.makeText(ma, "Vous accorder une généreuse prime au commercial pour le féliciter de son travail", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                    } else {
                        Toast.makeText(ma, "Vous expliquez que vous aimeriez lui accorder une prime mais que vous n'avez pas assez d'argent", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case 117: // Invasion de rats
                if (numChoix == 1) { // Appeler société dératisation
                    if (entreprise.payer(getEventByNum(117).getPrix1())) {
                        Toast.makeText(ma, "Vous faites appel à un dératiseur qui débarasse le bâtiment des nuisibles", Toast.LENGTH_LONG).show();
                        entreprise.setTauxQualConditionTravail(0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                        GestionEvenements.getGestionEvenements().doEvent(117, 2, ma);
                    }
                } else { // Adopter un chat
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Vous adoptez un chat pour vous débarrasser des rongeurs mais celui-ci passe plutôt son temps à dormir", Toast.LENGTH_LONG).show();
                        entreprise.setTauxQualConditionTravail(- 0.15);
                    } else {
                        Toast.makeText(ma, "Vous adoptez un chat qui vous débarrasse efficement des nuisibles", Toast.LENGTH_LONG).show();
                        entreprise.setTauxQualConditionTravail(0.15);
                    }
                }
                break;

            case 118: // Employé fait du shopping en ligne
                if (numChoix == 1) { // Le réprimander
                    Toast.makeText(ma, "Vous réprimandez votre employé", Toast.LENGTH_LONG).show();
                } else { // Lui demander s'il a des bons plans
                    Toast.makeText(ma, "Vous obtenez un bon plan shopping mais les autres employés voient mal le fait que vous ne réprimandez pas l'employé", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                }
                break;

            case 119: // Employé dort dans la réserve
                if (numChoix == 1) { // Le laisser se reposer
                    Toast.makeText(ma, "Vous laissez l'employé se reposer et celui-ci à son réveil travillera deux fois plus dur", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.05);
                } else { // Le réveiller
                    Toast.makeText(ma, "Vous réveillez et réprimandez l'employé qui va se remettre aussitôt au travail à moitié endormi", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.05);
                }
                break;

            case 120: // Employé lit au lieu de travailler
                if (numChoix == 1) { // Lui conseiller un autre livre
                    Toast.makeText(ma, "Vous conseillez à votre employé un livre du même genre que vous avez déjà lu", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.05);
                } else { // Lui confisquer
                    Toast.makeText(ma, "Vous lui confisquez son livre et lui demandez de se remettre au travail", Toast.LENGTH_LONG).show();
                }
                break;

            case 121: // Employé surpris sur réseau social
                if (numChoix == 1) { // Le réprimender
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "L'employé effectuait effectivement des recherches dans le cadre d'études du marché et est mécontent que vous ne l'avez pas cru", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                    } else {
                        Toast.makeText(ma, "Vous le répimandez et lui demandez de se remttre au travail, ce qu'il fait aussitôt", Toast.LENGTH_LONG).show();
                    }
                } else { // Lui dire qu'il n'y a pas de soucis
                    Toast.makeText(ma, "L'employé effectuait peut être effectivement des recherches professionnelles, mais vous ne le saurez jamais", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                }
                break;

            case 122: // Contable a détourné argent pour une affaire
                if (numChoix == 1) { // Le renvoyer
                    Toast.makeText(ma, "Le comptable disparait le lendemain avec les 500$ volés", Toast.LENGTH_LONG).show();
                    if (entreprise.payer(500)) {} else {
                        entreprise.setArgent(0);
                    }
                } else { // Lui demander de participer
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Le comptable a en effet trouvé un bon investissement qui vous rapporte 500$", Toast.LENGTH_LONG).show();
                        entreprise.setArgent((int) entreprise.getArgent() + 500 );
                    } else {
                        GestionEvenements.getGestionEvenements().doEvent(122, 1, ma);
                    }
                }
                break;

            case 123: // Employés falsifient feuilles de temps
                if (numChoix == 1) { // Leur demander de rattraper les heures
                    Toast.makeText(ma, "Les employés vont rattraper les heures non travaillées", Toast.LENGTH_LONG).show();
                } else { // Leur demander d'arrêter et de se remmetre au travail
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "Les employés concernés ont étés resurpris une semaine après à falcifier leurs feuilles de temps", Toast.LENGTH_LONG).show();
                        entreprise.setTauxQualConditionTravail(- 0.15);
                    } else {
                        Toast.makeText(ma, "Les employés concernés se sont remis à travailler normalement", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case 124: // Employés complotent contre un autre
                if (numChoix == 1) { // Leur dire que c'est inadmissible
                    Toast.makeText(ma, "Suite à votre intervention les employés cessent de vouloir faire partir la personne visée", Toast.LENGTH_LONG).show();
                } else { // Comploter avec eux
                    Toast.makeText(ma, "Vous complotez avec eux mais l'affaire fait scandale et est reléguée par les médias", Toast.LENGTH_LONG).show();
                    entreprise.setReputation(entreprise.getReputation() - 0.20);
                }
                break;

            case 125: // Demande de don oeuvre caritative
                if (numChoix == 1) { // Faire un don
                    if (entreprise.payer(getEventByNum(125).getPrix1())) {
                        Toast.makeText(ma, "Suite à votre généreux don, l'oeuvre diffuse une image très positive de votre entreprise", Toast.LENGTH_LONG).show();
                        entreprise.setReputation(entreprise.getReputation() + 0.20);
                    } else {
                        Toast.makeText(ma, "Vous répondez que vous n'avez malheureusement pas assez d'argent en ce moment", Toast.LENGTH_LONG).show();
                    }
                } else { // Prétexter ne pas avoir reçu le mail
                    Toast.makeText(ma, "L'oeuvre déplore votre comportement et relègue cela à la presse", Toast.LENGTH_LONG).show();
                    entreprise.setReputation(entreprise.getReputation() - 0.20);
                }
                break;

            case 126: // Gain d'un gros contrat
                if (numChoix == 1) { // Garder une partie pour s'acheter une voiture de luxe
                    Toast.makeText(ma, "Votre comportement est très mal perçu par vos employés et la pressse", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                    entreprise.setReputation(entreprise.getReputation() - 0.10);
                } else { // Donner une prime à chaque employé
                    Toast.makeText(ma, "Le geste touche vos employés et vous en remercie", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.20);
                }
                break;

            case 127: // Employé a des lacunes
                if (numChoix == 1) { // L'encourager
                    Toast.makeText(ma, "Vos encouragements lui ont permis de reprendre confiance en lui et de s'améliorer", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() + 0.10);
                } else { // Le mettre à l'écart
                    Toast.makeText(ma, "Cette mise à l'écart à créé une dépression chez l'employé et démoralisé le reste de l'équipe", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                }
                break;

            case 128: // Deux employés ne s'entendent pas
                if (numChoix == 1) { // Leur demander de se réconcilier
                    Toast.makeText(ma, "Les deux employés ne sont pas arrivés à s'entendre, ce qui a fait échoué le projet et entrainer une perte d'argent", Toast.LENGTH_LONG).show();
                    entreprise.setBonheur(entreprise.getBonheur() - 0.15);
                    if (entreprise.payer(250)) { } else {
                        entreprise.setArgent(0);
                    }
                } else { // Changer une personne d'équipe
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
                    if (randomNum == 1) {
                        Toast.makeText(ma, "L'employé remplacé n'a pas apprécié que ce soit lui que vous ayez changé d'équipe", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() - 0.10);
                    } else {
                        Toast.makeText(ma, "Ce changement d'équipe a été bénéfique aux deux employés et la poursuite du projet", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case 129: // Offre séjour entreprise
                if (numChoix == 1) { // réserver
                    if (entreprise.payer(getEventByNum(129).getPrix1())) {
                        Toast.makeText(ma, "Vous organisez un séjour qui a pour effet de renforcer la cohésion d'équipe", Toast.LENGTH_LONG).show();
                        entreprise.setBonheur(entreprise.getBonheur() + 0.15);
                        entreprise.setTauxQualConditionTravail(0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                    }
                } else { // Ne rien faire
                }
                break;

            case 130: // Offre promo antivirus
                if (numChoix == 1) { // Bénéficier
                    if (entreprise.payer(getEventByNum(130).getPrix1())) {
                        Toast.makeText(ma, "Vous décidez d'acheter un nouvel antivirus plus performant", Toast.LENGTH_LONG).show();
                        entreprise.setNiveauAntivirus(entreprise.getNiveauAntivirus() + 10 - entreprise.getNiveauAntivirus()%10); // passage à l'antivirus supérieur
                        entreprise.changerNomAntivirus(entreprise.getNiveauAntivirus());
                        entreprise.augmenterTauxSecuInfo(0.15);
                    } else {
                        Toast.makeText(ma, "Vous n'avez pas assez d'argent...", Toast.LENGTH_LONG).show();
                    }
                } else { // Laisser passer
                }
                break;
        }
    }

    /**
     * Retourne un evenement de la collection en fonction de son numéro
     * @param num
     * @return Evenement
     * @author casag
     */
    public Evenement getEventByNum(int num) {
        Evenement e = null;
        try {
            for (Evenement evColl : collectionEvenements) {
                if (evColl.getNumero() == num) {
                    e = evColl;
                }
            }
        } catch(Exception ex) {
            String err = ex.toString();
        }
        return e;
    }

}
