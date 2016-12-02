package game;

import java.util.List;

public class Explorateur {

    private String name; // Son nom
    private Difficulte difficulte; // La difficulté actuelle
    private int tailleMax; // La taille max de l'inventaire
    private int tailleInventaire; // La taille actuelle de l'inventaire
    private List<Connaissance> connaissances; // Ses connaissances
    private List<Objet> objets; // Ses objets
    private Lieu lieuActuel; // Le lieu actuel du personnage

    public Explorateur(String name, Difficulte difficulte, int tailleMax,
            List<Connaissance> connaissances, List<Objet> objets, Lieu lieuActuel) {
        this.name = name;
        this.difficulte = difficulte;
        this.tailleMax = tailleMax;
        this.tailleInventaire = 0;
        this.connaissances = connaissances;
        this.objets = objets;
        this.lieuActuel = lieuActuel;

        for (Objet o : this.objets) {
            this.tailleInventaire += o.getTaille();
        }

        if (this.tailleInventaire > this.tailleMax) {
            throw new RuntimeException(this.name +
                    " was given too many objects at initialization!");
        }
    }

    /** Initializes the player to the given settings.
     * @param l Lieu
     * @param d Difficulte
     */
    public void init(Lieu l, Difficulte d) throws InventorySpaceError {
        this.lieuActuel = l;
        this.difficulte = d;
        this.connaissances = this.difficulte.getConnaissances();

        // Starting objects
        for (Objet o : this.difficulte.getObjets()) {
            this.ajouterObjet(o);
        }
    }

    public String getName() {
        return name;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public List<Connaissance> getConnaissances() {
        return connaissances;
    }

    public void ajouterConnaissance(Connaissance c) {
        this.connaissances.add(c);
    }

    public List<Objet> getObjets() {
        return objets;
    }

    /** Add an object to the player's inventory.
     * @param o Objet
     * Raises an InventorySpaceError if player's inventory does not have enough
     * space.
     */
    public void ajouterObjet(Objet o) throws InventorySpaceError {
        if (this.tailleInventaire + o.getTaille() > this.tailleMax) {
            throw new InventorySpaceError(this.name +
                " can't acquire " + o.getName() + " : not enough inventory space.");
        } else {
            this.objets.add(o);
            this.tailleInventaire += o.getTaille();
        }
    }

    public void retirerObjet(Objet o) {
        this.objets.remove(o);
        this.tailleInventaire -= o.getTaille();
    }

    public Lieu getLieuActuel() {
        return lieuActuel;
    }

    public void setLieuActuel(Lieu l) {
        this.lieuActuel = l;
    }

    /** Checks if the given condition is fulfilled
     * @param c Condition
     * @return boolean
     * If there is no condition (c == null) then it passes.
     */
    public boolean check(Condition c) {
        // If there is no condiditon then it passes 
        if (c == null) {
            return true;
        }

        // Check that we're on the correct difficulty
        if (this.difficulte.getName() != c.getDifficulte().getName()) {
            return false;
        }

        // Check that the required objects are in inventory
        if (!this.objets.containsAll(c.getObjetsPossedes())) {
            return false;
        }

        // Check that the required objects are not in inventory
        for (Objet o : c.getObjetsManquants()) {
            if (this.objets.contains(o)) {
                return false;
            }
        }

        if (!this.connaissances.containsAll(c.getConnaissancesPossedees())) {
            return false;
        }

        // Check that the required objects are not in inventory
        for (Connaissance o : c.getConnaissancesManquantes()) {
            if (this.connaissances.contains(o)) {
                return false;
            }
        }

        // Test random fail
        if (!c.checkHasard()) {
            return false;
        }

        // If we get to this point then the condition is valid
        return true;
    }
}
