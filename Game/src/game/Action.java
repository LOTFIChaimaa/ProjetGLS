package game;

import java.util.List;
import java.util.ArrayList;

public class Action {

    List<Choix> choixNecessaires; // Les choix précédents de l"explorateur dont dépendent l'action
    List<Condition> conditions; // Les conditions de l'action
    List<Transmission> transmissions; // Les transmissions possibles lors de l'action

    /** Simple constructor */
    public Action() {
        this.choixNecessaires = new ArrayList<Choix>();
        this.conditions = new ArrayList<Condition>();
        this.transmissions = new ArrayList<Transmission>();
    }

    /** Complete constructor */
    public Action(List<Choix> choixNecessaires, List<Condition> conditions, List<Transmission> transmissions) {
        this.choixNecessaires = choixNecessaires;
        this.conditions = conditions;
        this.transmissions = transmissions;
    }

    public List<Choix> getChoixNecessaires() {
        return choixNecessaires;
    }

    public void addChoixNecessaire(Choix ch) {
        this.choixNecessaires.add(ch);
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition c) {
        this.conditions.add(c);
    }

    public List<Transmission> getTransmissions() {
        return transmissions;
    }

    public void addTransmission(Transmission t) {
        this.transmissions.add(t);
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
