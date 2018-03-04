package com.itescia.compagnysimulator;


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
            textViewInformationSousTraiter, textViewInformationAntivirus;

    Typeface typefaceLevel, typefaceRessource, typefaceLvl, typefaceMaj;

    ProgressBar progressBarReputation, progressBarSecurite, progressBarFormation, progressBarBonheur, progressBarRessources;

    RelativeLayout relativeLayoutHomme, relativeLayoutEmployes, relativeLayoutDetailCommercial, relativeLayoutDetailsCompetences, relativeLayoutDetailsSecurite,
            relativeLayoutDetailsSecuriteInformatique, relativeLayoutProgressBarOneComptableWorker1_1, relativeLayoutProgressBarOneComptableWorker1_2,
            relativeLayoutProgressBarOneComptableWorker1_3, relativeLayoutProgressBarOneComptableWorker1_4, relativeLayoutProgressBarOneComptableWorker1_5,
            relativeLayoutProgressBarOneComptableWorker2_1, relativeLayoutProgressBarOneComptableWorker2_2, relativeLayoutProgressBarOneComptableWorker2_3,
            relativeLayoutProgressBarOneComptableWorker2_4, relativeLayoutProgressBarOneComptableWorker2_5, relativeLayoutProgressBarThreeComptableWorker,
            relativeLayoutProgressBarOneComptableWorker3_1, relativeLayoutProgressBarOneComptableWorker3_2, relativeLayoutProgressBarOneComptableWorker3_3,
            relativeLayoutProgressBarOneComptableWorker3_4, relativeLayoutProgressBarOneComptableWorker3_5, relativeLayoutScrollView, relativeLayoutInformationSousTraiter,
            relativeLayoutInformationAntivirus;

    ImageButton imageButtonBackButton, imageButtonBackButtonDetailCommercial, imageButtonBackButtonDetailCompetences, imageButtonBackButtonDetailSecurite, imageButtonBackButtonDetailSecuriteInformatique,  imageviewComptable, imageButtonUpComptableWorker1, imageButtonUpComptableWorker2,
            imageButtonUpComptableWorker3, imageButtonAddComptableWorker, imageButtonUpSecuriteInformatique, imageButtonHelpSousTraiter, imageButtonHideInformationSousTraiter, imageButtonUpAntivirus;

     ArrayList<RelativeLayout> collectionRelativeLAyoutProgressBarComptable;
     ArrayList<ImageButton> colletionImageButtonUpComptable;
     ArrayList<ImageButton> collectionImageButtonBack;
     ArrayList<ImageButton> collectionImageButtonHelp;
     ArrayList<ImageButton> collectionImageButtonUpSecuriteInformatique;

    Timer _t;
    int count = 0;

    final String EXTRA_NOM_JOUEUR = "Nom du joueur";
    final String EXTRA_NOM_ENTREPRISE = "Nom de l'entreprise";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
        bindListener();
        incrementeArgent();
        afficherNoms();
    }

    /**
     * Fonction permettant d'initialiser les éléments du graphique principale
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
        textViewEmployesSecurite = (TextView) findViewById(R.id.TextViewEmployesSecurite);
        textViewConditionTravail = (TextView) findViewById(R.id.TextViewConditionTravail);
        textViewSecuriteInformatique = (TextView) findViewById(R.id.TextViewSecuriteInformatique);
        textViewSecuriteInformatiqueTitle = (TextView) findViewById(R.id.TextViewSecuriteInformatiqueTitle);
        textViewNiveauSecuriteInformatique = (TextView) findViewById(R.id.TextViewNiveauSecuriteInformatique);
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
        textViewNiveauSecuriteInformatique.setTypeface(typefaceLevel);
        textViewAntivirus.setTypeface(typefaceLvl);
        textViewFirewall.setTypeface(typefaceLvl);
        textViewMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewFormationEmployes.setTypeface(typefaceLvl);
        textViewFormationEmployes.setTypeface(typefaceLvl);
        textViewSousTraiter.setTypeface(typefaceLvl);
        textViewDerniereMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewHeureDerniereMiseAJour.setTypeface(typefaceLvl);
        textViewHeureDerniereMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewArgentFirewall.setTypeface(typefaceLvl);
        textViewArgentMiseAJourSysteme.setTypeface(typefaceLvl);
        textViewArgentFormationEmployes.setTypeface(typefaceLvl);
        textViewArgentAntivirus.setTypeface(typefaceLvl);
        textViewDerniereMiseAJour.setTypeface(typefaceLvl);
        textViewArgentSousTraiter.setTypeface(typefaceLvl);
        textViewInformationSousTraiter.setTypeface(typefaceLvl);
        textViewInformationAntivirus.setTypeface(typefaceLvl);
        textViewNomAntivirus.setTypeface(typefaceRessource);
        textViewVersionAntivirus.setTypeface(typefaceRessource);

        //ELEMENTS PROGRESSBAR
        progressBarBonheur = (ProgressBar) findViewById(R.id.ProgressBarBonheur);
        progressBarBonheur.setProgress(30);
        progressBarFormation = (ProgressBar) findViewById(R.id.ProgressBarFormation);
        progressBarFormation.setProgress(30);
        progressBarReputation = (ProgressBar) findViewById(R.id.ProgressBarReputation);
        progressBarReputation.setProgress(30);
        progressBarRessources = (ProgressBar) findViewById(R.id.ProgressBarRessources);
        progressBarRessources.setProgress(30);
        progressBarSecurite = (ProgressBar) findViewById(R.id.ProgressBarSecurite);
        progressBarSecurite.setProgress(30);

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

        collectionImageButtonHelp = new ArrayList<ImageButton>();
        collectionImageButtonHelp.add(imageButtonHelpSousTraiter);

        collectionImageButtonUpSecuriteInformatique = new ArrayList<ImageButton>();
        collectionImageButtonUpSecuriteInformatique.add(imageButtonUpAntivirus);
    }

    /**
     * Fonction permettant d'initialiser les événements liés aux éléments du graphique
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
        imageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener);
        imageButtonHideInformationSousTraiter.setOnClickListener(imageButtonHideInformationSousTraiterListener);
        for (ImageButton currentImageButtonUpSecuriteInformatique : collectionImageButtonUpSecuriteInformatique) {
            currentImageButtonUpSecuriteInformatique.setOnClickListener(imageButtonUpSecuriteInformatiqueListener2);
        }
    }

    /**
     * Fonction permettant d'incrémenter automatiquement l'argent
     */
    private void incrementeArgent() {
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 10000) {
                            textViewArgent.setText(String.valueOf(count));
                        } else {
                            _t.cancel();
                        }
                    }
                });
            }
        }, 500, 500);
    }

    private View.OnClickListener textViewLevelListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le nom du joueur
         *
         * @param v
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
         * @param v
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
         * @param v
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

    private View.OnClickListener imageButtonHideInformationSousTraiterListener = new View.OnClickListener() {
        boolean show = false;
        /**
         * Fonction permettant d'afficher le popup des compétences
         *
         * @param v
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
         * @param v
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
         * @param v
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
         * @param v
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

    private View.OnClickListener imageButtonBackButtonListener = new View.OnClickListener() {
        /**
         * Fonction permettant de revenir en arrière
         *
         * @param v
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
            } else if(ImageButtonBackSelected == imageButtonBackButtonDetailSecuriteInformatique) {
                relativeLayoutDetailsSecuriteInformatique.setVisibility(View.GONE);
                relativeLayoutDetailsSecurite.setVisibility(View.VISIBLE);
            }
        }
    };

    private View.OnClickListener imageButtonHelpListener = new View.OnClickListener() {
        /**
         * Fonction permettant de revenir en arrière
         *
         * @param v
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
         * @param v
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
         * @param v
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
         * @param v
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

    private void afficherNoms() {
        Intent intentStart = getIntent();
        if(intentStart != null) {
            textViewNomJoueur.setText(intentStart.getStringExtra(EXTRA_NOM_JOUEUR));
        }
    }
}
