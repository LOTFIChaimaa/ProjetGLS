package game;

import java.util.List;

public class Objet {

    private String name;
    private List<Description> descriptions;
    private List<Transformation> transformations;
    private int taille;

    public Objet(String name, List<Description> descriptions,
            List<Transformation> transformations, int taille) {
        this.name = name;
        this.descriptions = descriptions;
        this.transformations = transformations;
        this.taille = taille;
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
        // Find a valid result of that transformation
        else {
            Resultat validResult = null;
            for (Resultat r : validTransfo.getResultats()) {
                if (r.check(player)) {
                    validResult = r;
                    break;
                }
            }

            if (validResult == null) {
                return null;
            }
            else {
                return validResult.getObjet();
            }
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
}
