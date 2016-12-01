package game;

import java.util.List;

public class Trouvable {

    // concerne peut etre un Objet, une Connaissance ou une Personne
    private Object concerne;
    private boolean visible;
    private boolean actif;
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsActivation;

}
