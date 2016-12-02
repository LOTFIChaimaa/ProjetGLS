package game;

import java.util.List;

public class Description {

    private String texte; // La description
    private List<Condition> conditions; // Les conditions nécessaires pour afficher la description

    public Description(String texte, List<Condition> conditions) {
        this.texte = texte;
        this.conditions = conditions;
    }

    public String getTexte() {
        return texte;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    /** Checks if the description is valid/active for the given player.
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
