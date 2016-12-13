package prototype;

/**
 * Created by tfaget on 12/12/16.
 */

import game.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/** Can interpret a GameCommand typed by the player
 *
 * PROTOCOL :
 *
 * GLOBAL DISPLAY :
 * afficher joueur objets/connaissances/inventaires
 * afficher joueur detail objet <nom objet> (type String)
 * afficher joueur detail objet <nom connaissance>
 * afficher lieu objets/connaissances/personnes/chemins
 * afficher lieu detail objet <nom objet>
 * afficher lieu detail connaissance <nom connaissance>
 * afficher lieu detail personne <nom personne>
 * afficher lieu detail chemin <nom chemin>
 *
 * GLOBAL ACTION :
 * prendre <nom objet>
 * deposer <nom objet>
 * utiliser <nom chemin>
 *
 * INTERACTION WITH A PERSON :
 * interagir <nom personne>
 */
public class CommandInterpreter {

    private Display display;
    private Explorateur explorateur;

    public CommandInterpreter(Display display, Explorateur explorateur) {
        this.display = display;
        this.explorateur = explorateur;
    }

    public void interpret(GameCommand command) {
        try {
            switch (command.getWord(0)) {
                ////////////// DISPLAY /////////////////
                case "afficher":
                    switch (command.getWord(1)) {
                        ////// DISPLAY PLAYER /////
                        case "joueur":
                            switch (command.getWord(2)) {
                                case "objets":
                                    display.printObjetPlayer();
                                    break;
                                case "connaissances":
                                    display.printConnaissancePlayer();
                                    break;
                                case "inventaire":
                                    display.printInventoryStatus();
                                    break;
                                ////// DISPLAY PLAYER DETAILS /////
                                case "detail":
                                    switch (command.getWord(3)) {
                                        case "objet":
                                            Optional<Objet> objet = findPlayerObjet(command.getWord(4));
                                            if (!objet.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans l'inventaire!");
                                            } else {
                                                display.printDetail(objet.get());
                                            }
                                            break;
                                        case "connaissance":
                                            Optional<Connaissance> connaissance = findPlayerConnaissance(command.getWord(4));
                                            if (!connaissance.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans l'inventaire!");
                                            } else {
                                                display.printDetail(connaissance.get());
                                            }
                                            break;
                                        default:
                                            System.out.println("Erreur de syntaxe !");
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Erreur de syntaxe !");
                            }
                            break;
                        ////// DISPLAY PLACE ////////
                        case "lieu":
                            switch (command.getWord(2)) {
                                case "objets":
                                    display.printObjetCurrentPlace();
                                    break;
                                case "connaissances":
                                    display.printConnaissanceCurrentPlace();
                                    break;
                                case "personnes":
                                    display.printPersonneCurrentPlace();
                                    break;
                                case "chemins":
                                    display.printCheminCurrentPlace();
                                    break;
                                ////// DISPLAY PLACE DETAILS /////
                                case "detail":
                                    switch (command.getWord(3)) {
                                        case "objet":
                                            Optional<Objet> objet = findCurrentPlaceObjet(command.getWord(4));
                                            if (!objet.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans le lieu!");
                                            } else {
                                                display.printDetail(objet.get());
                                            }
                                            break;
                                        case "connaissance":
                                            Optional<Connaissance> connaissance = findCurrentPlaceConnaissance(command.getWord(4));
                                            if (!connaissance.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans le lieu!");
                                            } else {
                                                display.printDetail(connaissance.get());
                                            }
                                            break;
                                        case "personne":
                                            Optional<Personne> personne = findCurrentPlacePersonne(command.getWord(4));
                                            if (!personne.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans le lieu!");
                                            } else {
                                                display.printDetail(personne.get());
                                            }
                                            break;
                                        case "chemin":
                                            Optional<Chemin> chemin = findCurrentPlaceChemin(command.getWord(4));
                                            if (!chemin.isPresent()) {
                                                System.out.println("'" + command.getWord(4) + "' n'est pas présent dans le lieu!");
                                            } else {
                                                display.printDetail(chemin.get());
                                            }
                                            break;
                                        default:
                                            System.out.println("Erreur de syntaxe !");
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Erreur de syntaxe !");
                            }
                            break;
                        default:
                            System.out.println("Erreur de syntaxe !");
                    }
                    break;
                ////////////// ACTION /////////////////
                case "prendre":
                    Optional<Objet> objetPre = findCurrentPlaceObjet(command.getWord(1));
                    try {
                        if (!objetPre.isPresent()) {
                            System.out.println("'" + command.getWord(1) + "' n'est pas présent dans le lieu!");
                        }
                            else {
                                explorateur.getLieuActuel().prendreObjet(objetPre.get());
                                explorateur.ajouterObjet(objetPre.get());
                            }
                    } catch (InventorySpaceError e) {
                        System.out.println("Impossible ! L'inventaire est plein !");
                    }
                    break;
                case "deposer":
                    Optional<Objet> objetDep = findPlayerObjet(command.getWord(1));
                    if (!objetDep.isPresent()) {
                        System.out.println("'" + command.getWord(1) + "' n'est pas présent dans le lieu!");
                    }
                    else if (!objetDep.get().estDeposable(explorateur)) {
                        System.out.println("L'objet n'est pas déposable !");
                    }
                    else {
                        explorateur.retirerObjet(objetDep.get());
                        explorateur.getLieuActuel().addTrouvable(objetDep.get());
                    }
                    break;
                case "utiliser":
                    Optional<Chemin> chemin = findCurrentPlaceChemin(command.getWord(1));
                    if (!chemin.isPresent()) {
                        System.out.println("'" + command.getWord(1) + "' n'est pas présent dans le lieu!");
                    }
                    else {
                        // We process to the transmission :
                        Transmission transmission = chemin.get().getTransmission(explorateur);
                        if (transmission.check(explorateur)) {
                            try {
                                transmission.transmettre(explorateur);
                            } catch (InventorySpaceError e) {
                                System.out.println("Impossible de transferer l'objet" + e.getErrorObjet() + "L'inventaire est plein !");
                            }
                        }
                        // We set the correct place for the player (i.e. the correct end of the path) :
                        if (chemin.get().getLieu1().getName().equals( explorateur.getLieuActuel().getName() )) {
                            explorateur.setLieuActuel( chemin.get().getLieu2() );
                        }
                        else {
                            explorateur.setLieuActuel( chemin.get().getLieu1() );
                        }
                    }
                    break;
                ////////////// INTERACTION //////////////
                case "interagir":
                    Optional<Personne> personne = findCurrentPlacePersonne(command.getWord(1));
                    if (!personne.isPresent()) {
                        System.out.println("'" + command.getWord(1) + "' n'est pas présent dans le lieu!");
                    }
                    else {
                        interactWith(personne.get());
                    }
                    break;
                /////////// HELP ///////////////
                case "help":
                     System.out.println ("* GLOBAL DISPLAY : \n" +
                             "* afficher joueur objets/connaissances/inventaires \n" +
                             "* afficher joueur detail objet <nom objet> (type String) \n" +
                             "* afficher joueur detail objet <nom connaissance>\n" +
                             "* afficher lieu objets/connaissances/personnes/chemins\n" +
                             "* afficher lieu detail objet <nom objet>\n" +
                             "* afficher lieu detail connaissance <nom connaissance>\n" +
                             "* afficher lieu detail personne <nom personne>\n" +
                             "* afficher lieu detail chemin <nom chemin>\n" +
                             "*\n" +
                             "* GLOBAL ACTION :\n" +
                             "* prendre <nom objet>\n" +
                             "* deposer <nom objet>\n" +
                             "* utiliser <nom chemin>\n" +
                             "*\n" +
                             "* INTERACTION WITH A PERSON :\n" +
                             "* interagir <nom personne>");
                    break;
                default:
                    System.out.println("Erreur de syntaxe !");
            }
        } catch ( IndexOutOfBoundsException e) { // To prevent index out of bounds
            System.out.println("Erreur de syntaxe !");
        }
    }

    /** Find an objet in the inventory of the player
     *
     * @param name name of the objet
     * @return the objet
     */
    private Optional<Objet> findPlayerObjet(String name) {
        return explorateur.getObjets()
                .stream()
                .filter(objet -> objet.getName().equals(name))
                .findFirst();
    }

    /** Find an connaissance in the inventory of the player
     *
     * @param name name of the connaissance
     * @return the connaissance
     */
    private Optional<Connaissance> findPlayerConnaissance(String name) {
        return explorateur.getConnaissances()
                .stream()
                .filter(connaissance -> connaissance.getName().equals(name))
                .findFirst();
    }

    /** Find an objet in the current place of the player
     *
     * @param name name of the objet
     * @return the objet
     */
    private Optional<Objet> findCurrentPlaceObjet(String name) {
        return ((List<Objet>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur,Objet.class) )
                .stream()
                .filter(objet -> objet.getName().equals(name))
                .findFirst();
    }

    /** Find a connaissance in the current place of the player
     *
     * @param name name of the connaissance
     * @return the conaissance
     */
    private Optional<Connaissance> findCurrentPlaceConnaissance(String name) {
        return ((List<Connaissance>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur,Connaissance.class) )
                .stream()
                .filter(connaissance -> connaissance.getName().equals(name))
                .findFirst();
    }

    /** Find a personne in the current place of the player
     *
     * @param name name of the personne
     * @return the personne
     */
    private Optional<Personne> findCurrentPlacePersonne(String name) {
        return ((List<Personne>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur,Personne.class) )
                .stream()
                .filter(personne -> personne.getName().equals(name))
                .findFirst();
    }

    /** Find a chemin in the current place of the player
     *
     * @param name name of the chemin
     * @return the chemin
     */
    private Optional<Chemin> findCurrentPlaceChemin(String name) {
        return  explorateur.getLieuActuel().getCheminsPossibles().stream()
                .filter(chemin -> chemin.getName().equals(name) && chemin.estVisible(explorateur) )
                .findFirst();
    }

    /** Handle the interraction with a person
     * @param personne personne
     */
    private void interactWith(Personne personne) {
        Scanner scanner = new Scanner(System.in);

        Interaction interaction = personne.getInteraction();
        System.out.println("Vous parlez à " + personne.getName() +" :");
        Choix choix = interaction.getFirstChoix(explorateur); // get the first choix of the interaction
        while (!choix.isEstFin()) {
            Boolean isActionFound = false;
            display.printListAction(choix); // display the list of choix
            while (!isActionFound) { // Read the player action
                try {
                    int numAction = Integer.parseInt( scanner.nextLine() );
                    Action action = choix.getPossiblesActions(explorateur).get(numAction-1);
                    action.applyAction(explorateur);
                    isActionFound = true;
                }
                catch (Exception e) {
                    System.out.println("Choix invalide !");
                }
            }
            choix = interaction.getPossibleChoix(explorateur);
        }
        System.out.println("Vous avez quitté l'interaction avec " + personne.getName() + " !");
    }

}
