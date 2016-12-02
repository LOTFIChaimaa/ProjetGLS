package game;

import java.util.List;

public class Action {

    List<Choix> choixNecessaires; // Les choix précédents de l"explorateur dont dépendent l'action
    List<Condition> conditions; // Les conditions de l'action
    List<Transmission> transmissions; // Les transmissions possibles lors de l'action

    public Action(List<Choix> choixNecessaires, List<Condition> conditions, List<Transmission> transmissions) {
        this.choixNecessaires = choixNecessaires;
        this.conditions = conditions;
        this.transmissions = transmissions;
    }

    public List<Choix> getChoixNecessaires() {
        return choixNecessaires;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Transmission> getTransmissions() {
        return transmissions;
    }
}
