package game;

import java.util.List;

public class Trouvable {

    // l'entite contenue peut etre un Objet, une Connaissance ou une Personne
    private Object entite;
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsActivation;

    /** Check if this discoverable is visible by the player.
    * @param joueur Explorateur
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
    * @param joueur Explorateur
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
}
