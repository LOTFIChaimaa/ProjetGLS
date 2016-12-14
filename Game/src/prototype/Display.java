package prototype;


import game.*;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/** This is a basic display for the prototype.
 * All the informations will be printed in the shell
 */
public class Display {

    private Explorateur explorateur;

    private int nbTab = 0; // The number of indens, when print a line in the shell

    public Display(Explorateur explorateur) {
        this.explorateur = explorateur;
    }

    /** ident a line with nbTab tabulations
     */
    private void indent() {
        for (int i = 0; i < nbTab ; i++) {
            System.out.print('\t');
        }
    }

    /** Print informations about an "objet"
     * @param objet the "objet" to be printed
     */
    public void print(Objet objet) {
        indent();
        System.out.println("Objet " + objet.getName() + " :");
        indent();
        System.out.println("**Description : " + objet.getDescription(explorateur).getTexte());
    }

    /** Print informations about an "connaissance"
     * @param connaissance the "connaissance" to be printed
     */
    public void print(Connaissance connaissance) {
        indent();
        System.out.println("Connaissance " + connaissance.getName() + " :");
        indent();
        System.out.println("**Description : " + connaissance.getDescription(explorateur).getTexte());
    }

    /** Print informations about an "personne"
     * @param personne the "personne" to be printed
     */
    public void print(Personne personne) {
        indent();
        System.out.println("Personne " + personne.getName() + " :");
        indent();
        System.out.println("**Description : " + personne.getDescription().getTexte());
    }

    /** Print informations about an "chemin"
     * @param chemin the "personne" to be printed
     */
    public void print(Chemin chemin) {
        String ouvert = "";
        if ( chemin.estOuvert(explorateur) ) { // Print if the "chemin" is closed
            ouvert = " (Inaccessible)";
        }
        indent();
        System.out.println("Chemin " + chemin.getName() + " :");
        indent();
        System.out.println("**Description : " + chemin.getDescription(explorateur).getTexte() + ouvert);
    }

    /** Print the number of objects and the total size of the inventory
     */
    public void printInventoryStatus() {
        indent();
        System.out.println("Nombre d'objets : " + explorateur.getObjets().size());
        indent();
        System.out.println("**Taille : " + explorateur.getTailleInventaire() + "/" +  explorateur.getTailleMax());
    }

    /** Display all the objets of the player
     */
    public void printObjetPlayer() {
        indent();
        System.out.println("Objets de l'explorateur :");
        nbTab++;
        if (explorateur.getObjets().isEmpty()) {
            indent();
            System.out.println("**Pas d'objet");
        }
        else {
            for (Objet objet : explorateur.getObjets()) {
                print(objet);
            }
        }
        nbTab--;
    }

    /** Display all the connaissance of the player
     */
    public void printConnaissancePlayer() {
        indent();
        System.out.println("Connaissances de l'explorateur :");
        nbTab++;
        if (explorateur.getConnaissances().isEmpty()) {
            indent();
            System.out.println("**Pas de connaissance");
        }
        else {
            for (Connaissance connaissance : explorateur.getConnaissances()) {
                print(connaissance);
            }
        }
        nbTab--;
    }

    /** Display all the "objet" in the current place
     */
    public void printObjetCurrentPlace() {
        List<Objet> objets = (List<Objet>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur, Objet.class);
        indent();
        System.out.println("Objets dans le lieu " + explorateur.getLieuActuel().getName() + " :");
        nbTab++;
        if (objets.isEmpty()) {
            indent();
            System.out.println("**Pas d'objet ici");
        }
        else {
            for (Objet objet : objets) {
                print(objet);
            }
        }
        nbTab--;
    }

    /** Display all the "connaissance" in the current place
     */
    public void printConnaissanceCurrentPlace() {
        List<Connaissance> connaissances = (List<Connaissance>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur, Connaissance.class);
        indent();
        System.out.println("Connaissances dans le lieu " + explorateur.getLieuActuel().getName() + " :");
        nbTab++;
        if (connaissances.isEmpty()) {
            indent();
            System.out.println("**Pas de connaissance ici");
        }
        else {
            for (Connaissance connaissance : connaissances) {
                print(connaissance);
            }
        }
        nbTab--;
    }

    /** Display all the "personne" in the current place
     */
    public void printPersonneCurrentPlace() {
        List<Personne> personnes = (List<Personne>) explorateur.getLieuActuel().getTrouvablesVisibles(explorateur, Personne.class);
        indent();
        System.out.println("Personnes dans le lieu " + explorateur.getLieuActuel().getName() + " :");
        nbTab++;
        if (personnes.isEmpty()) {
            indent();
            System.out.println("**Pas de gens ici");
        }
        else {
            for (Personne personne : personnes) {
                print(personne);
            }
        }
        nbTab--;
    }


    /** Display all the "chemin" accessible from the current place
     */
    public void printCheminCurrentPlace() {
        List<Chemin> chemins = explorateur.getLieuActuel().getCheminsPossibles()
                .stream()
                .filter(chemin -> chemin.estVisible(explorateur))
                .collect(Collectors.toList());
        indent();
        System.out.println("Chemins " + explorateur.getLieuActuel().getName() + " :");
        // Print the "chemins" visibles
        nbTab++;
        if (chemins.isEmpty()) {
            indent();
            System.out.println("**Pas de gens ici");
        }
        else {
            for (Chemin chemin : chemins) {
                print(chemin);
            }
        }
        nbTab--;
    }

    /** Display informations with details of an objet
     * @param objet objet
     */
    public void printDetail(Objet objet) {
        print(objet);
        indent();
        if (objet.estDeposable(explorateur)) {
            System.out.println("**Peut être déposé");
        } else {
            System.out.println("**Ne peut pas être déposé");
        }
        indent();
        if (objet.transformer(explorateur) != null) {
            nbTab++;
            System.out.println("**Peut se transformer en :");
            print(objet.transformer(explorateur));
            nbTab--;
        }
    }

    /** Display informations with details of a connaissance.
     * p.s. : it is the same description that print (no more detail)
     * @param connaissance connaissance
     */
    public void printDetail(Connaissance connaissance) {
        print(connaissance);
    }

    /** Display informations with details of a personne
     * @param personne personne
     */
    public void printDetail(Personne personne) {
        print(personne);
        indent();
        if (personne.estObligatoire()) {
            System.out.println("** Personne obligatoire !");
        }
        else {
            System.out.println("** Personne non obligatoire");
        }
    }

    /** Display informations with details of a chemin.
     * This path must be related to the current place of the player !
     * @param chemin personne
     */
    public void printDetail(Chemin chemin) {
        print(chemin);
        indent();
        // We check if the place at the end of the path is the current place of the player :
        if (chemin.getLieu1().getName().equals( explorateur.getLieuActuel().getName() )) {
            System.out.println("**Va de " + chemin.getLieu1().getName() + " vers " + chemin.getLieu2().getName());
        }
        else {
            System.out.println("**Va de " + chemin.getLieu2().getName() + " vers " + chemin.getLieu1().getName());
        }
    }

    /** Display the actions of a choix
     * @param choix choix
     */
    public void printListAction(Choix choix) {
        List<Action> actions = choix.getPossiblesActions(explorateur);
        indent();
        System.out.println(choix.getName());
        nbTab++;
        for (int i=0; i<actions.size(); i++) {
            indent();
            System.out.println("("+String.valueOf(i+1)+") " + actions.get(i).getTexte());
        }
        nbTab--;
    }

}



