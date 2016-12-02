package game;

import java.util.List;

public class Deposable {

    private Objet objet;
    private List<Condition> conditions;

    /** Checks if the object can be deposited.
     * @param player Explorateur
     * @return boolean
     */
    public boolean check(Explorateur player) {
        for (Condition c : this.conditions) {
            if (!player.check(c)) {
                return false;
            }
        }

        return true;
    }
}
