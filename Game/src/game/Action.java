package game;

import java.util.List;
import java.util.ArrayList;

public class Action {

    private String texte; // Text of the action
    List<Choix> choixNecessaires; // Les choix nécéssaires
    List<Condition> conditions; // Les conditions de l'action pour choisir le choix suivant
    List<Transmission> transmissions; // Les transmissions possibles lors de l'action

    /** Simple constructor */
    public Action(String name) {
        this.texte = name;
        this.choixNecessaires = new ArrayList<Choix>();
        this.conditions = new ArrayList<Condition>();
        this.transmissions = new ArrayList<Transmission>();
    }

    /** Complete constructor */
    public Action(String name, List<Choix> choix, List<Condition> conditions, List<Transmission> transmissions) {
        this.texte = name;
        this.choixNecessaires = choix;
        this.conditions = conditions;
        this.transmissions = transmissions;
    }

    /** Checks if the Choix can be applied.
     * @param explorateur Explorateur
     * @return boolean
     */
    public boolean check(Explorateur explorateur) {
        for(Condition c : this.conditions) {
            if (!explorateur.check(c)) {
                return false;
            }
        }
        return true;
    }

    public String getTexte() { return this.texte; }

    public List<Choix> getChoixSuivant() {
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

    /** Apply an action during an interaction
     * @param explorateur
     */
    public void applyAction(Explorateur explorateur) throws InventorySpaceError{
        Transmission transmission = getTransmission(explorateur);
        if (transmission != null) {
            transmission.transmettre(explorateur);
        }
    }
}
