import game.*;

import game.Jeu;
import game.Difficulte;
import game.Explorateur;
import game.Lieu;
import game.Chemin;
import game.Objet;
import game.Connaissance;
import game.Personne;
import game.Description;
import game.Interaction;
import game.Choix;
import game.Action;

import java.util.List;
import java.util.ArrayList;

/** Exemple 1: Jeu d'enigme d'un sphinxe. */
public class Exemple1 {

    /** Game exexcution. */
    public static void main(String args[]) {
        /* Variable Declaration */
        String name = "Enigmes";

        // Lieux
        Lieu enigme = new Lieu("Enigme");
        Lieu succes = new Lieu("Succes");
        Lieu echec = new Lieu("Echec");

        // Chemins
        Chemin cheminEchec = new Chemin("Chemin vers l'Echec");
        Chemin cheminSucces= new Chemin("Chemin vers le Succes");

        // Trouvables
        Personne sphinxe = new Personne("Sphinxe");
        Connaissance reussite = new Connaissance("Reussite");
        Objet tentative = new Objet("Tentative");

        // Descriptions
        Description descSphinxe = new Description("Le Sphinxe vous demande:\n"
                + "Qui se deplace sur 4 jambes le matin, 2 jambes a midi et 3"
                + "jambes le soir?");

        // Interactions
        Interaction interactionSphinxe = new Interaction();

        // Transmissions
        Transmission transmissionReussite = new Transmission();

        // Choix
        Choix reponseJoueur = new Choix("Reponse a la question du sphinxe");

        // Actions
        Action bonneReponse = new Action();
        Action mauvaiseReponse = new Action();

        // Conditions
        Condition conditionVisiCheminEchec = new Condition();
        Condition conditionVisiCheminSucces = new Condition();

        /* Init game world */
        cheminEchec.addLieu1(enigme);
        cheminEchec.addLieu2(echec);
        cheminSucces.addLieu1(enigme);
        cheminSucces.addLieu2(succes);

        enigme.addCheminObligatoire(cheminEchec);
        enigme.addCheminObligatoire(cheminSucces);

        List<Lieu> lieux = new ArrayList<Lieu>();
        lieux.add(enigme);
        lieux.add(succes);
        lieux.add(echec);

        List<Chemin> chemins = new ArrayList<Chemin>();
        List<Difficulte> difficultes = new ArrayList<Difficulte>();
        List<Connaissance> connaissances = new ArrayList<Connaissance>();
        List<Objet> objets = new ArrayList<Objet>();
        List<Personne> personnes = new ArrayList<Personne>();

        Lieu lieuDepart = enigme;
        Lieu lieuArrivee = null;

        Explorateur player = new Explorateur("Joueur 1", 0, null, null);

        Jeu jeu = new Jeu(name, lieux, chemins, player, difficultes, connaissances,
                objets, personnes, lieuDepart, lieuArrivee);

        jeu.initJoueur(null);

        // Main loop
        jeu.jouer();
    }
}
