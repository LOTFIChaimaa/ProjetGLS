package prototype;

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
public class Exemple1 extends Jeu {

    private Exemple1(String name, List<Lieu> lieux, List<Chemin> chemins, Explorateur player,
                    List<Difficulte> difficultes, List<Connaissance> connaissances, List<Objet> objets,
                    List<Personne> personnes, Lieu lieuDepart, Lieu lieuArrivee) {
        super(name, lieux, chemins, player, difficultes, connaissances,
                objets, personnes, lieuDepart, lieuArrivee);
    }

    /** Game creation. */
    public static Jeu initExample() {
        /* Variable Declaration */
        String name = "Enigmes";

        // Lieux
        Lieu enigme = new Lieu("Enigme");
        Lieu succes = new Lieu("Succes");
        Lieu echec = new Lieu("Echec");

        // Chemins
        Chemin cheminEchec = new Chemin("CheminVersEchec");
        Chemin cheminSucces = new Chemin("CheminVersSucces");

        // Trouvables
        Personne sphinxe = new Personne("Sphinxe");
        Connaissance reussite = new Connaissance("Reussite");
        Objet tentative = new Objet("Tentative",0);

        // Descriptions
        Description descSphinxe = new Description("Le maitre de l'enigme.");

        Description descTentative = new Description("Donne une tentative à la question du Sphinxe");
        Description descReussite = new Description("Indique que vous avez réussi l'épreuve du Sphinxe");

        Description descCheminVersSucces = new Description("Le chemin vers la réussite !");
        Description descCheminVersEchec = new Description("Le chemin vers la défaite !");

        // Difficulty
        Difficulte difficulte = new Difficulte("standard");

        // Initialisation Sphinx + Interaction
        Interaction interactionSphinxe = new Interaction();

            // Conditions :
            Condition tentativeLeftYes = new Condition();
                tentativeLeftYes.addObjetsPossedes(tentative);
            Condition tentativeLeftNo = new Condition();
                tentativeLeftNo.addObjetsManquants(tentative);
            Condition sucessYes = new Condition();
                sucessYes.addConnaissancesPossedees(reussite);
            Condition sucessNo = new Condition();
                sucessNo.addConnaissancesManquantes(reussite);

            // Transmission :
            Transmission consumeTentative = new Transmission();
                consumeTentative.addCondition(tentativeLeftYes);
                consumeTentative.addObjetConsomme(tentative);
            Transmission giveSucess = new Transmission();
                giveSucess.addConnaissance(reussite);

            // Phase 1 : presentation :
            Choix hello = new Choix("Bonjour étranger, reponds à ma question !");
                hello.addCondition(tentativeLeftYes);
            hello.setDebut(true);
            Action actionHello = new Action("Continuer");
            hello.addAction(actionHello);

            // Phase 2 : the question
            Choix question = new Choix("Devine ce que j'aime le plus au monde.");
                question.addCondition(tentativeLeftYes);
                question.addCondition(sucessNo);
            Action reponse1 = new Action("La purée !"); // NON
                reponse1.addTransmission(consumeTentative);
            Action reponse2 = new Action("Le ski !");  // NON
                reponse2.addTransmission(consumeTentative);
            Action reponse3 = new Action("Les pots de fleurs !"); // OUI
                reponse3.addTransmission(giveSucess);
            question.addAction(reponse1);
            question.addAction(reponse2);
            question.addAction(reponse3);

            // Phase 3 : win or lose
            Choix goodByeWin = new Choix("T'es nul !");
               goodByeWin.addCondition(sucessNo);
               goodByeWin.addCondition(tentativeLeftNo);

            goodByeWin.setFin(true);
            Action dommage = new Action("Dommage...");
            goodByeWin.addAction(dommage);

            Choix goodByeLost = new Choix("Bravo !");
                goodByeLost.addCondition(sucessYes);
            goodByeLost.setFin(true);
            Action merci = new Action("Merci !");
            goodByeLost.addAction(merci);

        interactionSphinxe.addChoix(hello);
        interactionSphinxe.addChoix(question);
        interactionSphinxe.addChoix(goodByeLost);
        interactionSphinxe.addChoix(goodByeWin);


        /* Init game world */
        enigme.addTrouvable(sphinxe);

        cheminEchec.addLieu1(enigme);
        cheminEchec.addLieu2(echec);
        cheminSucces.addLieu1(enigme);
        cheminSucces.addLieu2(succes);

        reussite.addDescription(descReussite);
        tentative.addDescription(descTentative);

        cheminSucces.addDescription(descCheminVersSucces);
        cheminEchec.addDescription(descCheminVersEchec);

        sphinxe.setDescription(descSphinxe);
        sphinxe.setInteraction(interactionSphinxe);

        enigme.addCheminObligatoire(cheminEchec);
        enigme.addCheminObligatoire(cheminSucces);

        List<Lieu> lieux = new ArrayList<Lieu>();
        lieux.add(enigme);
        lieux.add(succes);
        lieux.add(echec);

        List<Chemin> chemins = new ArrayList<Chemin>();
        List<Difficulte> difficultes = new ArrayList<Difficulte>();
        difficultes.add(difficulte);
        List<Connaissance> connaissances = new ArrayList<Connaissance>();
        List<Objet> objets = new ArrayList<Objet>();
        List<Personne> personnes = new ArrayList<Personne>();

        Explorateur player = new Explorateur("Joueur 1", 0);
        player.setLieuActuel(enigme);
        try {
            player.ajouterObjet(tentative);
            player.ajouterObjet(tentative);
            player.ajouterObjet(tentative);
        } catch (InventorySpaceError inventorySpaceError) {
            inventorySpaceError.printStackTrace();
        }



        return new Exemple1(name, lieux, chemins, player, difficultes, connaissances,
                objets, personnes, enigme, succes);
    }
}
