package game;

import java.util.List;

public class Transformation {

    private List<Condition> conditions; // Conditions pour realiser la transformation
    private List<Resultat> resultats; // Resultats possibles de la transformation

    public Transformation(List<Condition> conditions, List<Resultat> resultats) {
        this.conditions = conditions;
        this.resultats = resultats;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Resultat> getResultats() {
        return resultats;
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
