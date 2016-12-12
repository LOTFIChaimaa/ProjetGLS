package game;

import java.util.List;

/** Un Trouvable est une entite que le joueur peut trouver dans un Lieu.
 * @author Noah Jay
 */
public abstract class Trouvable {

    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsActivation;

    /** Check if this discoverable is visible by the player.
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

    /** Check if the player can interact with this discoverable.
    * @param player Explorateur
    * @return boolean
    */
    public boolean estActif(Explorateur player) {
        for (Condition c : this.conditionsActivation) {
            if (!player.check(c)) {
                return false;
            }
        }

        return true;
    }

    /** Function for filtering discoverables
    * @return String
    */
    public String typeEntite() {
        return this.getClass().getName();
    }
}
