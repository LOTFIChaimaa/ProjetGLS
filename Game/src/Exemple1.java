import game.*;

import java.util.List;
import java.util.ArrayList;

/** Exemple 1: Jeu d'enigme d'un sphinxe. */
public class Exemple1 {

    /** Game exexcution. */
    public static void main(String args[]) {
        String name = "Enigmes";

        // Lieux
        Lieu enigme = new Lieu("Enigme");
        Lieu success = new Lieu("Success");
        Lieu echec = new Lieu("Echec");

        // Chemins
        Chemin cheminEchec = new Chemin("Chemin vers l'Echec");
        Chemin cheminSuccess= new Chemin("Chemin vers le Success");
        List<Chemin> cheminsEnigme;

        // Trouvables
        Personne sphinxe = new Personne("Sphinxe");
        Connaissance reussite = new Connaissance("Reussite");
        List<Trouvable> trouvablesEnigme;
        List<Trouvable> trouvablesSuccess;
        List<Trouvable> trouvablesEchec;

        // Descriptions
        List<Description> descEnigme;
        List<Description> descEchec;
        List<Description> descSuccess;
        List<Description> descCheminEchec;
        List<Description> descCheminSuccess;

        // Conditions
        List<Condition> condCheminEchec;
        List<Condition> condCheminSuccess;

        // Init game world
        // enigme = new Lieu("Enigme", trouvablesEnigme, cheminsEnigme, null);
        // success = new Lieu("Success", trouvablesSuccess, new ArrayList<Chemin>(), null);
        // echec = new Lieu("Echec", trouvablesEchec, new ArrayList<Chemin>(), null);


        cheminEchec = new Chemin("Chemin vers l'Echec", enigme, echec,
                descCheminEchec, condCheminEchec, new ArrayList<Condition>(),
                new ArrayList<Transmission>());
        cheminSuccess = new Chemin("Chemin vers le Success", enigme, echec,
                descCheminSuccess, condCheminSuccess, new ArrayList<Condition>(),
                new ArrayList<Transmission>());

        List<Lieu> lieux = new ArrayList<Lieu>();
        lieux.add(enigme);
        lieux.add(success);
        lieux.add(echec);

        Objet tentative = new Objet("Tentative", null, null, 0);

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
