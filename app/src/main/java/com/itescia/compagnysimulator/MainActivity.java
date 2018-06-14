package com.itescia.compagnysimulator;


import android.app.AlertDialog;
import android.app.Presentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView textViewLevel, textViewArgent, textViewHomme, textViewAddRessources, textViewNomJoueur, textViewDetailEmployes,
            textViewComptableTitle, textViewLevelOneComptableWorker, textViewLevelTwoComptableWorker, textViewLevelThreeComptableWorker,
            textViewCompetencesTitle, textViewCompetenceCommercial, textViewCompetenceProduction, textViewCompetenceSecurite,
            textViewCompetenceMarketing, textViewCompetenceComptable, textViewCompetenceRd, textViewCompetenceDirection,
            textViewNiveauMoyen, textViewSecuriteTitle, textViewEmployesSecurite, textViewConditionTravail, textViewSecuriteInformatique, textViewSecuriteInformatiqueTitle,
            textViewNiveauSecuriteInformatique, textViewAntivirus, textViewArgentAntivirus, textViewNomAntivirus, /*textViewVersionAntivirus,*/ textViewFirewall, textViewDerniereMiseAJour,
            textViewHeureDerniereMiseAJour, /*textViewArgentFirewall,*/ textViewMiseAJourSysteme, /*textViewArgentMiseAJourSysteme,*/ textViewDerniereMiseAJourSysteme,
            textViewHeureDerniereMiseAJourSysteme, textViewFormationEmployes, textViewArgentFormationEmployes, textViewSousTraiter, textViewArgentSousTraiter,
            textViewInformationSousTraiter, textViewInformationAntivirus, textViewConditionsTravailsTitle, textViewNiveauConditionsTravails, textViewFournitures, textViewArgentFournitures,
            textViewNomFournitures, textViewMedecinTravail, textViewArgentMedecinTravail, textViewHeureDerniereInterventionMedecinTravail, textViewMenage, textViewArgentMenage, textViewDernierMenage, textViewHeureDernierMenage,
            textViewApero, textViewArgentApero, textViewFelicitaion, /*textViewArgentFelicitation, textViewPossibilite, textViewHeurePossibilite,*/ textViewReputationTitle,
            textViewNiveauReputation, textViewParite, textViewCampagneCom, textViewArgentCampagneCom, textViewBonheurTitle, textViewNiveauBonheur, textViewNiveauFormation,
            textViewNiveauReputation2, textViewNiveauSecuriteGlobale, textViewNiveauConditionsTravails2, textViewRessourcesTitle, textViewNiveauRessources,
            textViewNombrePremiereRessources, textViewArgentPremiereRessource, textViewNombreDeuxiemeRessources, textViewArgentDeuxiemeRessource, textViewNombreTroisiemeRessources,
            textViewArgentTroisiemeRessource, TextViewNiveauRessources, textViewClock, tvNiveau, tv_niveaumoyen;


    Typeface typefaceLevel, typefaceRessource, typefaceLvl, typefaceMaj;

    ProgressBar progressBarReputation, progressBarSecurite, progressBarFormation, progressBarBonheur, progressBarRessources, ProgressBarNiveauRessources, progressBarNiveauBonheur, ProgressBarNiveauReputation, ProgressBarParite,
                progressBarNiveauFormation, ProgressBarNiveauReputation2, ProgressBarNiveauSecuriteGlobale, progressBarEmployesSecurite, progressBarConditionTravail, progressBarSecuriteInformatique,
                ProgressBarNiveauConditionsTravails2, progressBarFormationSecuriteInfo, progressBarNiveauConditionsTravails, progressBarNiveauSecuriteInformatique;

    RelativeLayout relativeLayoutHomme, relativeLayoutEmployes, relativeLayoutDetailCommercial, relativeLayoutDetailsCompetences, relativeLayoutDetailsSecurite,
            relativeLayoutDetailsSecuriteInformatique, relativeLayoutProgressBarOneComptableWorker1_1, relativeLayoutProgressBarOneComptableWorker1_2,
            relativeLayoutProgressBarOneComptableWorker1_3, relativeLayoutProgressBarOneComptableWorker1_4, relativeLayoutProgressBarOneComptableWorker1_5,
            relativeLayoutProgressBarOneComptableWorker2_1, relativeLayoutProgressBarOneComptableWorker2_2, relativeLayoutProgressBarOneComptableWorker2_3,
            relativeLayoutProgressBarOneComptableWorker2_4, relativeLayoutProgressBarOneComptableWorker2_5, relativeLayoutProgressBarThreeComptableWorker,
            relativeLayoutProgressBarOneComptableWorker3_1, relativeLayoutProgressBarOneComptableWorker3_2, relativeLayoutProgressBarOneComptableWorker3_3,
            relativeLayoutProgressBarOneComptableWorker3_4, relativeLayoutProgressBarOneComptableWorker3_5, relativeLayoutScrollView, relativeLayoutInformationSousTraiter,
            relativeLayoutInformationAntivirus, relativeLayoutDetailsConditionsTravails, relativeLayoutDetailsReputation, relativeLayoutDetailsBonheur, relativeLayoutDetailsRessources;

    ImageButton imageButtonBackButton, imageButtonBackButtonDetailCommercial, imageButtonBackButtonDetailCompetences, imageButtonBackButtonDetailSecurite,
            imageButtonBackButtonDetailSecuriteInformatique,  imageviewComptable, imageViewCommercial, ImageViewProduction, ImageViewSecurite2,ImageViewCom, imageButtonUpComptableWorker1, imageButtonUpComptableWorker2,
            imageButtonUpComptableWorker3, imageButtonAddComptableWorker, imageButtonUpCEmployesSecurite, imageButtonUpSecuriteInformatique, imageButtonUpFirewall, imageButtonUpMiseAJourSysteme,
            imageButtonUpFormationEmployes, imageButtonUpFormationSousTraiter, imageButtonHelpSousTraiter, imageButtonHideInformationSousTraiter,
            imageButtonUpAntivirus, imageButtonUpConditionTravail, imageButtonUpFournitures, imageButtonUpMedecinTravail, imageButtonUpMenage, imageButtonUpApero,
            imageButtonUpFelicitation, imageButtonBackButtonDetailConditionsTravails, imageButtonBackButtonDetailReputation, imageButtonBackButtonDetailBonheur,
            imageButtonUpNiveauFormation, imageButtonUpNiveauReputation2, ImageButtonHelpParite, ImageButtonUpCampagneCom, ImageButtonHelpCampagneCom, imageButtonUpNiveauSecuriteGlobale, imageButtonUpNiveauConditionsTravails,
            imageButtonBackButtonDetailRessources, ImageViewArgentPremiereRessource, ImageViewArgentDeuxiemeRessource, ImageViewArgentTroisiemeRessource,
            ImageButtonHelpNiveauFormation, ImageButtonHelpNiveauSecuriteGlobale, ImageButtonHelpNiveauConditionTravails, ImageButtonHelpNiveauReputation2,
            imageButtonHelpAntivirus, imageButtonHelpFirewall, imageButtonHelpMiseAJourSysteme, imageButtonHelpFormationEmployes, imageButtonHelpFournitures,
            imageButtonHelpMedecinTravail, imageButtonHelpMenage, imageButtonHelpApero, imageButtonHelpFelicitation, imageButton_addLevel;

    ImageView imageViewGenre, ImageViewComptableWorker;
     Button button_embaucher;
    ArrayList<RelativeLayout> collectionRelativeLAyoutProgressBarComptable;
     ArrayList<ImageButton> colletionImageButtonUpComptable;
     ArrayList<ImageButton> collectionImageButtonBack;
     ArrayList<ImageButton> collectionImageButtonHelp;
     ArrayList<ImageButton> collectionImageButtonUpSecuriteInformatique;
     ArrayList<ImageButton> collectionImageButtonUpConditionsTravails;
     ArrayList<ImageButton> collectionImageButtonUpBonheur;

    Timer _t;
    Timer _tMAJFirewall;
    Timer _tMAJSysteme;
    Timer _tInterventionMedecineTravail;
    Timer _tInterventionMenage;
    Timer _tRandomEvent;
    MainActivity ma;

    Timer _t2;
    int count = 0;

    final String EXTRA_NOM_JOUEUR = "Nom du joueur";
    final String EXTRA_NOM_ENTREPRISE = "Nom de l'entreprise";

    Entreprise entreprise = new Entreprise(EXTRA_NOM_ENTREPRISE);
    /**
     * Fonction d'initialisation de l'activité principale
     *
     * @param savedInstanceState
     * @author zoua, casag, gbon
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma = this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
        bindListener();
        incrementeArgent();
        verifierDerniereMAJFirewall();
        verifierDerniereMAJSysteme();
        verifierDerniereInterventionMedecineTravail();
        verifierDerniereInterventionMenage();
        Temps.getTemps();
        decrementeRessources();
        afficherNoms();
        UpdateUINiveauFormation();

        GestionEvenements.getGestionEvenements().initialize(entreprise); //initialisation de la gestion des évènements
        gestionRandomEvent();
    }

    /**
     * Fonction permettant d'initialiser les éléments du graphique principale
     *
     * @author zoua
     */
    private void initialize() {

        typefaceLevel = Typeface.createFromAsset(getAssets(), "font/fipps_regular.ttf");
        typefaceRessource = Typeface.createFromAsset(getAssets(), "font/Pixeled.ttf");
        typefaceLvl = Typeface.createFromAsset(getAssets(), "font/retganon.ttf");
        //typefaceMaj = Typeface.createFromAsset(getAssets(), "font/pixelArial.ttf");

        //ELEMENTS TEXTES
        textViewLevel = (TextView) findViewById(R.id.TextViewLevel);
        textViewNomJoueur = (TextView) findViewById(R.id.TextViewNomJoueur);
        textViewArgent = (TextView) findViewById(R.id.TextViewArgent);
        //textViewHomme = (TextView) findViewById(R.id.TextViewHomme);
        textViewAddRessources = (TextView) findViewById(R.id.TextViewAddRessources);
        textViewDetailEmployes = (TextView) findViewById(R.id.TextViewDetailEmployes);
        textViewComptableTitle = (TextView) findViewById(R.id.TextViewComptableTitle);
        textViewCompetencesTitle = (TextView) findViewById(R.id.TextViewCompetencesTitle);
        textViewCompetenceDirection = (TextView) findViewById(R.id.TextViewCompetenceDirection);
        textViewNiveauMoyen = (TextView) findViewById(R.id.TextViewNiveauMoyen);
        textViewSecuriteTitle = (TextView) findViewById(R.id.TextViewSecuriteTitle);
        //textViewReputationTitle = (TextView) findViewById(R.id.TextViewReputationTitle);
        textViewEmployesSecurite = (TextView) findViewById(R.id.TextViewEmployesSecurite);
        textViewConditionTravail = (TextView) findViewById(R.id.TextViewConditionTravail);
        textViewSecuriteInformatique = (TextView) findViewById(R.id.TextViewSecuriteInformatique);
        textViewSecuriteInformatiqueTitle = (TextView) findViewById(R.id.TextViewSecuriteInformatiqueTitle);
        textViewNiveauSecuriteInformatique = (TextView) findViewById(R.id.TextViewNiveauSecuriteInformatique);
        textViewNiveauConditionsTravails = (TextView) findViewById(R.id.TextViewNiveauConditionsTravails);
        textViewAntivirus = (TextView) findViewById(R.id.TextViewAntivirus);
        textViewArgentAntivirus = (TextView) findViewById(R.id.TextViewArgentAntivirus);
        textViewNomAntivirus = (TextView) findViewById(R.id.TextViewNomAntivirus);
        //textViewVersionAntivirus = (TextView) findViewById(R.id.TextViewVersionAntivirus);
        textViewFirewall = (TextView) findViewById(R.id.TextViewFirewall);
        textViewDerniereMiseAJour = (TextView) findViewById(R.id.TextViewDerniereMiseAJour);
        textViewHeureDerniereMiseAJour = (TextView) findViewById(R.id.TextViewHeureDerniereMiseAJour);
        //textViewArgentFirewall = (TextView) findViewById(R.id.TextViewArgentFirewall);
        textViewMiseAJourSysteme = (TextView) findViewById(R.id.TextViewMiseAJourSysteme);
        //textViewArgentMiseAJourSysteme = (TextView) findViewById(R.id.TextViewArgentMiseAJourSysteme);
        textViewDerniereMiseAJourSysteme = (TextView) findViewById(R.id.TextViewDerniereMiseAJourSysteme);
        textViewHeureDerniereMiseAJourSysteme = (TextView) findViewById(R.id.TextViewHeureDerniereMiseAJourSysteme);
        textViewFormationEmployes = (TextView) findViewById(R.id.TextViewFormationEmployes);
        textViewArgentFormationEmployes = (TextView) findViewById(R.id.TextViewArgentFormationEmployes);
        textViewSousTraiter = (TextView) findViewById(R.id.TextViewSousTraiter);
        textViewArgentSousTraiter = (TextView) findViewById(R.id.TextViewArgentSousTraiter);
        textViewInformationSousTraiter = (TextView) findViewById(R.id.TextViewInformationSousTraiter);
        textViewInformationAntivirus = (TextView) findViewById(R.id.TextViewInformationAntivirus);
        textViewConditionsTravailsTitle = (TextView) findViewById(R.id.TextViewConditionsTravailsTitle);
        textViewFournitures = (TextView) findViewById(R.id.TextViewFournitures);
        textViewArgentFournitures = (TextView) findViewById(R.id.TextViewArgentFournitures);
        textViewNomFournitures = (TextView) findViewById(R.id.TextViewNomFournitures);
        textViewMedecinTravail = (TextView) findViewById(R.id.TextViewMedecinTravail);
        textViewArgentMedecinTravail = (TextView) findViewById(R.id.TextViewArgentMedecinTravail);
        textViewHeureDerniereInterventionMedecinTravail = (TextView) findViewById(R.id.TextViewHeureDerniereInterventionMedecinTravail);
        textViewMenage = (TextView) findViewById(R.id.TextViewMenage);
        textViewArgentMenage = (TextView) findViewById(R.id.TextViewArgentMenage);
        textViewDernierMenage = (TextView) findViewById(R.id.TextViewDernierMenage);
        textViewHeureDernierMenage = (TextView) findViewById(R.id.TextViewHeureDernierMenage);
        textViewApero = (TextView) findViewById(R.id.TextViewApero);
        textViewArgentApero = (TextView) findViewById(R.id.TextViewArgentApero);
        textViewFelicitaion = (TextView) findViewById(R.id.TextViewFelicitaion);
        //textViewArgentFelicitation = (TextView) findViewById(R.id.TextViewArgentFelicitation);
        //textViewPossibilite = (TextView) findViewById(R.id.TextViewPossibilite);
        //textViewHeurePossibilite = (TextView) findViewById(R.id.TextViewHeurePossibilite);
        textViewReputationTitle = (TextView) findViewById(R.id.TextViewReputationTitle);
        textViewNiveauReputation = (TextView) findViewById(R.id.TextViewNiveauReputation);
        textViewParite = (TextView) findViewById(R.id.TextViewParite);
        textViewCampagneCom = (TextView) findViewById(R.id.TextViewCampagneCom);
        textViewArgentCampagneCom = (TextView) findViewById(R.id.TextViewArgentCampagneCom);
        textViewBonheurTitle = (TextView) findViewById(R.id.TextViewBonheurTitle);
        textViewNiveauBonheur = (TextView) findViewById(R.id.TextViewNiveauBonheur);
        textViewNiveauFormation = (TextView) findViewById(R.id.TextViewNiveauFormation);
        textViewNiveauReputation2 = (TextView) findViewById(R.id.TextViewNiveauReputation2);
        textViewNiveauSecuriteGlobale = (TextView) findViewById(R.id.TextViewNiveauSecuriteGlobale);
        textViewNiveauConditionsTravails2 = (TextView) findViewById(R.id.TextViewNiveauConditionsTravails2);
        textViewRessourcesTitle = (TextView) findViewById(R.id.TextViewRessourcesTitle);
        textViewNiveauRessources = (TextView) findViewById(R.id.TextViewNiveauRessources);
        textViewNombrePremiereRessources = (TextView) findViewById(R.id.TextViewNombrePremiereRessources);
        textViewArgentPremiereRessource = (TextView) findViewById(R.id.TextViewArgentPremiereRessource);
        textViewNombreDeuxiemeRessources = (TextView) findViewById(R.id.TextViewNombreDeuxiemeRessources);
        textViewArgentDeuxiemeRessource = (TextView) findViewById(R.id.TextViewArgentDeuxiemeRessource);
        textViewNombreTroisiemeRessources = (TextView) findViewById(R.id.TextViewNombreTroisiemeRessources);
        textViewArgentTroisiemeRessource = (TextView) findViewById(R.id.TextViewArgentTroisiemeRessource);
        TextViewNiveauRessources = (TextView) findViewById(R.id.TextViewNiveauRessources);
        TextViewNiveauRessources.setText(String.valueOf(Ressources.getInstance()));
        textViewClock = (TextView) findViewById(R.id.TextViewClock);
        tvNiveau = (TextView) findViewById(R.id.tvNiveau);
        tv_niveaumoyen = (TextView) findViewById((R.id.tv_niveaumoyen));
        //textViewNiveauBonheur.setText(String.valueOf(entreprise.getBonheur() * 100));

        textViewArgent.setText("0");
        textViewLevel.setTypeface(typefaceLevel);
        textViewLevel.setText("NIVEAU 1");
        textViewNomJoueur.setTypeface(typefaceLevel);
        textViewArgent.setTypeface(typefaceRessource);
        textViewClock.setTypeface(typefaceRessource);
        textViewAddRessources.setTypeface(typefaceRessource);
        textViewDetailEmployes.setTypeface(typefaceLevel);
        textViewComptableTitle.setTypeface(typefaceLevel);
        textViewSecuriteTitle.setTypeface(typefaceLevel);
//        textViewLevelOneComptableWorker.setTypeface(typefaceLvl);
//        textViewLevelTwoComptableWorker.setTypeface(typefaceLvl);
//        textViewLevelThreeComptableWorker.setTypeface(typefaceLvl);
        textViewCompetencesTitle.setTypeface(typefaceLevel);
        //textViewReputationTitle.setTypeface(typefaceLevel);
//        textViewCompetenceCommercial.setTypeface(typefaceLvl);
//        textViewCompetenceProduction.setTypeface(typefaceLvl);
//        textViewCompetenceSecurite.setTypeface(typefaceLvl);
//        textViewCompetenceMarketing.setTypeface(typefaceLvl);
//        textViewCompetenceComptable.setTypeface(typefaceLvl);
//        textViewCompetenceRd.setTypeface(typefaceLvl);
//        textViewCompetenceDirection.setTypeface(typefaceLvl);
        textViewNiveauMoyen.setTypeface(typefaceLvl);
        textViewEmployesSecurite.setTypeface(typefaceLvl);
        textViewConditionTravail.setTypeface(typefaceLvl);
        textViewSecuriteInformatique.setTypeface(typefaceLvl);
        textViewSecuriteInformatiqueTitle.setTypeface(typefaceLevel);
        textViewConditionsTravailsTitle.setTypeface(typefaceLevel);
        textViewNiveauSecuriteInformatique.setTypeface(typefaceLevel);
        textViewNiveauConditionsTravails.setTypeface(typefaceLevel);
        textViewAntivirus.setTypeface(typefaceLvl);
        textViewFournitures.setTypeface(typefaceLvl);
        textViewMedecinTravail.setTypeface(typefaceLvl);
        textViewMenage.setTypeface(typefaceLvl);
        textViewApero.setTypeface(typefaceLvl);
        textViewFirewall.setTypeface(typefaceLvl);
        textViewMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewFormationEmployes.setTypeface(typefaceLvl);
        textViewSousTraiter.setTypeface(typefaceLvl);
        textViewDerniereMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewHeureDerniereMiseAJour.setTypeface(typefaceLvl);
        textViewHeureDerniereMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewHeureDerniereInterventionMedecinTravail.setTypeface(typefaceLvl);
        textViewHeureDernierMenage.setTypeface(typefaceLvl);
        //textViewPossibilite.setTypeface(typefaceLvl);
        //textViewHeurePossibilite.setTypeface(typefaceLvl);
        //textViewArgentFirewall.setTypeface(typefaceLvl);
        //textViewArgentMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewArgentFormationEmployes.setTypeface(typefaceLvl);
        textViewArgentAntivirus.setTypeface(typefaceLvl);
        textViewArgentFournitures.setTypeface(typefaceLvl);
        textViewArgentMedecinTravail.setTypeface(typefaceLvl);
        textViewArgentMenage.setTypeface(typefaceLvl);
        textViewArgentApero.setTypeface(typefaceLvl);
        //textViewArgentFelicitation.setTypeface(typefaceLvl);
        textViewFelicitaion.setTypeface(typefaceLvl);
        textViewDerniereMiseAJour.setTypeface(typefaceLvl);
        textViewDernierMenage.setTypeface(typefaceLvl);
        textViewArgentSousTraiter.setTypeface(typefaceLvl);
        textViewInformationSousTraiter.setTypeface(typefaceLvl);
        textViewInformationAntivirus.setTypeface(typefaceLvl);
        textViewNomAntivirus.setTypeface(typefaceRessource);
        textViewNomFournitures.setTypeface(typefaceRessource);
        //textViewVersionAntivirus.setTypeface(typefaceRessource);
        textViewReputationTitle.setTypeface(typefaceLevel);
        textViewBonheurTitle.setTypeface(typefaceLevel);
        textViewNiveauReputation.setTypeface(typefaceLevel);
        textViewParite.setTypeface(typefaceLvl);
        textViewCampagneCom.setTypeface(typefaceLvl);
        textViewArgentCampagneCom.setTypeface(typefaceLvl);
        textViewNiveauBonheur.setTypeface(typefaceLevel);
        textViewNiveauFormation.setTypeface(typefaceLvl);
        textViewNiveauReputation2.setTypeface(typefaceLvl);
        textViewNiveauSecuriteGlobale.setTypeface(typefaceLvl);
        textViewNiveauConditionsTravails2.setTypeface(typefaceLvl);
        textViewNiveauRessources.setTypeface(typefaceLevel);
        textViewNombrePremiereRessources.setTypeface(typefaceLvl);
        textViewArgentPremiereRessource.setTypeface(typefaceLvl);
        textViewNombreDeuxiemeRessources.setTypeface(typefaceLvl);
        textViewArgentDeuxiemeRessource.setTypeface(typefaceLvl);
        textViewNombreTroisiemeRessources.setTypeface(typefaceLvl);
        textViewArgentTroisiemeRessource.setTypeface(typefaceLvl);
        textViewRessourcesTitle.setTypeface(typefaceLevel);

        //ELEMENTS PROGRESSBAR
        progressBarBonheur = (ProgressBar) findViewById(R.id.ProgressBarBonheur);
        progressBarFormation = (ProgressBar) findViewById(R.id.ProgressBarFormation);
        progressBarFormation.setProgress((int)(entreprise.getNiveauMoyenFormation()*100));
        progressBarReputation = (ProgressBar) findViewById(R.id.ProgressBarReputation);
        progressBarReputation.setProgress((int)(entreprise.getReputation()*100));
        progressBarRessources = (ProgressBar) findViewById(R.id.ProgressBarRessources);
        progressBarRessources.setProgress(Ressources.getInstance());
        progressBarSecurite = (ProgressBar) findViewById(R.id.ProgressBarSecurite);
        progressBarSecurite.setProgress((int)(entreprise.getTauxSecuGlobal()*100));
        progressBarFormationSecuriteInfo = (ProgressBar) findViewById(R.id.ProgressBarFormationEmployes);
        progressBarFormationSecuriteInfo.setProgress((int)(entreprise.getTauxSecuInfo()*100));
        ProgressBarNiveauRessources = (ProgressBar) findViewById(R.id.ProgressBarNiveauRessources);
        ProgressBarNiveauRessources.setProgress(Ressources.getInstance());
        progressBarNiveauBonheur = (ProgressBar) findViewById(R.id.ProgressBarNiveauBonheur);
        progressBarNiveauBonheur.setProgress((int)(entreprise.getBonheur()*100));
        progressBarNiveauFormation = (ProgressBar) findViewById(R.id.ProgressBarNiveauFormation);
        progressBarNiveauFormation.setProgress((int)(entreprise.getNiveauMoyenFormation()/5*100));
        ProgressBarNiveauReputation = (ProgressBar) findViewById(R.id.ProgressBarNiveauReputation);
        ProgressBarNiveauReputation.setProgress((int)(entreprise.getReputation()*100));
        ProgressBarParite = (ProgressBar) findViewById(R.id.ProgressBarParite);
        ProgressBarParite.setProgress((int)(entreprise.getParite()*100));
        ProgressBarNiveauReputation2 = (ProgressBar) findViewById(R.id.ProgressBarNiveauReputation2);
        ProgressBarNiveauReputation2.setProgress((int)(entreprise.getReputation()*100));
        ProgressBarNiveauSecuriteGlobale = (ProgressBar) findViewById(R.id.ProgressBarNiveauSecuriteGlobale);
        ProgressBarNiveauSecuriteGlobale.setProgress((int)(entreprise.getTauxSecuGlobal()*100));
        ProgressBarNiveauConditionsTravails2 = (ProgressBar) findViewById(R.id.ProgressBarNiveauConditionsTravails2);
        ProgressBarNiveauConditionsTravails2.setProgress((int)(entreprise.getTauxQualConditionTravail()*100));
        progressBarEmployesSecurite = (ProgressBar) findViewById(R.id.ProgressBarEmployesSecurite);
        progressBarEmployesSecurite.setProgress((int)(entreprise.getNiveauMoyenDomaine("Securite")));
        progressBarConditionTravail = (ProgressBar) findViewById(R.id.ProgressBarConditionTravail);
        progressBarConditionTravail.setProgress((int)(entreprise.getTauxQualConditionTravail()*100));
        progressBarSecuriteInformatique = (ProgressBar) findViewById(R.id.ProgressBarSecuriteInformatique);
        progressBarSecuriteInformatique.setProgress((int)(entreprise.getTauxSecuInfo()*100));
        progressBarNiveauConditionsTravails = (ProgressBar) findViewById(R.id.ProgressBarNiveauConditionsTravails);
        progressBarNiveauConditionsTravails.setProgress((int)(entreprise.getTauxQualConditionTravail()*100));
        progressBarNiveauSecuriteInformatique = (ProgressBar) findViewById(R.id.ProgressBarNiveauSecuriteInformatique);
        progressBarNiveauSecuriteInformatique.setProgress((int)(entreprise.getTauxSecuInfo()*100));

        //ELEMENTS RELATIVE LAYOUT
        relativeLayoutHomme = (RelativeLayout) findViewById(R.id.RelativeLayoutHomme);
        relativeLayoutEmployes = (RelativeLayout) findViewById(R.id.RelativeLayoutEmployes);
        relativeLayoutDetailCommercial = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailCommercial);
        relativeLayoutDetailsCompetences = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsCompetences);
        relativeLayoutDetailsSecurite = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsSecurite);
        relativeLayoutDetailsSecuriteInformatique = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsSecuriteInformatique);
