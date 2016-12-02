package game;

import java.util.List;

public class Choix {

    private String name; // Le nom du choix
    private List<Action> actions; // Les actions du choix
    private boolean estDebut; // indique si c'est un choix de début
    private boolean estFin; // indique si c'est un choix de fin
    private List<Condition> conditions; // Les conditions du choix

    public Choix(String name, List<Action> actions, boolean estDebut, boolean estFin, List<Condition> conditions) {
        this.name = name;
        this.actions = actions;
        this.estDebut = estDebut;
        this.estFin = estFin;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public boolean isEstDebut() {
        return estDebut;
    }

    public boolean isEstFin() {
        return estFin;
    }

    public List<Condition> getConditions() {
        return conditions;
    }
}
