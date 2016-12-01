package game;

import java.util.List;

public class Chemin {

    private String name; // Le nom du chemin
    private List<Description> descriptions; // Les descriptions possibles décrivant le chemin
    private Lieu lieu1; // un des lieux relies par le chemin
    private Lieu lieu2; // l'autre lieu relie par le chemin
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsOuverture;

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
}