//        relativeLayoutScrollView = (RelativeLayout) findViewById(R.id.RelativeLayoutScrollView);
        relativeLayoutInformationSousTraiter = (RelativeLayout) findViewById(R.id.RelativeLayoutInformationSousTraiter);
//        relativeLayoutProgressBarOneComptableWorker1_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_1);
//        relativeLayoutProgressBarOneComptableWorker1_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_2);
//        relativeLayoutProgressBarOneComptableWorker1_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_3);
//        relativeLayoutProgressBarOneComptableWorker1_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_4);
//        relativeLayoutProgressBarOneComptableWorker1_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_5);
//        relativeLayoutProgressBarOneComptableWorker2_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_1);
//        relativeLayoutProgressBarOneComptableWorker2_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_2);
//        relativeLayoutProgressBarOneComptableWorker2_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_3);
//        relativeLayoutProgressBarOneComptableWorker2_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_4);
//        relativeLayoutProgressBarOneComptableWorker2_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_5);
//        relativeLayoutProgressBarThreeComptableWorker = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarThreeComptableWorker);
//        relativeLayoutProgressBarOneComptableWorker3_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
//        relativeLayoutProgressBarOneComptableWorker3_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_2);
//        relativeLayoutProgressBarOneComptableWorker3_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_3);
//        relativeLayoutProgressBarOneComptableWorker3_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_4);
//        relativeLayoutProgressBarOneComptableWorker3_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_5);
        relativeLayoutInformationAntivirus = (RelativeLayout) findViewById(R.id.RelativeLayoutInformationAntivirus);
        relativeLayoutDetailsConditionsTravails = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsConditionsTravails);
        relativeLayoutDetailsReputation = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsReputation);
        relativeLayoutDetailsBonheur = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsBonheur);
        relativeLayoutDetailsRessources = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsRessources);

        //ELEMENTS IMAGE BUTTON
