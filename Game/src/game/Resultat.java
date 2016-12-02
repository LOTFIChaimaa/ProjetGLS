package game;

import java.util.List;

public class Resultat {

    private Objet objet; // L'objet résultat de la transformation
    private List<Condition> conditions;

    public Resultat(Objet objet, List<Condition> conditions) {
        this.objet = objet;
        this.conditions = conditions;
    }

    public Objet getObjet() {
        return objet;
    }

    public List<Condition> getConditions() {
        return conditions;
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
