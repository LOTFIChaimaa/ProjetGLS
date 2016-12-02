package game;

import java.util.List;
import java.util.Map;

public class Objet extends Trouvable {

    private String name;
    private List<Description> descriptions;
    private List<Transformation> transformations;
    private int taille;
    private boolean deposable;
    private Map<String, List<Condition>> conditionsDeposable;

    /** Basic constructor */
    public Objet(String name, List<Description> descriptions,
            List<Transformation> transformations, int taille) {
        this.name = name;
        this.descriptions = descriptions;
        this.transformations = transformations;
        this.taille = taille;
        this.deposable = false;
    }

    /** Object that can be deposited in at least one location */
    public Objet(String name, List<Description> descriptions, List<Transformation> transformations,
            int taille, Map<String, List<Condition>> cd) {
        this(name, descriptions, transformations, taille);
        this.deposable = true;
        this.conditionsDeposable = cd;
    }

    public String getName() {
        return name;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public List<Transformation> getTransformations() {
        return transformations;
    }

    public int getTaille() {
        return taille;
    }

    /** Attempts to transform the object.
     * @param player Explorateur
     * @return Objet
     * At most one transformation is normally valid at all times, thus the
     * first valid one found is applied. Transformation conditions are checked
     * against the given player.
     * Returns the outcome of the transformation (Objet), returns null if none
     * can be applied.
     */
    public Objet transformer(Explorateur player) {
        // Find a valid transformation
        Transformation validTransfo = null;
        for (Transformation t : this.transformations) {
            if (t.check(player)) {
                validTransfo = t;
                break;
            }
        }

        if (validTransfo == null) {
            return null;
        }
        else {
            return validTransfo.getResultat();
        }
    }

    /** Get the correct description according to the player consulting it.
     * @param player Explorateur
     * @return Description
     */
    public Description getDescription(Explorateur player) {
        for (Description d : this.descriptions) {
            if (d.check(player)) {
                return d;
            }
        }

        throw new DescriptionError(this.name + " has no description for " +
                player.getName());
    }

    /** Checks if the object can be deposited.
     * @param player Explorateur
     * @return boolean
     */
    public boolean estDeposable(Explorateur player) {
        if (this.deposable) {
            for (Condition c :
                    this.conditionsDeposable.get(player.getLieuActuel().getName()))
            {
                if (!player.check(c)) {
                    return false;
                }
            }

            return true;
        }
        else {
            return false;
        }
    }
}
