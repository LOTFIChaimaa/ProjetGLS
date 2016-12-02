package game;

import java.util.List;

public class Chemin {

    private String name; // Le nom du chemin
    private List<Description> descriptions; // Les descriptions possibles décrivant le chemin
    private Lieu lieu1; // un des lieux relies par le chemin
    private Lieu lieu2; // l'autre lieu relie par le chemin
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsOuverture;
    private List<Transmission> transmissions;

    public Chemin(String name, Lieu l1, Lieu l2, List<Description> d,
            List<Condition> cv, List<Condition> co, List<Transmission> t) {
        this.name = name;
        this.lieu1 = l1;
        this.lieu2 = l2;
        this.conditionsVisibilite = cv;
        this.conditionsOuverture = co;
        this.transmissions = t;
    }

    /** Checks if the path is visible.
     * @param player Explorateur
     * @return boolean
     */
    public boolean estVisible(Explorateur player) {
        for (Condition c : this.conditionsVisibilite) {
            if (!player.check(c)) {
                return false;
            }
        }

        return true;
    }

    /** Checks if the path is open.
     * @param player Explorateur
     * @return boolean
     */
    public boolean estOuvert(Explorateur player) {
        for (Condition c : this.conditionsOuverture) {
            if (!player.check(c)) {
                return false;
            }
        }

        return true;
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

    /** Get the valid trade (Transmission) for the player.
     * @param player Explorateur
     * @return Transmission
     *
     * Returns null if no trade is valid.
     */
    public Transmission getTransmission(Explorateur player) {
        for (Transmission t : this.transmissions) {
            if (t.check(player)) {
                return t;
            }
        }

        return null;
    }
}
