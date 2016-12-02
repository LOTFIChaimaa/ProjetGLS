package game;

import java.util.List;

public class Transformation {

    private List<Condition> conditions; // Conditions pour realiser la transformation
    private Objet resultat; 

    public Transformation(List<Condition> conditions, Objet resultat) {
        this.conditions = conditions;
        this.resultat = resultat;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public Objet getResultat() {
        return resultat;
    }

    /** Checks if the transformation can be applied.
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
