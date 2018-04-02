package com.itescia.compagnysimulator;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView textViewLevel, textViewArgent, textViewHomme, textViewAddRessources, textViewNomJoueur, textViewDetailEmployes,
            textViewComptableTitle, textViewLevelOneComptableWorker, textViewLevelTwoComptableWorker, textViewLevelThreeComptableWorker,
            textViewCompetencesTitle, textViewCompetenceCommercial, textViewCompetenceProduction, textViewCompetenceSecurite,
            textViewCompetenceMarketing, textViewCompetenceComptable, textViewCompetenceRd, textViewCompetenceDirection,
            textViewNiveauMoyen, textViewSecuriteTitle, textViewEmployesSecurite, textViewConditionTravail, textViewSecuriteInformatique, textViewSecuriteInformatiqueTitle,
            textViewNiveauSecuriteInformatique, textViewAntivirus, textViewArgentAntivirus, textViewNomAntivirus, textViewVersionAntivirus, textViewFirewall, textViewDerniereMiseAJour,
            textViewHeureDerniereMiseAJour, textViewArgentFirewall, textViewMiseAJourSysteme, textViewArgentMiseAJourSysteme, textViewDerniereMiseAJourSysteme,
            textViewHeureDerniereMiseAJourSysteme, textViewFormationEmployes, textViewArgentFormationEmployes, textViewSousTraiter, textViewArgentSousTraiter,
            textViewInformationSousTraiter, textViewInformationAntivirus, textViewConditionsTravailsTitle, textViewNiveauConditionsTravails, textViewFournitures, textViewArgentFournitures,
            textViewNomFournitures, textViewMedecinTravail, textViewArgentMedecinTravail, textViewMenage, textViewArgentMenage, textViewDernierMenage, textViewHeureDerniereMenage,
            textViewApero, textViewArgentApero, textViewFelicitaion, textViewArgentFelicitation, textViewPossibilite, textViewHeurePossibilite, textViewReputationTitle,
            textViewNiveauReputation, textViewParite, textViewCampagneCom, textViewArgentCampagneCom, textViewBonheurTitle, textViewNiveauBonheur, textViewNiveauFormation,
            textViewNiveauReputation2, textViewNiveauSecuriteGlobale, textViewNiveauConditionsTravails2, textViewRessourcesTitle, textViewNiveauRessources,
            textViewNombrePremiereRessources, textViewArgentPremiereRessource, textViewNombreDeuxiemeRessources, textViewArgentDeuxiemeRessource, textViewNombreTroisiemeRessources,
            textViewArgentTroisiemeRessource, TextViewNiveauRessources;


    Typeface typefaceLevel, typefaceRessource, typefaceLvl, typefaceMaj;

    ProgressBar progressBarReputation, progressBarSecurite, progressBarFormation, progressBarBonheur, progressBarRessources, ProgressBarNiveauRessources;

    RelativeLayout relativeLayoutHomme, relativeLayoutEmployes, relativeLayoutDetailCommercial, relativeLayoutDetailsCompetences, relativeLayoutDetailsSecurite,
            relativeLayoutDetailsSecuriteInformatique, relativeLayoutProgressBarOneComptableWorker1_1, relativeLayoutProgressBarOneComptableWorker1_2,
            relativeLayoutProgressBarOneComptableWorker1_3, relativeLayoutProgressBarOneComptableWorker1_4, relativeLayoutProgressBarOneComptableWorker1_5,
            relativeLayoutProgressBarOneComptableWorker2_1, relativeLayoutProgressBarOneComptableWorker2_2, relativeLayoutProgressBarOneComptableWorker2_3,
            relativeLayoutProgressBarOneComptableWorker2_4, relativeLayoutProgressBarOneComptableWorker2_5, relativeLayoutProgressBarThreeComptableWorker,
            relativeLayoutProgressBarOneComptableWorker3_1, relativeLayoutProgressBarOneComptableWorker3_2, relativeLayoutProgressBarOneComptableWorker3_3,
            relativeLayoutProgressBarOneComptableWorker3_4, relativeLayoutProgressBarOneComptableWorker3_5, relativeLayoutScrollView, relativeLayoutInformationSousTraiter,
            relativeLayoutInformationAntivirus, relativeLayoutDetailsConditionsTravails, relativeLayoutDetailsReputation, relativeLayoutDetailsBonheur, relativeLayoutDetailsRessources;

    ImageButton imageButtonBackButton, imageButtonBackButtonDetailCommercial, imageButtonBackButtonDetailCompetences, imageButtonBackButtonDetailSecurite,
            imageButtonBackButtonDetailSecuriteInformatique,  imageviewComptable, imageButtonUpComptableWorker1, imageButtonUpComptableWorker2,
            imageButtonUpComptableWorker3, imageButtonAddComptableWorker, imageButtonUpSecuriteInformatique, imageButtonHelpSousTraiter, imageButtonHideInformationSousTraiter,
            imageButtonUpAntivirus, imageButtonUpConditionTravail, imageButtonUpFournitures, imageButtonBackButtonDetailConditionsTravails, imageButtonBackButtonDetailReputation,
            imageButtonBackButtonDetailBonheur, imageButtonUpNiveauFormation, imageButtonUpNiveauReputation2, imageButtonUpNiveauSecuriteGlobale, imageButtonUpNiveauConditionsTravails,
            imageButtonBackButtonDetailRessources, ImageViewArgentPremiereRessource, ImageViewArgentDeuxiemeRessource, ImageViewArgentTroisiemeRessource;
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

    // Entreprise entreprise = new Entreprise("Nom entreprise");


    Timer _t2;
    int count = 0;

    final String EXTRA_NOM_JOUEUR = "Nom du joueur";
    final String EXTRA_NOM_ENTREPRISE = "Nom de l'entreprise";

    Entreprise entreprise = new Entreprise(EXTRA_NOM_ENTREPRISE);

    /**
     * Fonction d'initialisation de l'activité principale
     *
     * @param savedInstanceState
     * @author zoua
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
        bindListener();
        incrementeArgent();
        verifierDerniereMAJFirewall();
        verifierDerniereMAJSysteme();
        verifierDerniereInterventionMedecineTravail();
        verifierDerniereInterventionMenage();
        decrementeRessources();
        afficherNoms();
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
        textViewHomme = (TextView) findViewById(R.id.TextViewHomme);
        textViewAddRessources = (TextView) findViewById(R.id.TextViewAddRessources);
        textViewDetailEmployes = (TextView) findViewById(R.id.TextViewDetailEmployes);
        textViewComptableTitle = (TextView) findViewById(R.id.TextViewComptableTitle);
        textViewLevelOneComptableWorker = (TextView) findViewById(R.id.TextViewLevelOneComptableWorker);
        textViewLevelTwoComptableWorker = (TextView) findViewById(R.id.TextViewLevelTwoComptableWorker);
        textViewLevelThreeComptableWorker = (TextView) findViewById(R.id.TextViewLevelThreeComptableWorker);
        textViewCompetencesTitle = (TextView) findViewById(R.id.TextViewCompetencesTitle);
        textViewCompetenceCommercial = (TextView) findViewById(R.id.TextViewCompetenceCommercial);
        textViewCompetenceProduction = (TextView) findViewById(R.id.TextViewCompetenceProduction);
        textViewCompetenceSecurite = (TextView) findViewById(R.id.TextViewCompetenceSecurite);
        textViewCompetenceMarketing = (TextView) findViewById(R.id.TextViewCompetenceMarketing);
        textViewCompetenceComptable = (TextView) findViewById(R.id.TextViewCompetenceComptable);
        textViewCompetenceRd = (TextView) findViewById(R.id.TextViewCompetenceRd);
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
        textViewVersionAntivirus = (TextView) findViewById(R.id.TextViewVersionAntivirus);
        textViewFirewall = (TextView) findViewById(R.id.TextViewFirewall);
        textViewDerniereMiseAJour = (TextView) findViewById(R.id.TextViewDerniereMiseAJour);
        textViewHeureDerniereMiseAJour = (TextView) findViewById(R.id.TextViewHeureDerniereMiseAJour);
        textViewArgentFirewall = (TextView) findViewById(R.id.TextViewArgentFirewall);
        textViewMiseAJourSysteme = (TextView) findViewById(R.id.TextViewMiseAJourSysteme);
        textViewArgentMiseAJourSysteme = (TextView) findViewById(R.id.TextViewArgentMiseAJourSysteme);
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
        textViewMenage = (TextView) findViewById(R.id.TextViewMenage);
        textViewArgentMenage = (TextView) findViewById(R.id.TextViewArgentMenage);
        textViewDernierMenage = (TextView) findViewById(R.id.TextViewDernierMenage);
        textViewHeureDerniereMenage = (TextView) findViewById(R.id.TextViewHeureDerniereMenage);
        textViewApero = (TextView) findViewById(R.id.TextViewApero);
        textViewArgentApero = (TextView) findViewById(R.id.TextViewArgentApero);
        textViewFelicitaion = (TextView) findViewById(R.id.TextViewFelicitaion);
        textViewArgentFelicitation = (TextView) findViewById(R.id.TextViewArgentFelicitation);
        textViewPossibilite = (TextView) findViewById(R.id.TextViewPossibilite);
        textViewHeurePossibilite = (TextView) findViewById(R.id.TextViewHeurePossibilite);
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

        textViewArgent.setText("0");
        textViewNomJoueur.setVisibility(View.GONE);

        textViewLevel.setTypeface(typefaceLevel);
        textViewNomJoueur.setTypeface(typefaceLevel);
        textViewArgent.setTypeface(typefaceRessource);
        textViewHomme.setTypeface(typefaceRessource);
        textViewAddRessources.setTypeface(typefaceRessource);
        textViewDetailEmployes.setTypeface(typefaceLevel);
        textViewComptableTitle.setTypeface(typefaceLevel);
        textViewSecuriteTitle.setTypeface(typefaceLevel);
        textViewLevelOneComptableWorker.setTypeface(typefaceLvl);
        textViewLevelTwoComptableWorker.setTypeface(typefaceLvl);
        textViewLevelThreeComptableWorker.setTypeface(typefaceLvl);
        textViewCompetencesTitle.setTypeface(typefaceLevel);
        //textViewReputationTitle.setTypeface(typefaceLevel);
        textViewCompetenceCommercial.setTypeface(typefaceLvl);
        textViewCompetenceProduction.setTypeface(typefaceLvl);
        textViewCompetenceSecurite.setTypeface(typefaceLvl);
        textViewCompetenceMarketing.setTypeface(typefaceLvl);
        textViewCompetenceComptable.setTypeface(typefaceLvl);
        textViewCompetenceRd.setTypeface(typefaceLvl);
        textViewCompetenceDirection.setTypeface(typefaceLvl);
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
        textViewHeureDerniereMenage.setTypeface(typefaceLvl);
        textViewPossibilite.setTypeface(typefaceLvl);
        textViewHeurePossibilite.setTypeface(typefaceLvl);
        textViewArgentFirewall.setTypeface(typefaceLvl);
        textViewArgentMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewArgentFormationEmployes.setTypeface(typefaceLvl);
        textViewArgentAntivirus.setTypeface(typefaceLvl);
        textViewArgentFournitures.setTypeface(typefaceLvl);
        textViewArgentMedecinTravail.setTypeface(typefaceLvl);
        textViewArgentMenage.setTypeface(typefaceLvl);
        textViewArgentApero.setTypeface(typefaceLvl);
        textViewArgentFelicitation.setTypeface(typefaceLvl);
        textViewFelicitaion.setTypeface(typefaceLvl);
        textViewDerniereMiseAJour.setTypeface(typefaceLvl);
        textViewDernierMenage.setTypeface(typefaceLvl);
        textViewArgentSousTraiter.setTypeface(typefaceLvl);
        textViewInformationSousTraiter.setTypeface(typefaceLvl);
        textViewInformationAntivirus.setTypeface(typefaceLvl);
        textViewNomAntivirus.setTypeface(typefaceRessource);
        textViewNomFournitures.setTypeface(typefaceRessource);
        textViewVersionAntivirus.setTypeface(typefaceRessource);
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
        textViewNiveauConditionsTravails2.setTypeface(typefaceLevel);
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
        progressBarBonheur.setProgress(30);
        progressBarFormation = (ProgressBar) findViewById(R.id.ProgressBarFormation);
        progressBarFormation.setProgress(30);
        progressBarReputation = (ProgressBar) findViewById(R.id.ProgressBarReputation);
        progressBarReputation.setProgress(30);
        progressBarRessources = (ProgressBar) findViewById(R.id.ProgressBarRessources);
        progressBarRessources.setProgress(Ressources.getInstance());
        progressBarSecurite = (ProgressBar) findViewById(R.id.ProgressBarSecurite);
        progressBarSecurite.setProgress(30);
        ProgressBarNiveauRessources = (ProgressBar) findViewById(R.id.ProgressBarNiveauRessources);
        ProgressBarNiveauRessources.setProgress(Ressources.getInstance());

        //ELEMENTS RELATIVE LAYOUT
        relativeLayoutHomme = (RelativeLayout) findViewById(R.id.RelativeLayoutHomme);
        relativeLayoutEmployes = (RelativeLayout) findViewById(R.id.RelativeLayoutEmployes);
        relativeLayoutDetailCommercial = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailCommercial);
        relativeLayoutDetailsCompetences = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsCompetences);
        relativeLayoutDetailsSecurite = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsSecurite);
        relativeLayoutDetailsSecuriteInformatique = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsSecuriteInformatique);
        relativeLayoutScrollView = (RelativeLayout) findViewById(R.id.RelativeLayoutScrollView);
        relativeLayoutInformationSousTraiter = (RelativeLayout) findViewById(R.id.RelativeLayoutInformationSousTraiter);
        relativeLayoutProgressBarOneComptableWorker1_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_1);
        relativeLayoutProgressBarOneComptableWorker1_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_2);
        relativeLayoutProgressBarOneComptableWorker1_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_3);
        relativeLayoutProgressBarOneComptableWorker1_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_4);
        relativeLayoutProgressBarOneComptableWorker1_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker1_5);
        relativeLayoutProgressBarOneComptableWorker2_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_1);
        relativeLayoutProgressBarOneComptableWorker2_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_2);
        relativeLayoutProgressBarOneComptableWorker2_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_3);
        relativeLayoutProgressBarOneComptableWorker2_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_4);
        relativeLayoutProgressBarOneComptableWorker2_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker2_5);
        relativeLayoutProgressBarThreeComptableWorker = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarThreeComptableWorker);
        relativeLayoutProgressBarOneComptableWorker3_1 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
        relativeLayoutProgressBarOneComptableWorker3_2 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_2);
        relativeLayoutProgressBarOneComptableWorker3_3 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_3);
        relativeLayoutProgressBarOneComptableWorker3_4 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_4);
        relativeLayoutProgressBarOneComptableWorker3_5 = (RelativeLayout) findViewById(R.id.RelativeLayoutProgressBarOneComptableWorker3_5);
        relativeLayoutInformationAntivirus = (RelativeLayout) findViewById(R.id.RelativeLayoutInformationAntivirus);
        relativeLayoutDetailsConditionsTravails = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsConditionsTravails);
        relativeLayoutDetailsReputation = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsReputation);
        relativeLayoutDetailsBonheur = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsBonheur);
        relativeLayoutDetailsRessources = (RelativeLayout) findViewById(R.id.RelativeLayoutDetailsRessources);

        //ELEMENTS IMAGE BUTTON
        imageButtonAddComptableWorker = (ImageButton) findViewById(R.id.ImageButtonAddComptableWorker);
        imageButtonBackButton = (ImageButton) findViewById(R.id.ImageButtonBackButton);
        imageButtonBackButtonDetailCommercial = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailCommercial);
        imageButtonBackButtonDetailCompetences = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailCompetences);
        imageButtonBackButtonDetailSecurite = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailSecurite);
        imageButtonBackButtonDetailSecuriteInformatique = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailSecuriteInformatique);
        imageviewComptable = (ImageButton) findViewById(R.id.ImageviewComptable);
        imageButtonUpComptableWorker1 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker1);
        imageButtonUpComptableWorker2 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker2);
        imageButtonUpComptableWorker3 = (ImageButton) findViewById(R.id.ImageButtonUpComptableWorker3);
        imageButtonUpSecuriteInformatique = (ImageButton) findViewById(R.id.ImageButtonUpSecuriteInformatique);
        imageButtonHelpSousTraiter = (ImageButton) findViewById(R.id.ImageButtonHelpSousTraiter);
        imageButtonHideInformationSousTraiter = (ImageButton) findViewById(R.id.ImageButtonHideInformationSousTraiter);
        imageButtonUpAntivirus = (ImageButton) findViewById(R.id.ImageButtonUpAntivirus);
        imageButtonUpConditionTravail = (ImageButton) findViewById(R.id.ImageButtonUpConditionTravail);
        imageButtonUpFournitures = (ImageButton) findViewById(R.id.ImageButtonUpFournitures);
        imageButtonBackButtonDetailConditionsTravails = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailConditionsTravails);
        imageButtonBackButtonDetailReputation = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailReputation);
        imageButtonBackButtonDetailBonheur = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailBonheur);
        imageButtonUpNiveauFormation = (ImageButton) findViewById(R.id.ImageButtonUpNiveauFormation);
        imageButtonUpNiveauReputation2 = (ImageButton) findViewById(R.id.ImageButtonUpNiveauReputation2);
        imageButtonUpNiveauSecuriteGlobale = (ImageButton) findViewById(R.id.ImageButtonUpNiveauSecuriteGlobale);
        imageButtonUpNiveauConditionsTravails = (ImageButton) findViewById(R.id.ImageButtonUpNiveauConditionsTravails);
        imageButtonBackButtonDetailRessources = (ImageButton) findViewById(R.id.ImageButtonBackButtonDetailRessources);
        //Boutons achat ressources
        ImageViewArgentPremiereRessource = (ImageButton) findViewById(R.id.ImageViewArgentPremiereRessource);
        ImageViewArgentDeuxiemeRessource = (ImageButton) findViewById(R.id.ImageViewArgentDeuxiemeRessource);
        ImageViewArgentTroisiemeRessource = (ImageButton) findViewById(R.id.ImageViewArgentTroisiemeRessource);

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

        collectionImageButtonUpConditionsTravails = new ArrayList<ImageButton>();
        collectionImageButtonUpConditionsTravails.add(imageButtonUpFournitures);

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
        textViewLevel.setOnClickListener(textViewLevelListener);
        relativeLayoutHomme.setOnClickListener(relativeLayoutHommeListener);
        imageviewComptable.setOnClickListener(imageviewComptableListener);
        imageButtonAddComptableWorker.setOnClickListener(imageButtonAddComptableWorkerListener);
        for (ImageButton currentImagButtonUpComptable: colletionImageButtonUpComptable) {
            currentImagButtonUpComptable.setOnClickListener(imageButtonUpComptableWorkerListener);
        }
        for (ImageButton currentImageButtonBack: collectionImageButtonBack) {
            currentImageButtonBack.setOnClickListener(imageButtonBackButtonListener);
        }
        for (ImageButton currentImageButtonHelp : collectionImageButtonHelp) {
            currentImageButtonHelp.setOnClickListener(imageButtonHelpListener);
        }
        progressBarFormation.setOnClickListener(progressBarFormationListener);
        progressBarSecurite.setOnClickListener(progressBarSecuriteListener);
        progressBarReputation.setOnClickListener(progressBarReputationListener);
        progressBarBonheur.setOnClickListener(progressBarBonheurListener);
        imageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener);
        imageButtonHideInformationSousTraiter.setOnClickListener(imageButtonHideInformationSousTraiterListener);
        imageButtonUpConditionTravail.setOnClickListener(imageButtonUpConditionTravailListener);
        for (ImageButton currentImageButtonUpSecuriteInformatique : collectionImageButtonUpSecuriteInformatique) {
            currentImageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener2);
        }
        for (ImageButton currentImageButtonUpBonheur : collectionImageButtonUpBonheur) {
            currentImageButtonUpBonheur.setOnClickListener(imageButtonUpBonheurListener);
        }
        textViewAddRessources.setOnClickListener(textViewAddRessourcesListener);
        ImageViewArgentPremiereRessource.setOnClickListener(imageViewArgentPremiereRessourceListener);
        ImageViewArgentDeuxiemeRessource.setOnClickListener(imageViewArgentDeuxiemeRessourceListener);
        ImageViewArgentTroisiemeRessource.setOnClickListener(imageViewArgentTroisiemeRessourceListener);
    }

    /**
     * Fonction permettant d'incrémenter automatiquement l'argent
     *
     * @author zoua
     */
    private void incrementeArgent() {
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //count++;
                entreprise.setArgent((int)(entreprise.getArgent()+1));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (entreprise.getArgent() <= 10000) {
                            textViewArgent.setText(String.valueOf(entreprise.getArgent()));
                        } else {
                            _t.cancel();
                        }
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
                // augmentation du nombre d'heures passées depuis la derière MAJ du Firewall
                entreprise.setDerniereMAJFirewall(entreprise.getDerniereMAJFirewall() + 1);
                // diminution du taux de sécurité informatique
                entreprise.augmenterTauxSecuInfo(-0.15);
            }
        };

        // planification de la tâche du timer toutes les heures à partir de la première heure
        _tMAJFirewall.schedule (verificationMAJFirewall, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant de mettre à jour le firewall
     */
    private void MAJFirewall() {
            // remise à 0 du nombre d'heures passées depuis la derière MAJ du Firewall
            entreprise.setDerniereMAJFirewall(0);
            // augmentation du taux de sécurité informatique
            entreprise.augmenterTauxSecuInfo(0.30);
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
            }
        };

        // planification de la tâche du timer toutes les heures à partir de la première heure
        _tMAJSysteme.schedule (verificationMAJSysteme, 1000*60*60, 1000*60*60);
    }

    /**
     * Fonction permettant de mettre à jour le système
     */
    private void MAJSysteme() {
        // remise à 0 du nombre d'heures passées depuis la derière MAJ du système
        entreprise.setDerniereMAJSysteme(0);
        // augmentation du taux de sécurité informatique
        entreprise.augmenterTauxSecuInfo(0.30);
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
                // diminution du taux des conditions de travail
                entreprise.augmenterTauxConditTravail(-0.15);
            }
        };

        // planification de la tâche du timer toutes les 4 heures
        _tInterventionMedecineTravail.schedule (verificationInterventionMedecineTravail, 1000*60*60*4, 1000*60*60*4);
    }

    /**
     * Fonction permettant d'actualiser le nombre d'heures depuis la dernière intervention de la médecine du travail
     */
    private void set_tInterventionMedecineTravail() {
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
                // diminution du taux des conditions de travail
                entreprise.augmenterTauxConditTravail(-0.15);
            }
        };

        // planification de la tâche du timer toutes les 2 heures
        _tInterventionMenage.schedule (verificationInterventionMenage, 1000*60*60*2, 1000*60*60*2);
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

    private View.OnClickListener textViewLevelListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le nom du joueur
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            if (!show) {
                textViewNomJoueur.setVisibility(View.VISIBLE);
                show = true;
            } else {
                textViewNomJoueur.setVisibility(View.GONE);
                show = false;
            }
        }
    };


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
                relativeLayoutDetailsCompetences.setVisibility(View.VISIBLE);
                show = true;
            } else {
                relativeLayoutDetailsCompetences.setVisibility(View.GONE);
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
                relativeLayoutDetailsSecuriteInformatique.setVisibility(View.VISIBLE);
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

    private View.OnClickListener imageviewComptableListener = new View.OnClickListener() {

        /**
         * Fonction permettant d'afficher les details sur les comptables
         *
         * @param v: élement de la vue sur lequel on clique
         * @author zoua
         */
        @Override
        public void onClick(View v) {
            relativeLayoutEmployes.setVisibility(View.GONE);
            relativeLayoutDetailCommercial.setVisibility(View.VISIBLE);
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
            layoutParamsMain.addRule(RelativeLayout.BELOW, R.id.RelativeLayoutComptableWorkerThreeLine);
            layoutParamsMain.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutComptableWorkerThreeLine);
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
            layoutParamsSex.addRule(RelativeLayout.ALIGN_START, R.id.ImageViewFemaleIconOne);
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
            layoutParamsSex.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
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
            layoutParamsUp.addRule(RelativeLayout.ALIGN_START, R.id.RelativeLayoutProgressBarOneComptableWorker3_1);
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

    /* ********************************** *
     *            RESSOURCES              *
     * ********************************** */

    /**
     *  Met à jour les deux progressbar et le texte indiquant le nombre de ressources
     */
    private void majGraphRessources() {
        progressBarRessources.setProgress(Ressources.getInstance());
        ProgressBarNiveauRessources.setProgress(Ressources.getInstance());
        TextViewNiveauRessources.setText(String.valueOf(Ressources.getInstance()));
    }

    /**
     * Fonction permettant de décrémenter automatiquement les ressources
     */
    private void decrementeRessources() {
        _t2 = new Timer();
        _t2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Ressources.setInstance(Ressources.getInstance()-1);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (Ressources.getInstance() >= 0) {
                            majGraphRessources();
                        } else {
                            _t2.cancel();
                            gameOver("Vous n'avez plus assez de ressources. L'entreprise a fait faillite !");
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

    private void afficherNoms() {
        Intent intentStart = getIntent();
        if(intentStart != null) {
            textViewNomJoueur.setText(intentStart.getStringExtra(EXTRA_NOM_JOUEUR));
        }
    }
}