//        imageButtonAddComptableWorker = (ImageButton) findViewById(R.id.ImageButtonAddComptableWorker);
        imageButtonBackButton = (ImageButton) findViewById(R.id.ImageButtonBackButton);
        imageButtonBackButtonDetailCommercial = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailCommercial);
        imageButtonBackButtonDetailCompetences = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailCompetences);
        imageButtonBackButtonDetailSecurite = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailSecurite);
        imageButtonBackButtonDetailSecuriteInformatique = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailSecuriteInformatique);
        // Boutons Réputation
        ImageButtonUpCampagneCom = (ImageButton) findViewById(R.id.ImageButtonUpCampagneCom);
        ImageButtonHelpCampagneCom = (ImageButton) findViewById(R.id.ImageButtonHelpCampagneCom);
        // Boutons Employés
        imageviewComptable = (ImageButton) findViewById(R.id.ImageviewComptable);
        imageViewCommercial = (ImageButton) findViewById(R.id.ImageViewCommercial);
        ImageViewProduction = (ImageButton) findViewById(R.id.ImageViewProduction);
        ImageViewSecurite2 = (ImageButton) findViewById(R.id.ImageViewSecurite2);
        ImageViewCom = (ImageButton) findViewById(R.id.ImageViewCom);
        imageViewGenre = (ImageView) findViewById(R.id.imageViewGenre);
        ImageViewComptableWorker = (ImageView) findViewById(R.id.ImageViewComptableWorker);
        imageButton_addLevel = (ImageButton) findViewById(R.id.imageButton_addLevel);
