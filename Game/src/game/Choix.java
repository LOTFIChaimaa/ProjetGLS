package game;

import java.util.ArrayList;
import java.util.List;

public class Choix {

    private String name; // Le nom du choix
    private List<Action> actions; // Les actions du choix
    private boolean estDebut; // indique si c'est un choix de début
    private boolean estFin; // indique si c'est un choix de fin
    private List<Condition> conditions; // Les conditions du choix

    /** Simple constructor */
    public Choix(String name) {
        this.name = name;
        this.actions = new ArrayList<>();
        this.conditions = new ArrayList<>();
    }

    /** Complete constructor */
    public Choix(String name, List<Action> actions, boolean estDebut, boolean estFin, List<Condition> conditions) {
        this.name = name;
        this.actions = actions;
        this.estDebut = estDebut;
        this.estFin = estFin;
        this.conditions = conditions;
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

    /** Get the actions that are possible
     * @param explorateur explorateur
     * @return the actions possibles
     */
    public List<Action> getPossiblesActions(Explorateur explorateur) {
        List<Action> actionsPossibles=  new ArrayList<>();
        for (Action action : actions) {
            if (action.check(explorateur)) {
                actionsPossibles.add(action);
            }
        }
        return actionsPossibles;
    }

    public String getName() {
        return name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void addAction(Action a) {
        this.actions.add(a);
    }

    public boolean isEstDebut() {
        return estDebut;
    }

    public void setDebut(boolean b) {
        this.estDebut = b;
    }

    public boolean isEstFin() {
        return estFin;
    }

    public void setFin(boolean b) {
        this.estFin = b;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition c) {
        this.conditions.add(c);
    }
}
