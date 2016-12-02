package game;

import java.util.List;

/** Un Trouvable peut etre un Objet, une Connaissance ou une Personne.
 * @author Noah Jay
 */
public class Trouvable {

    private Object entite;
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsActivation;

    public Trouvable(Object entite, List<Condition> cv, List<Condition> ca) {
        assert (entite instanceof Objet) || (entite instanceof Connaissance) ||
                (entite instanceof Personne) :
           "Un trouvable doit etre un Obejt, une Connaissance ou une Personne, pas un "
               + entite.getClass();
    }

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