//        imageButtonUpComptableWorker1 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker1);
//        imageButtonUpComptableWorker2 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker2);
//        imageButtonUpComptableWorker3 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker3);
        imageButtonUpCEmployesSecurite = (ImageButton) findViewById(R.id.ImageButtonUpCEmployesSecurite);
        // Boutons sécurité informatique
        imageButtonUpSecuriteInformatique = (ImageButton) findViewById(R.id.ImageButtonUpSecuriteInformatique);
        imageButtonUpAntivirus = (ImageButton) findViewById(R.id.ImageButtonUpAntivirus);
        imageButtonHelpAntivirus = (ImageButton) findViewById(R.id.ImageButtonHelpAntivirus);
        imageButtonUpFirewall = (ImageButton) findViewById(R.id.ImageButtonUpFirewall);
        imageButtonHelpFirewall = (ImageButton) findViewById(R.id.ImageButtonHelpFirewall);
        imageButtonUpMiseAJourSysteme = (ImageButton) findViewById(R.id.ImageButtonUpMiseAJourSysteme);
        imageButtonHelpMiseAJourSysteme = (ImageButton) findViewById(R.id.ImageButtonHelpMiseAJourSysteme);
        imageButtonUpFormationEmployes = (ImageButton) findViewById(R.id.ImageButtonUpFormationEmployes);
        imageButtonHelpFormationEmployes = (ImageButton) findViewById(R.id.ImageButtonHelpFormationEmployes);
        imageButtonUpFormationSousTraiter = (ImageButton) findViewById(R.id.ImageButtonUpFormationSousTraiter);
        imageButtonHelpSousTraiter = (ImageButton) findViewById(R.id.ImageButtonHelpSousTraiter);
        imageButtonHideInformationSousTraiter = (ImageButton) findViewById(R.id.ImageButtonHideInformationSousTraiter);
        // Boutons conditions de travail
        imageButtonUpConditionTravail = (ImageButton) findViewById(R.id.ImageButtonUpConditionTravail);
        imageButtonUpFournitures = (ImageButton) findViewById(R.id.ImageButtonUpFournitures);
        imageButtonHelpFournitures = (ImageButton) findViewById(R.id.ImageButtonHelpFournitures);
        imageButtonUpMedecinTravail = (ImageButton) findViewById(R.id.ImageButtonUpMedecinTravail);
        imageButtonHelpMedecinTravail = (ImageButton) findViewById(R.id.ImageButtonHelpMedecinTravail);
        imageButtonUpMenage = (ImageButton) findViewById(R.id.ImageButtonUpMenage);
        imageButtonHelpMenage = (ImageButton) findViewById(R.id.ImageButtonHelpMenage);
        imageButtonUpApero = (ImageButton) findViewById(R.id.ImageButtonUpApero);
        imageButtonHelpApero = (ImageButton) findViewById(R.id.ImageButtonHelpApero);
        imageButtonUpFelicitation = (ImageButton) findViewById(R.id.ImageButtonUpFelicitation);
        imageButtonHelpFelicitation = (ImageButton) findViewById(R.id.ImageButtonHelpFelicitation);
        // Boutons back détails
        imageButtonBackButtonDetailConditionsTravails = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailConditionsTravails);
        imageButtonBackButtonDetailReputation = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailReputation);
        imageButtonBackButtonDetailBonheur = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailBonheur);
        imageButtonBackButtonDetailRessources = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailRessources);
        // Boutons niveaux
        imageButtonUpNiveauFormation = (ImageButton) findViewById(R.id.ImageButtonUpNiveauFormation);
        imageButtonUpNiveauReputation2 = (ImageButton) findViewById(R.id.ImageButtonUpNiveauReputation2);
        imageButtonUpNiveauSecuriteGlobale = (ImageButton) findViewById(R.id.ImageButtonUpNiveauSecuriteGlobale);
        imageButtonUpNiveauConditionsTravails = (ImageButton) findViewById(R.id.ImageButtonUpNiveauConditionsTravails);
        //Boutons achat ressources
        ImageViewArgentPremiereRessource = (ImageButton) findViewById(R.id.ImageViewArgentPremiereRessource);
        ImageViewArgentDeuxiemeRessource = (ImageButton) findViewById(R.id.ImageViewArgentDeuxiemeRessource);
        ImageViewArgentTroisiemeRessource = (ImageButton) findViewById(R.id.ImageViewArgentTroisiemeRessource);
        //Boutons aide
        //Bonheur
        ImageButtonHelpNiveauFormation = (ImageButton) findViewById(R.id.ImageButtonHelpNiveauFormation);
        ImageButtonHelpNiveauReputation2 = (ImageButton) findViewById(R.id.ImageButtonHelpNiveauReputation2);
        ImageButtonHelpNiveauSecuriteGlobale = (ImageButton) findViewById(R.id.ImageButtonHelpNiveauSecuriteGlobale);
        ImageButtonHelpNiveauConditionTravails = (ImageButton) findViewById(R.id.ImageButtonHelpNiveauConditionTravails);
        ImageButtonHelpParite = (ImageButton) findViewById(R.id.ImageButtonHelpParite);

        button_embaucher = (Button) findViewById((R.id.button_embaucher));
        //COLLECTION D'ELEMNENTS
        collectionRelativeLAyoutProgressBarComptable = new ArrayList<RelativeLayout>();

        colletionImageButtonUpComptable = new ArrayList<ImageButton>();
        colletionImageButtonUpComptable.add(imageButtonUpComptableWorker1);
        colletionImageButtonUpComptable.add(imageButtonUpComptableWorker2);
        colletionImageButtonUpComptable.add(imageButtonUpComptableWorker3);
        colletionImageButtonUpComptable.add(imageButtonUpSecuriteInformatique);

        collectionImageButtonBack = new ArrayList<ImageButton>();
        collectionImageButtonBack.add(imageButtonBackButton);
        collectionImageButtonBack.add(imageButtonBackButtonDetailCommercial);
        collectionImageButtonBack.add(imageButtonBackButtonDetailCompetences);
        collectionImageButtonBack.add(imageButtonBackButtonDetailSecurite);
        collectionImageButtonBack.add(imageButtonBackButtonDetailSecuriteInformatique);
        collectionImageButtonBack.add(imageButtonBackButtonDetailConditionsTravails);
        collectionImageButtonBack.add(imageButtonBackButtonDetailReputation);
        collectionImageButtonBack.add(imageButtonBackButtonDetailBonheur);
        collectionImageButtonBack.add(imageButtonBackButtonDetailRessources);

        collectionImageButtonHelp = new ArrayList<ImageButton>();
        collectionImageButtonHelp.add(imageButtonHelpSousTraiter);

        collectionImageButtonUpSecuriteInformatique = new ArrayList<ImageButton>();
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpAntivirus);
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpFirewall);
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpMiseAJourSysteme);
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpFormationEmployes);
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpFormationSousTraiter);

        collectionImageButtonUpConditionsTravails = new ArrayList<ImageButton>();
        collectionImageButtonUpConditionsTravails.add(imageButtonUpFournitures);
        collectionImageButtonUpConditionsTravails.add(imageButtonUpMedecinTravail);
        collectionImageButtonUpConditionsTravails.add(imageButtonUpMenage);
        collectionImageButtonUpConditionsTravails.add(imageButtonUpApero);
        collectionImageButtonUpConditionsTravails.add(imageButtonUpFelicitation);

        collectionImageButtonUpBonheur = new ArrayList<ImageButton>();
        collectionImageButtonUpBonheur.add(imageButtonUpNiveauFormation);
        collectionImageButtonUpBonheur.add(imageButtonUpNiveauReputation2);
        collectionImageButtonUpBonheur.add(imageButtonUpNiveauSecuriteGlobale);
        collectionImageButtonUpBonheur.add(imageButtonUpNiveauConditionsTravails);

    }

    /**
     * Fonction permettant d'initialiser les événements liés aux éléments du graphisme
     *
     * @author zoua
     */
    private void bindListener() {
        relativeLayoutHomme.setOnClickListener(relativeLayoutHommeListener);
        imageviewComptable.setOnClickListener(imageviewComptableListener);
        imageViewCommercial.setOnClickListener(imageviewCommercialListener);
        ImageViewProduction.setOnClickListener(imageviewProductionListener);
        ImageViewCom.setOnClickListener(imageviewComListener);
        ImageViewSecurite2.setOnClickListener(imageviewSecurite2Listener);

//        imageButtonAddComptableWorker.setOnClickListener(imageButtonAddComptableWorkerListener);
//        for (ImageButton currentImagButtonUpComptable: colletionImageButtonUpComptable) {
//            currentImagButtonUpComptable.setOnClickListener(imageButtonUpComptableWorkerListener);
//        }
        for (ImageButton currentImageButtonBack: collectionImageButtonBack) {
            currentImageButtonBack.setOnClickListener(imageButtonBackButtonListener);
        }
        for (ImageButton currentImageButtonHelp : collectionImageButtonHelp) {
            currentImageButtonHelp.setOnClickListener(imageButtonHelpListener);
        }
        button_embaucher.setOnClickListener(button_embaucherListener);
        imageButton_addLevel.setOnClickListener(imageButton_addLevelListener);
        progressBarFormation.setOnClickListener(progressBarFormationListener);
        progressBarSecurite.setOnClickListener(progressBarSecuriteListener);
        progressBarReputation.setOnClickListener(progressBarReputationListener);
        progressBarBonheur.setOnClickListener(progressBarBonheurListener);
        ImageButtonHelpParite.setOnClickListener(ImageButtonHelpPariteListener);
        ImageButtonUpCampagneCom.setOnClickListener(ImageButtonUpCampagneComListener);
        ImageButtonHelpCampagneCom.setOnClickListener(ImageButtonHelpCampagneComListener);
        imageButtonUpCEmployesSecurite.setOnClickListener(imageButtonUpCEmployesSecuriteListener);
        imageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener);
        imageButtonHideInformationSousTraiter.setOnClickListener(imageButtonHideInformationSousTraiterListener);
        imageButtonUpConditionTravail.setOnClickListener(imageButtonUpConditionTravailListener);
        for (ImageButton currentImageButtonUpSecuriteInformatique : collectionImageButtonUpSecuriteInformatique) {
            currentImageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener2);
        }
        for (ImageButton currentImageButtonUpBonheur : collectionImageButtonUpBonheur) {
            currentImageButtonUpBonheur.setOnClickListener(imageButtonUpBonheurListener);
        }
        imageButtonUpFournitures.setOnClickListener(imageButtonUpFournituresListener);
        imageButtonHelpFournitures.setOnClickListener(imageButtonHelpFournituresListener);
        imageButtonUpMedecinTravail.setOnClickListener(imageButtonUpMedecinTravailListener);
        imageButtonHelpMedecinTravail.setOnClickListener(imageButtonHelpMedecinTravailListener);
        imageButtonUpMenage.setOnClickListener(imageButtonUpMenageListener);
        imageButtonHelpMenage.setOnClickListener(imageButtonHelpMenageListener);
        imageButtonUpApero.setOnClickListener(imageButtonUpAperoListener);
        imageButtonHelpApero.setOnClickListener(imageButtonHelpAperoListener);
        imageButtonUpFelicitation.setOnClickListener(imageButtonUpFelicitationListener);
        imageButtonHelpFelicitation.setOnClickListener(imageButtonHelpFelicitationListener);
        imageButtonUpAntivirus.setOnClickListener(imageButtonUpAntivirusListener);
        imageButtonHelpAntivirus.setOnClickListener(imageButtonHelpAntivirusListener);
        imageButtonUpFirewall.setOnClickListener(imageButtonUpFirewallListener);
        imageButtonHelpFirewall.setOnClickListener(imageButtonHelpFirewallListener);
        imageButtonUpMiseAJourSysteme.setOnClickListener(imageButtonUpMiseAJourSystemeListener);
        imageButtonHelpMiseAJourSysteme.setOnClickListener(imageButtonHelpMiseAJourSystemeListener);
        imageButtonUpFormationEmployes.setOnClickListener(imageButtonUpFormationEmployesListener);
        imageButtonHelpFormationEmployes.setOnClickListener(imageButtonHelpFormationEmployesListener);
        imageButtonUpFormationSousTraiter.setOnClickListener(imageButtonUpFormationSousTraiterListener);
        imageButtonHelpSousTraiter.setOnClickListener(imageButtonHelpSousTraiterListener);
        textViewAddRessources.setOnClickListener(textViewAddRessourcesListener);
        ImageViewArgentPremiereRessource.setOnClickListener(imageViewArgentPremiereRessourceListener);
        ImageViewArgentDeuxiemeRessource.setOnClickListener(imageViewArgentDeuxiemeRessourceListener);
        ImageViewArgentTroisiemeRessource.setOnClickListener(imageViewArgentTroisiemeRessourceListener);
        ImageButtonHelpNiveauFormation.setOnClickListener(ImageButtonHelpNiveauFormationListener);
        ImageButtonHelpNiveauReputation2.setOnClickListener(ImageButtonHelpNiveauReputation2Listener);
        ImageButtonHelpNiveauSecuriteGlobale.setOnClickListener(ImageButtonHelpNiveauSecuriteGlobaleListener);
        ImageButtonHelpNiveauConditionTravails.setOnClickListener(ImageButtonHelpNiveauConditionTravailsListener);

    }

    /**
     * Fonction permettant d'incrémenter automatiquement l'argent
     * Met à jour le temps passé sur la jeu
     * @author zoua, casag
     */
    private void incrementeArgent() {
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Augmentation de l'argent en fonction du taux global de performance de l'entreprise
                entreprise.setArgent((int)(entreprise.getArgent()+(entreprise.getIndiceIncremArgent() * entreprise.getTauxIncremArgent())));
                Temps.getTemps();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewArgent.setText(String.valueOf(entreprise.getArgent()));
                        textViewClock.setText(Temps.getTempsString());
                        checkTime(); // Vérifications pour augmenter niveau
                        //gestionEvenements();
                    }
                });
            }
        }, 500,
                500);
    }

    /**
     * Fonction permettant de gérer le temps passé depuis la dernière MAJ du firewall ainsi que les malus en découlant
     */
    private void verifierDerniereMAJFirewall() {
        _tMAJFirewall = new Timer();
        TimerTask verificationMAJFirewall = new TimerTask () {
            @Override
            public void run () {
                // augmentation du nombre d'heures passées depuis la derière MAJ du firewall
                entreprise.setDerniereMAJFirewall(entreprise.getDerniereMAJFirewall() + 1);
                // diminution du taux de sécurité informatique
                entreprise.augmenterTauxSecuInfo(-0.15);
                // affichage du nombre d'heures passées depuis la dernière MAJ du firewall
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewHeureDerniereMiseAJour.setText("il y a "+entreprise.getDerniereMAJFirewall()+" heure(s)");
                    }
                });
            }
        };

        // planification de la tâche du timer toutes les heures à partir de la première heure
        _tMAJFirewall.schedule (verificationMAJFirewall, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant de mettre à jour le firewall
     */
    private void MAJFirewall() {
            // augmentation du taux de sécurité informatique, seulement si la dernière MAJ date d'au moins 1 heure (afin d'éviter d'exploiter infiniment le bonus)
            if (entreprise.getDerniereMAJFirewall()>=1) {
                entreprise.augmenterTauxSecuInfo(0.30);
            }
            // remise à 0 du nombre d'heures passées depuis la derière MAJ du Firewall
            entreprise.setDerniereMAJFirewall(0);
            // relance du timer de vérification de la denière MAJ du firewall
            _tMAJFirewall.cancel();
            verifierDerniereMAJFirewall();
    }

    /**
     * Fonction permettant de gérer le temps passé depuis la dernière MAJ du système ainsi que les malus en découlant
     */
    private void verifierDerniereMAJSysteme() {
        _tMAJSysteme = new Timer();
        TimerTask verificationMAJSysteme = new TimerTask () {
            @Override
            public void run () {
                // augmentation du nombre d'heures passées depuis la derière MAJ du système
                entreprise.setDerniereMAJSysteme(entreprise.getDerniereMAJSysteme() + 1);
                // diminution du taux de sécurité informatique
                entreprise.augmenterTauxSecuInfo(-0.15);
                // affichage du nombre d'heures passées depuis la dernière MAJ du systeme
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewHeureDerniereMiseAJourSysteme.setText("il y a "+entreprise.getDerniereMAJSysteme()+" heure(s)");
                    }
                });
            }
        };

        // planification de la tâche du timer toutes les heures à partir de la première heure
        _tMAJSysteme.schedule (verificationMAJSysteme, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant de mettre à jour le système
     */
    private void MAJSysteme() {
        // augmentation du taux de sécurité informatique, seulement si la dernière MAJ date d'au moins 1 heure (afin d'éviter d'exploiter infiniment le bonus)
        if (entreprise.getDerniereMAJSysteme()>=1) {
            entreprise.augmenterTauxSecuInfo(0.30);
        }
        // remise à 0 du nombre d'heures passées depuis la derière MAJ du Firewall
        entreprise.setDerniereMAJSysteme(0);
        // relance du timer de vérification de la denière MAJ du système
        _tMAJSysteme.cancel();
        verifierDerniereMAJSysteme();
    }

    /**
     * Fonction permettant de gérer le temps passé depuis la dernière intervention de la médecine du travail ainsi que les malus en découlant
     */
    private void verifierDerniereInterventionMedecineTravail() {
        _tInterventionMedecineTravail = new Timer();
        TimerTask verificationInterventionMedecineTravail = new TimerTask () {
            @Override
            public void run () {
                // augmentation du nombre d'heures passées depuis la dernière intervention de la médecine du travail
                entreprise.setDerniereInterventionMedecineTravail(entreprise.getDerniereInterventionMedecineTravail() + 1);
                // diminution du taux des conditions de travail toutes les 4 heures passées sans intervention
                if(entreprise.getDerniereInterventionMedecineTravail()%4==0) {
                    entreprise.augmenterTauxConditTravail(-0.15);
                }
                // affichage du nombre d'heures passées depuis la dernière intervention de la médecine du travail
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewHeureDerniereInterventionMedecinTravail.setText("il y a "+entreprise.getDerniereInterventionMedecineTravail()+" heure(s)");
                    }
                });
            }
        };

        // planification de la tâche du timer toutes les heures à partir de la première heure
        _tInterventionMedecineTravail.schedule (verificationInterventionMedecineTravail, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant d'actualiser le nombre d'heures depuis la dernière intervention de la médecine du travail
     */
    private void interventionMedecineTravail() {
        // remise à 0 du nombre d'heures passées depuis la derière intervention de la médecine du travail
        entreprise.setDerniereInterventionMedecineTravail(0);
        // augmentation du taux des conditions de travail
        entreprise.augmenterTauxConditTravail(0.20);
        // relance du timer de vérification de la denière intervention de la médecine du travail
        _tInterventionMedecineTravail.cancel();
        verifierDerniereInterventionMedecineTravail();
    }

    /**
     * Fonction permettant de gérer le temps passé depuis la dernière intervention du personnel de ménage ainsi que les malus en découlant
     */
    private void verifierDerniereInterventionMenage() {
        _tInterventionMenage = new Timer();
        TimerTask verificationInterventionMenage = new TimerTask () {
            @Override
            public void run () {
                // augmentation du nombre d'heures passées depuis la dernière intervention
                entreprise.setDerniereInterventionMenage(entreprise.getDerniereInterventionMenage() + 1);
                // diminution du taux des conditions de travail toutes les 2 heures passées sans intervention
                if(entreprise.getDerniereInterventionMenage()%2==0) {
                    entreprise.augmenterTauxConditTravail(-0.15);
                }
                // affichage du nombre d'heures passées depuis la dernière intervention de l'équipe d'entretien
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewHeureDernierMenage.setText("il y a "+entreprise.getDerniereInterventionMenage()+" heure(s)");
                    }
                });
            }
        };

        // planification de la tâche du timer toutes les heures
        _tInterventionMenage.schedule (verificationInterventionMenage, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant d'actualiser le nombre d'heures depuis la dernière intervention du personnel de ménage
     */
    private void interventionMenage() {
        // remise à 0 du nombre d'heures passées depuis la derière intervention du personnel de ménage
        entreprise.setDerniereInterventionMenage(0);
        // augmentation du taux des conditions de travail
        entreprise.augmenterTauxConditTravail(0.10);
        // relance du timer de vérification de la denière intervention du personnel de ménage
        _tInterventionMenage.cancel();
        verifierDerniereInterventionMenage();
    }

    /**
     * Fonction permettant de gérer le timer des événements aléatoires
     */
    private void gestionRandomEvent() {
        _tRandomEvent = new Timer();
        // génération d'un entier aléatorie pour définir au bout de combien de temps l'événement interviendra
        int randomNum = ThreadLocalRandom.current().nextInt(30, 61);
        TimerTask gestionRandomEvent = new TimerTask () {
            @Override
            public void run () {
                // appel de la fonction gérant l'événement aléatoire
                callEvent();
            }
        };

        // Exécution de la tâche au bout du temps aléatoire généré
        _tRandomEvent.schedule (gestionRandomEvent, 1000*randomNum);
    }

    /**
     * Fonction permettant d'appeler l'événement aléatoire et de relancer gestionTimerEvent()
     */
    private void callEvent() {
        // Détermination aléatoire du numéro de l'événement aléatoire à appeler
        int randomEvent = ThreadLocalRandom.current().nextInt(101, 131);
        // Appel de l'événement précédemment déterminé avec la fonction popUpChoice()
        popUpChoice(GestionEvenements.getGestionEvenements().getEventByNum(randomEvent));

        // reset du timer et de la fonction gestionTimerEvent()
        _tRandomEvent.cancel();
        gestionRandomEvent();
    }


    private View.OnClickListener progressBarFormationListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                relativeLayoutEmployes.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutEmployes.setVisibility(View.GONE);
                show = false;
            }
        }
    };

    private View.OnClickListener progressBarSecuriteListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v: : élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                relativeLayoutDetailsSecurite.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutDetailsSecurite.setVisibility(View.GONE);
                show = false;
            }
        }
    };

    private View.OnClickListener progressBarReputationListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                relativeLayoutDetailsReputation.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutDetailsReputation.setVisibility(View.GONE);
                show = false;
            }
        }
    };

    private View.OnClickListener progressBarBonheurListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                relativeLayoutDetailsBonheur.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
                show = false;
            }
        }
    };

    private View.OnClickListener imageButtonHideInformationSousTraiterListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            relativeLayoutInformationSousTraiter.setVisibility(View.GONE);
        }
    };

    private View.OnClickListener relativeLayoutHommeListener = new View.OnClickListener() {
        boolean show = false;

        /**
         * Fonction permettant d'afficher les types d'employés que l'on peut embaucher
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                relativeLayoutEmployes.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutEmployes.setVisibility(View.GONE);
                show = false;
            }
        }
    };

    private View.OnClickListener imageButtonUpSecuriteInformatiqueListener = new View.OnClickListener() {
        boolean show = false;

        /**
         * Fonction permettant d'afficher les informations concernant la sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            relativeLayoutDetailsSecuriteInformatique.setVisibility(View.VISIBLE);
            relativeLayoutDetailsSecurite.setVisibility(View.GONE);
        }
    };

    private View.OnClickListener imageButtonUpSecuriteInformatiqueListener2 = new View.OnClickListener() {
        boolean show = false;

        /**
         * Fonction permettant d'afficher les informations concernant la sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton ImageButtonUpSelected = (ImageButton) findViewById(v.getId());
            if (ImageButtonUpSelected == imageButtonUpAntivirus) {
                if (!show) {
                    relativeLayoutInformationAntivirus.setVisibility(View.VISIBLE);
                    show = true;
                } else {
                    relativeLayoutInformationAntivirus.setVisibility(View.GONE);
                    show = false;
                }
            }
        }
    };

    private View.OnClickListener imageButtonUpBonheurListener = new View.OnClickListener() {
        boolean show = false;

        /**
         * Fonction permettant d'afficher les informations concernant la sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton ImageButtonUpSelected = (ImageButton) findViewById(v.getId());
            if (ImageButtonUpSelected == imageButtonUpNiveauFormation) {
                relativeLayoutDetailsCompetences.setVisibility(View.VISIBLE);
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
            } else if (ImageButtonUpSelected == imageButtonUpNiveauReputation2) {
                relativeLayoutDetailsReputation.setVisibility(View.VISIBLE);
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
            } else if (ImageButtonUpSelected == imageButtonUpNiveauSecuriteGlobale) {
                relativeLayoutDetailsSecurite.setVisibility(View.VISIBLE);
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
            } else if (ImageButtonUpSelected == imageButtonUpNiveauConditionsTravails) {
                relativeLayoutDetailsConditionsTravails.setVisibility(View.VISIBLE);
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
            }
        }
    };

    private View.OnClickListener imageButtonUpConditionTravailListener = new View.OnClickListener() {
        boolean show = false;

        /**
         * Fonction permettant d'afficher les informations concernant la sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton ImageButtonUpSelected = (ImageButton) findViewById(v.getId());
            if (ImageButtonUpSelected == imageButtonUpConditionTravail) {
                if (!show) {
                    relativeLayoutDetailsConditionsTravails.setVisibility(View.VISIBLE);
                    relativeLayoutDetailsSecurite.setVisibility(View.GONE);
                    show = true;
                } else {
                    relativeLayoutDetailsConditionsTravails.setVisibility(View.GONE);
                    show = false;
                }
            }
        }
    };

    private View.OnClickListener imageButtonBackButtonListener = new View.OnClickListener() {
        /**
         * Fonction permettant de revenir en arrière
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton ImageButtonBackSelected = (ImageButton) findViewById(v.getId());
            if (ImageButtonBackSelected == imageButtonBackButton) {
                relativeLayoutEmployes.setVisibility(View.GONE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailCommercial) {
                relativeLayoutDetailCommercial.setVisibility(View.GONE);
                relativeLayoutEmployes.setVisibility(View.VISIBLE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailCompetences) {
                relativeLayoutDetailsCompetences.setVisibility(View.GONE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailSecurite) {
                relativeLayoutDetailsSecurite.setVisibility(View.GONE);
            } else if( ImageButtonBackSelected == imageButtonBackButtonDetailSecuriteInformatique) {
                relativeLayoutDetailsSecuriteInformatique.setVisibility(View.GONE);
                relativeLayoutDetailsSecurite.setVisibility(View.VISIBLE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailConditionsTravails) {
                relativeLayoutDetailsConditionsTravails.setVisibility(View.GONE);
                relativeLayoutDetailsSecurite.setVisibility(View.VISIBLE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailReputation){
                relativeLayoutDetailsReputation.setVisibility(View.GONE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailBonheur) {
                relativeLayoutDetailsBonheur.setVisibility(View.GONE);
            } else if (ImageButtonBackSelected == imageButtonBackButtonDetailRessources) {
                relativeLayoutDetailsRessources.setVisibility(View.GONE);
            }
        }
    };

    private View.OnClickListener imageButtonHelpListener = new View.OnClickListener() {
        /**
         * Fonction permettant de revenir en arrière
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton ImageButtonHelpSelected = (ImageButton) findViewById(v.getId());
            if (ImageButtonHelpSelected == imageButtonHelpSousTraiter) {
                relativeLayoutInformationSousTraiter.setVisibility(View.VISIBLE);
            }
        }
    };
    //***********************************************************//
    //*                 Listeners employés                      *//
    //***********************************************************//
    private View.OnClickListener imageviewComptableListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Comptabilite");
        }
    };
    private View.OnClickListener imageviewCommercialListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Commercial");
        }
    };
    private View.OnClickListener imageviewComListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Communication");
        }
    };
    private View.OnClickListener imageviewProductionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Production");
        }
    };
    private View.OnClickListener imageviewSecurite2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Securite");
        }
    };
    private View.OnClickListener imageButton_addLevelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String cat = String.valueOf(button_embaucher.getTag());
            if(entreprise.payer(100)) {
                entreprise.getEmployeByService(cat).incrementNiveauFormation(1, entreprise);
                UpdateUINiveauFormation();
            } else {
                notEnoughMoney(100);
            }
            UpdateDetailEmploye(cat);
        }
    };
    private View.OnClickListener button_embaucherListener = new View.OnClickListener() {
        String cat = "";
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            //String cat = String.valueOf(button_embaucher.getTag());
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_NEGATIVE:
                        if(entreprise.payer(100)) {
                            int respectPariteAvantRecrutement = entreprise.verifierParite();
                            entreprise.Recruter(cat, 'H');
                            UpdateUINiveauFormation();
                            UpdateDetailEmploye(cat);
                            // Vérification parité
                            if (entreprise.verifierParite() == 1) {
                                popUpInfo("Attention ! La parité au sein de votre entreprise n'est pas respectée car il y a plus d'hommes que de femmes");
                                entreprise.setReputation(entreprise.getReputation() - 0.20);
                            } else {
                                if (entreprise.verifierParite() == 0 && respectPariteAvantRecrutement == 2) {
                                    popUpInfo("La parité est maintenant respectée");
                                    entreprise.setReputation(entreprise.getReputation() + 0.20);
                                }
                            }
                        } else {
                            notEnoughMoney(100);
                        }
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        if(entreprise.payer(100)) {
                            int respectPariteAvantRecrutement = entreprise.verifierParite();
                            entreprise.Recruter(cat, 'F');
                            UpdateUINiveauFormation();
                            UpdateDetailEmploye(cat);
                            // vérification parité
                            if (entreprise.verifierParite() == 2) {
                                popUpInfo("Attention ! La parité n'est pas respectée au sein de votre entreprise car il y a plus de femmes que d'hommes");
                                entreprise.setReputation(entreprise.getReputation() - 0.20);
                            } else {
                                if (entreprise.verifierParite() == 0 && respectPariteAvantRecrutement == 1) {
                                    popUpInfo("La parité est maintenant respectée");
                                    entreprise.setReputation(entreprise.getReputation() + 0.20);
                                }
                            }
                        } else {
                            notEnoughMoney(100);
                        }
                        break;
                }
            }
        };
        @Override
        public void onClick(View v) {
            cat = String.valueOf(button_embaucher.getTag());
            AlertDialog.Builder builder = new AlertDialog.Builder(ma);
            builder.setMessage("Vous allez embaucher un employé dans le service " + cat + " (100$). Homme ou Femme ?").setNegativeButton("Homme", dialogClickListener).setNeutralButton("Femme", dialogClickListener).show();
        }
    };

    private View.OnClickListener imageButtonAddComptableWorkerListener = new View.OnClickListener() {

        /**
         * Fonction permettant d'ajouter un comptable
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            RelativeLayout currentRelativeLayout = new RelativeLayout(getApplicationContext());
            int childCount = relativeLayoutScrollView.getChildCount();

            //Ajout du relativeLayout principal
            RelativeLayout.LayoutParams layoutParamsMain = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            layoutParamsMain.addRule(RelativeLayout.BELOW, R.id.RelativeLayoutComptableWorkerThreeLine);
//            layoutParamsMain.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutComptableWorkerThreeLine);
            layoutParamsMain.setMargins(0, 80, 0, 0);
            relativeLayoutScrollView.addView(currentRelativeLayout, layoutParamsMain);
            currentRelativeLayout.setId(R.id.RelativeLayoutComptableWorkerFourLine);

            //Ajout de l'image Man
            RelativeLayout.LayoutParams layoutParamsMan = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            ImageView imageMan = new ImageView(getApplicationContext());
            imageMan.setImageResource(R.drawable.man);
            imageMan.setId(R.id.ImageViewManFour);
            currentRelativeLayout.addView(imageMan, layoutParamsMan);

            //Ajout de l'image Sexe
            RelativeLayout.LayoutParams layoutParamsSex = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParamsSex.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ImageViewManFour);
            layoutParamsSex.addRule(RelativeLayout.END_OF, R.id.ImageViewManFour);
//            layoutParamsSex.addRule(RelativeLayout.ALIGN_START, R.id.ImageViewFemaleIconOne);
            ImageView imageSex = new ImageView(getApplicationContext());
            imageSex.setImageResource(R.drawable.female);
            imageSex.setId(R.id.ImageViewFemaleIconTwo);
            currentRelativeLayout.addView(imageSex, layoutParamsSex);

            //Ajout du texte du level
            RelativeLayout.LayoutParams layoutParamsLvl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParamsLvl.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ImageViewFemaleIconTwo);
            layoutParamsLvl.addRule(RelativeLayout.END_OF, R.id.ImageViewFemaleIconTwo);
            layoutParamsLvl.setMarginStart(35);
            TextView textViewLvl = new TextView(getApplicationContext());
            textViewLvl.setText(R.string.lvl3);
            textViewLvl.setId(R.id.TextViewLevelFourComptableWorker);
            textViewLvl.setTextColor(getResources().getColor(R.color.fontColor));
            textViewLvl.setTypeface(typefaceLvl);
            textViewLvl.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
            currentRelativeLayout.addView(textViewLvl, layoutParamsLvl);

            //Ajout de la progressbar
            RelativeLayout.LayoutParams layoutParamsProgressBar1 = new RelativeLayout.LayoutParams(relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width, relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width);
            layoutParamsProgressBar1.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.TextViewLevelFourComptableWorker);
            layoutParamsProgressBar1.addRule(RelativeLayout.END_OF, R.id.TextViewLevelFourComptableWorker);
//            layoutParamsSex.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
            layoutParamsProgressBar1.setMarginStart(45);
            RelativeLayout relativeLayout1 = new RelativeLayout(getApplicationContext());
            relativeLayout1.setBackground(getResources().getDrawable(R.drawable.custom_progress_bar_levels_complete));
            relativeLayout1.setAlpha(0.5f);
            relativeLayout1.setId(R.id.RelativeLayout1);
            currentRelativeLayout.addView(relativeLayout1, layoutParamsProgressBar1);

            RelativeLayout.LayoutParams layoutParamsProgressBar2 = new RelativeLayout.LayoutParams(relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width, relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width);
            layoutParamsProgressBar2.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.RelativeLayout1);
            layoutParamsProgressBar2.addRule(RelativeLayout.END_OF, R.id.RelativeLayout1);
            RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
            relativeLayout2.setBackground(getResources().getDrawable(R.drawable.custom_progress_bar_levels_complete));
            relativeLayout2.setAlpha(0.5f);
            relativeLayout2.setId(R.id.RelativeLayout2);
            currentRelativeLayout.addView(relativeLayout2, layoutParamsProgressBar2);

            RelativeLayout.LayoutParams layoutParamsProgressBar3 = new RelativeLayout.LayoutParams(relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width, relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width);
            layoutParamsProgressBar3.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.RelativeLayout2);
            layoutParamsProgressBar3.addRule(RelativeLayout.END_OF, R.id.RelativeLayout2);
            RelativeLayout relativeLayout3 = new RelativeLayout(getApplicationContext());
            relativeLayout3.setBackground(getResources().getDrawable(R.drawable.custom_progress_bar_levels_complete));
            relativeLayout3.setAlpha(0.5f);
            relativeLayout3.setId(R.id.RelativeLayout3);
            currentRelativeLayout.addView(relativeLayout3, layoutParamsProgressBar3);

            RelativeLayout.LayoutParams layoutParamsProgressBar4 = new RelativeLayout.LayoutParams(relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width, relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width);
            layoutParamsProgressBar4.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.RelativeLayout3);
            layoutParamsProgressBar4.addRule(RelativeLayout.END_OF, R.id.RelativeLayout3);
            RelativeLayout relativeLayout4 = new RelativeLayout(getApplicationContext());
            relativeLayout4.setBackground(getResources().getDrawable(R.drawable.custom_progress_bar_levels_complete));
            relativeLayout4.setAlpha(0.5f);
            relativeLayout4.setId(R.id.RelativeLayout4);
            currentRelativeLayout.addView(relativeLayout4, layoutParamsProgressBar4);

            RelativeLayout.LayoutParams layoutParamsProgressBar5 = new RelativeLayout.LayoutParams(relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width, relativeLayoutProgressBarOneComptableWorker1_1.getLayoutParams().width);
            layoutParamsProgressBar5.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.RelativeLayout4);
            layoutParamsProgressBar5.addRule(RelativeLayout.END_OF, R.id.RelativeLayout4);
            RelativeLayout relativeLayout5 = new RelativeLayout(getApplicationContext());
            relativeLayout5.setBackground(getResources().getDrawable(R.drawable.custom_progress_bar_levels_complete));
            relativeLayout5.setAlpha(0.5f);
            relativeLayout5.setId(R.id.RelativeLayout5);
            currentRelativeLayout.addView(relativeLayout5, layoutParamsProgressBar5);

            //Ajout du bouton Up
            RelativeLayout.LayoutParams layoutParamsUp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParamsUp.addRule(RelativeLayout.END_OF, R.id.RelativeLayout5);
//            layoutParamsUp.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
            layoutParamsUp.setMarginStart(45);
            ImageButton imageButtonUp = new ImageButton(getApplicationContext());
            imageButtonUp.setImageResource(R.drawable.up);
            imageButtonUp.setBackgroundColor(getResources().getColor(R.color.colorBackgroundRelativeLayoutEmployes));
            imageButtonUp.setId(R.id.ImageButtonUp);
            currentRelativeLayout.addView(imageButtonUp, layoutParamsUp);
        }
    };

    private View.OnClickListener imageButtonUpComptableWorkerListener = new View.OnClickListener() {
        int compteur = 0;
        RelativeLayout currentRelativeLayout;
        /**
         * Augmenter le niveau d'un comptable
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            ImageButton imageButtonSelected = (ImageButton) findViewById(v.getId());
            if (compteur <5) {
                if (imageButtonSelected == imageButtonUpComptableWorker1) {
                    collectionRelativeLAyoutProgressBarComptable.clear();
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker1_1);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker1_2);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker1_3);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker1_4);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker1_5);

                    currentRelativeLayout = collectionRelativeLAyoutProgressBarComptable.get(compteur);
                    currentRelativeLayout.setAlpha(1);
                } else if (imageButtonSelected == imageButtonUpComptableWorker2) {
                    collectionRelativeLAyoutProgressBarComptable.clear();
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker2_1);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker2_2);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker2_3);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker2_4);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker2_5);

                    currentRelativeLayout = collectionRelativeLAyoutProgressBarComptable.get(compteur);
                    currentRelativeLayout.setAlpha(1);
                } else if (imageButtonSelected == imageButtonUpComptableWorker3) {
                    collectionRelativeLAyoutProgressBarComptable.clear();
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker3_1);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker3_2);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker3_3);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker3_4);
                    collectionRelativeLAyoutProgressBarComptable.add(relativeLayoutProgressBarOneComptableWorker3_5);

                    currentRelativeLayout = collectionRelativeLAyoutProgressBarComptable.get(compteur);
                    currentRelativeLayout.setAlpha(1);
                }
            }
            compteur++;
        }
    };

    private View.OnClickListener imageButtonUpCEmployesSecuriteListener = new View.OnClickListener() {
        /**
         * Redirection vers l'écran pour embaucher un employé de sécurité
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            relativeLayoutDetailsSecurite.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
            UpdateDetailEmploye("Securite");
        }
    };


    /* ********************************** *
     *        CONDITIONS DE TRAVAIL       *
     * ********************************** */

    private View.OnClickListener imageButtonUpFournituresListener = new View.OnClickListener() {
        /**
         * Permet d'améliorer le mobilier/fournitures de travail et de mettre à jour le prix et le nom
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            switch (entreprise.ameliorerMobilier()) {
                case 0:
                    notEnoughMoney(entreprise.determinerSommeAmeliorationMobilier());
                    break;
                case 1:
                    successfulMessage("Meilleur mobilier dejà acheté !");
                    break;
                case 2:
                    successfulMessage("Mobilier amélioré !");
                    break;
        }
            textViewArgentFournitures.setText(Integer.toString(entreprise.determinerSommeAmeliorationMobilier()));
            textViewNomFournitures.setText(entreprise.getNomMobilier());
        }
    };

    private View.OnClickListener imageButtonUpMedecinTravailListener = new View.OnClickListener() {
        /**
         * Permet d'effectuer une visite du médecin de travail
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            if (entreprise.payer(150)) {
                interventionMedecineTravail();
                successfulMessage("Intervention du médecin du travail effectuée !");
                textViewHeureDerniereInterventionMedecinTravail.setText("il y a moins d'une heure");
            } else {
                notEnoughMoney(150);
            }
        }
    };

    private View.OnClickListener imageButtonUpMenageListener = new View.OnClickListener() {
        /**
         * Permet d'effectuer une intervention de l'équipe d'entretien
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            if (entreprise.payer(100)) {
                interventionMenage();
                successfulMessage("Intervention de l'équipe d'entretien effectuée !");
                textViewHeureDernierMenage.setText("il y a moins d'une heure");
            } else {
                notEnoughMoney(100);
            }
        }
    };

    private View.OnClickListener imageButtonUpAperoListener = new View.OnClickListener() {
        /**
         * Permet d'organiser un apéro pour les salariés
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon, casag
         */
        @Override
        public void onClick(View v) {
            switch (entreprise.organiserApero()) {
                case 0:
                    notEnoughMoney(100);
                    break;
                case 1:
                    successfulMessage("Dernier apéro il y a moins de 3h !");
                    break;
                case 2:
                    successfulMessage("Vous organisez un apéro !");
                    break;
                case 3:
                    successfulMessage("Vos employés sont devenus alcooliques ou ne veulent plus travailler !");
                    break;
                case 4: // Trop d'apéros
                    popUpChoice(GestionEvenements.getGestionEvenements().getEventByNum(2));
            }
        }
    };

    private View.OnClickListener imageButtonUpFelicitationListener = new View.OnClickListener() {
        /**
         * Permet de féliciter un employé
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            if (entreprise.feliciterEmploye()) {
                successfulMessage("Vous félicitez un employé !");
            } else {
                successfulMessage("Vous devriez attendre au moins 2h entre chaque félicitation !");
            }
        }
    };

    /* Boutons help conditions de travail */
    private View.OnClickListener imageButtonHelpFournituresListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("L'amélioration des fournitures de bureau permet aux employés de travailler dans de meilleures conditions");
        }
    };
    private View.OnClickListener imageButtonHelpMedecinTravailListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Pensez à faire intervenir la médecine du travail régulièrement afin de détecter les problèmes de vos employés et ainsi améliorer leurs conditions de travail (conseillé toutes les 4h)");
        }
    };
    private View.OnClickListener imageButtonHelpMenageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Il est important de travailler dans un environnement sain (conseillé toutes les 2h");
        }
    };
    private View.OnClickListener imageButtonHelpAperoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Organisez un apéro auquel vous conviez tous vos employés afin de renforcer les liens et la bonne humeur au bureau ! (disponible toutes les 3h)");
        }
    };
    private View.OnClickListener imageButtonHelpFelicitationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Félicitez au hasard un employé pour son travail accomplit afin de motiver vos employés à continuer de bien travailler (disponible toutes les 2h)");
        }
    };

    /* ********************************** *
     *        SECURITE INFORMATIQUE       *
     * ********************************** */

    private View.OnClickListener imageButtonUpAntivirusListener = new View.OnClickListener() {
        /**
         * Permet d'améliorer l'antivirus et de mettre à jour le prix ainsi que le nom de celui-ci
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            switch (entreprise.ameliorerAntivirus()){
                case 0:
                    notEnoughMoney(entreprise.determinerSommeAmeliorationAntivirus());
                    break;
                case 1:
                    successfulMessage("Meilleur antivirus dejà acheté !");
                    break;
                case 2:
                    successfulMessage("Antivirus amélioré !");
                    break;
            }
            textViewArgentAntivirus.setText(Integer.toString(entreprise.determinerSommeAmeliorationAntivirus()));
            textViewNomAntivirus.setText(entreprise.getNomAntivirus());
        }
    };

    private View.OnClickListener imageButtonUpFirewallListener = new View.OnClickListener() {
        /**
         * Permet de mettre à jour le firewall
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            MAJFirewall();
            textViewHeureDerniereMiseAJour.setText("il y a moins d'1 heure");
            successfulMessage("Firewall mis à jour !");
        }
    };

    private View.OnClickListener imageButtonUpMiseAJourSystemeListener = new View.OnClickListener() {
        /**
         * Permet de mettre à jour le système
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            MAJSysteme();
            textViewHeureDerniereMiseAJourSysteme.setText("il y a moins d'1 heure");
            successfulMessage("Système mis à jour !");
        }
    };

    private View.OnClickListener imageButtonUpFormationEmployesListener = new View.OnClickListener() {
        /**
         * Permet de former les employés sur la sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            if(entreprise.formerSecuInfo()){
                successfulMessage("Employés formés à la sécurité informatique !");
                progressBarFormationSecuriteInfo.setProgress(100);
            } else {
                notEnoughMoney(300);
            }
        }
    };

    private View.OnClickListener imageButtonUpFormationSousTraiterListener = new View.OnClickListener() {
        /**
         * Permet de faire appel à un pentester afin de détecter des failles éventuelles de sécurité informatique
         *
         * @param v: élement de la vue sur lequel on clique
         * @author gbon
         */
        @Override
        public void onClick(View v) {
            int nbreFailles = entreprise.pentesting();
            if(nbreFailles == 0){
                notEnoughMoney(500);
            } else {
                successfulMessage(nbreFailles+" failles trouvées !");
            }
        }
    };

    /* Boutons help sécurité informatique */
    private View.OnClickListener imageButtonHelpAntivirusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Améliorer votre antivirus vous permet de mieux défendre votre système informatique contre les virus");
        }
    };
    private View.OnClickListener imageButtonHelpFirewallListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Mettre à jour votre firewall vous permet de mieux vous défendre contre les intrusions");
        }
    };
    private View.OnClickListener imageButtonHelpMiseAJourSystemeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Mettre à jour votre systeme vous permet de limiter les failles dans votre systeme informatique");
        }
    };
    private View.OnClickListener imageButtonHelpFormationEmployesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Former vos employés permet de les rendre plus compétents dans la prévention des risques de sécurité liés à l'informatique");
        }
    };
    private View.OnClickListener imageButtonHelpSousTraiterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Faire appel à un pen tester permet d'essayer de trouver des failles de sécurité dans le système informatique pour les corriger et ainsi limiter les risques d'intrusion");
        }
    };

    private void UpdateDetailEmploye(String cat) {
            textViewComptableTitle.setText(cat);
            button_embaucher.setTag(cat);
            if(cat == "Comptabilite")
                ImageViewComptableWorker.setImageDrawable(getResources().getDrawable(R.drawable.comptableworker));
            else if(cat == "Commercial")
                ImageViewComptableWorker.setImageDrawable(getResources().getDrawable(R.drawable.commercialworker));
            else if(cat == "Communication")
                ImageViewComptableWorker.setImageDrawable(getResources().getDrawable(R.drawable.marketingworker));
            else if(cat == "Production")
                ImageViewComptableWorker.setImageDrawable(getResources().getDrawable(R.drawable.productionworker));
            else if(cat == "Securite")
                ImageViewComptableWorker.setImageDrawable(getResources().getDrawable(R.drawable.securiteworker));

            if(entreprise.EmployeExiste(cat)) {
                imageButton_addLevel.setVisibility(View.VISIBLE);
                imageViewGenre.setVisibility(View.VISIBLE);
                button_embaucher.setVisibility(View.INVISIBLE);
                tvNiveau.setVisibility(View.VISIBLE);
                tvNiveau.setText(String.valueOf(entreprise.getNiveauMoyenDomaine(cat)));
                if(entreprise.getGenre(cat) == 'F') {
                    imageViewGenre.setImageDrawable(getResources().getDrawable(R.drawable.female));
                } else {
                    imageViewGenre.setImageDrawable(getResources().getDrawable(R.drawable.male));
                }
            } else {
                imageViewGenre.setVisibility(View.INVISIBLE);
                button_embaucher.setVisibility(View.VISIBLE);
                tvNiveau.setVisibility(View.INVISIBLE);
                imageButton_addLevel.setVisibility(View.INVISIBLE);
            }
    }

    public void UpdateUINiveauFormation() {
        double test = (int)(entreprise.getNiveauMoyenDomaine("Securite")/5*100);
        tv_niveaumoyen.setText(String.valueOf(entreprise.getNiveauMoyenFormation()));
        progressBarNiveauFormation.setProgress((int)entreprise.getNiveauMoyenFormation()/5*100);
        progressBarFormation.setProgress(((int)(entreprise.getNiveauMoyenFormation()/5*100)));
        progressBarEmployesSecurite.setProgress((int)(entreprise.getNiveauMoyenDomaine("Securite")/5*100));
    }

    /**
     * Met à jour l'écran du détail de la sécurité
     * @author gbon
     */
    private void majGraphSecurite() {
        progressBarSecurite.setProgress((int)(entreprise.getTauxSecuGlobal()*100));
        // MAJ des progressbar de l'onglet Sécurité
        if(relativeLayoutDetailsSecurite.getVisibility() == View.VISIBLE) {
            progressBarEmployesSecurite.setProgress((int) (entreprise.getNiveauMoyenDomaine("Securite")/5*100));
            progressBarConditionTravail.setProgress((int) (entreprise.getTauxQualConditionTravail() * 100));
            progressBarSecuriteInformatique.setProgress((int) (entreprise.getTauxSecuInfo() * 100));
        }
        // MAJ de la progressar + taux de l'onglet détail conditions de travail
        if(relativeLayoutDetailsConditionsTravails.getVisibility() == View.VISIBLE) {
            progressBarNiveauConditionsTravails.setProgress((int) (entreprise.getTauxQualConditionTravail() * 100));
            textViewNiveauConditionsTravails.setText(String.valueOf((int) (entreprise.getTauxQualConditionTravail() * 100)));
        }
        // MAJ de la progressbar + taux de l'onglet détail sécurité informatique
        if(relativeLayoutDetailsSecuriteInformatique.getVisibility() == View.VISIBLE) {
            progressBarNiveauSecuriteInformatique.setProgress((int)(entreprise.getTauxSecuInfo()*100));
            textViewNiveauSecuriteInformatique.setText(String.valueOf((int) (entreprise.getTauxSecuInfo() * 100)));
        }
    }

    /* ********************************** *
     *            REPUTATION              *
     * ********************************** */

    private View.OnClickListener ImageButtonUpCampagneComListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (entreprise.lancerCampagneCom()) {
                successfulMessage("Vous avez lancé une campagne de communication !");
                majGraphReputation();
            } else {
                notEnoughMoney(150);
            }
        }
    };

    private View.OnClickListener ImageButtonHelpCampagneComListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Lancer une campagne de communication permet d'améliorer la visibilité de votre entreprise et ainsi augmenter votre réputation.");
        }
    };

    private View.OnClickListener ImageButtonHelpPariteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Cette barre de progression indique le taux de parité des employés de l'entreprise.");
        }
    };

    /**
     * Met à jour l'écran du détail de la réputation
     * @author gbon
     */
    private void majGraphReputation() {
        progressBarReputation.setProgress((int)(entreprise.getReputation()*100));
        // MAJ des progressbar de l'onglet détail Réputation
        if(relativeLayoutDetailsReputation.getVisibility() == View.VISIBLE) {
            ProgressBarNiveauReputation.setProgress((int)(entreprise.getReputation()*100));
            textViewNiveauReputation.setText(String.valueOf((int) (entreprise.getReputation() * 100)));
            ProgressBarParite.setProgress((int)(entreprise.getParite()*100));
        }
    }

    /* ********************************** *
     *            RESSOURCES              *
     * ********************************** */

    /**
     *  Met à jour les deux progressbar et le texte indiquant le nombre de ressources
     *  @author casag
     */
    private void majGraphRessources() {
        progressBarRessources.setProgress(Ressources.getInstance());
        if(relativeLayoutDetailsRessources.getVisibility() == View.VISIBLE) {
            ProgressBarNiveauRessources.setProgress(Ressources.getInstance());
            TextViewNiveauRessources.setText(String.valueOf(Ressources.getInstance()));
        }
    }

    /**
     * Met à jour l'écran du détail des bonheurs
     * @author casag
     */
    private void majGraphBonheur() {
        entreprise.setTauxBonheur();
        progressBarBonheur.setProgress((int)(entreprise.getBonheur()*100));
        if(relativeLayoutDetailsBonheur.getVisibility() == View.VISIBLE) {
            textViewNiveauBonheur.setText(String.valueOf((int) (entreprise.getBonheur() * 100)));
            progressBarNiveauBonheur.setProgress((int) (entreprise.getBonheur() * 100));
            progressBarNiveauFormation.setProgress((int)(entreprise.getNiveauMoyenFormation()/5*100));
            ProgressBarNiveauReputation2.setProgress((int)(entreprise.getReputation()*100));
            ProgressBarNiveauSecuriteGlobale.setProgress((int)(entreprise.getTauxSecuGlobal()*100));
            ProgressBarNiveauConditionsTravails2.setProgress((int)(entreprise.getTauxQualConditionTravail()*100));
        }
    }

    /**
     * Fonction permettant de décrémenter automatiquement les ressources.
     * Met à jour de multiples éléments
     * @author casag
     */
    private void decrementeRessources() {
        _t2 = new Timer();
        _t2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Ressources.setInstance(Ressources.getInstance()-entreprise.getDiminutionRess());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (Ressources.getInstance() >= 0) {
                            majGraphRessources();
                            majGraphBonheur();
                            majGraphReputation();
                            majGraphSecurite();
                        } else {
                            _t2.cancel();
                            gameOver("Vous n'avez plus assez de ressources. L'entreprise a fait faillite ! \nVous avez tenu "+ Temps.getTempsString()+" minutes.");
                        }
                    }
                });
            }
        }, 2000, 2000);
    }

    private View.OnClickListener textViewAddRessourcesListener = new View.OnClickListener() {
        /**
         * Fonction permettant d'augmenter le nombre de ressources
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            relativeLayoutDetailsRessources.setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener imageViewArgentPremiereRessourceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double test = entreprise.getArgent();
            if(entreprise.getArgent() >= 50) {
                entreprise.acheterRessources(5);
                textViewArgent.setText(String.valueOf(entreprise.getArgent()));
                majGraphRessources();
                successfullyPaidResources(5);

            } else {
                notEnoughMoney(50);
            }
        }
    };

    private View.OnClickListener imageViewArgentDeuxiemeRessourceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double test = entreprise.getArgent();
            if(entreprise.getArgent() >= 90) {
                entreprise.acheterRessources(10);
                textViewArgent.setText(String.valueOf(entreprise.getArgent()));
                progressBarRessources.setProgress(Ressources.getInstance());
                majGraphRessources();
                successfullyPaidResources(10);

            } else {
                notEnoughMoney(90);
            }
        }
    };

    private View.OnClickListener imageViewArgentTroisiemeRessourceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double test = entreprise.getArgent();
            if(entreprise.getArgent() >= 180) {
                entreprise.acheterRessources(20);
                textViewArgent.setText(String.valueOf(entreprise.getArgent()));
                majGraphRessources();
                successfullyPaidResources(20);
            } else {
                notEnoughMoney(180);
            }
        }
    };

    private View.OnClickListener ImageButtonHelpNiveauFormationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Cette barre de progression indique le niveau de formation moyen de tes employés.");
        }
    };

    private View.OnClickListener ImageButtonHelpNiveauReputation2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Cette barre de progression indique le niveau de réputation de ton entreprise.");
        }
    };

    private View.OnClickListener ImageButtonHelpNiveauSecuriteGlobaleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Cette barre de progression indique le niveau de sécurité globale de ton entreprise : cela prend en compte la formation de tes employés de sécurité, la sécurité informatique et les conditions de travail. ");
        }
    };

    private View.OnClickListener ImageButtonHelpNiveauConditionTravailsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUpInfo("Cette barre de progression indique le niveau des conditions de travail. ");
        }
    };

    /**
     * Permet d'afficher un message indiquant le nombre d'argent manquant à l'utilisateur pour acheter
     *
     * @param cout : prix de l'élément que l'utilisateur voulait acheter
     * @author casag
     */
    private void notEnoughMoney(int cout) {
        Toast.makeText(getApplicationContext(), "Pas assez d'argent ! " + (int)(cout - entreprise.getArgent()) + "$ manquant", Toast.LENGTH_LONG).show();
    }

    /**
     * Permet d'afficher un message précisant le nombre de ressources achetées
     * 
     * @param nbRes : nombre de ressources achetées
     * @author casag
     */
    private void successfullyPaidResources(int nbRes) {
        Toast.makeText(getApplicationContext(), nbRes + " ressources achetées !", Toast.LENGTH_LONG).show();
    }

    /**
     * Permet d'afficher un message dont le texte est indiqué en paramètre
     *
     * @param message : message à afficher
     * @author gbon
     */
    private void successfulMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * Affiche un message de Game Over et redémarre le jeu
     * @param raison : ce sera le message à l'intérieur de la popup
     * @author casag
     */
    private void gameOver(String raison) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
        dlgAlert.setMessage(raison);
        dlgAlert.setTitle("Game Over !");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }});
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }

    /**
     * Lance une pop up d'information
     * @param explication : message à afficher
     * @author casag
     */
    public void popUpInfo(String explication) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
        dlgAlert.setMessage(explication);
        dlgAlert.setTitle("Information");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }});
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    /**
     * Lance une pop up d'information
     * @param explication : message à afficher
     * @author casag
     */
    private void popUpInfo(String explication, String titre) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
        dlgAlert.setMessage(explication);
        dlgAlert.setTitle(titre);
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }});
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    private void afficherNoms() {
        Intent intentStart = getIntent();
        if(intentStart != null) {
            textViewNomJoueur.setText(intentStart.getStringExtra(EXTRA_NOM_JOUEUR));
        }
    }

    /**
     * Vérifie le temps, augmente de niveau et fait les modifications adéquates
     * Le système est potientiellement infini sur le modèle :
     * Toutes les minutes impaires, le niveau est augmenté, ainsi que les différents indices
     * et un message est affiché à l'utilisateur
     *
     * @author casag, gbon
     */
    private void checkTime(){
        long timeMillis = Temps.getTemps();
        int niveauActuel = (int) (TimeUnit.MILLISECONDS.toMinutes(timeMillis)/2) + 2;

        // Vérification si la minute est impaire et que le niveau n'ai pas déjà été augmenté
        if(TimeUnit.MILLISECONDS.toMinutes(timeMillis)%2 == 1 && niveauActuel != (int) entreprise.getNiveau()){
            int nouveauNiveau = (int) (TimeUnit.MILLISECONDS.toMinutes(timeMillis)/2) + 2;
            textViewLevel.setText("NIVEAU " + nouveauNiveau);
            entreprise.setIndiceDecrem(nouveauNiveau);
            entreprise.setNiveau(nouveauNiveau);
            entreprise.setIndiceIncremArgent(entreprise.getIndiceIncremArgent() + 5);
            popUpInfo("Les affaires vont bien ! Vous gagnez plus d'argent mais attention, les ressources décrémentent plus rapidement...", "NIVEAU "+nouveauNiveau);
        }
    }

    /**
     * Gère les évènements
     *
     * @author casag
     */
    /*private void gestionEvenements() {
        // Vérification de la parité
        if(entreprise.getEmployes().size() > 3 && (entreprise.getParite() < 0.3 || entreprise.getParite() > 0.6)) {

        }
    }*/

    /**
     * Ouvre une pop up affichant un choix à l'utilisateur, suite à un evenement
     * @param e : Evenement concerné
     * @author casag
     */
    private void popUpChoice(final Evenement e){
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_NEGATIVE:
                        GestionEvenements.getGestionEvenements().doEvent(e.getNumero(), 1, ma);
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        GestionEvenements.getGestionEvenements().doEvent(e.getNumero(), 2, ma);
                        break;
                }
            }
        };

        final AlertDialog.Builder builder = new AlertDialog.Builder(ma);

        ma.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                builder.setMessage(e.getMessage()).setNegativeButton(e.getMessageChoix1(), dialogClickListener).setNeutralButton(e.getMessageChoix2(), dialogClickListener).show();
            }
        });
    }
}