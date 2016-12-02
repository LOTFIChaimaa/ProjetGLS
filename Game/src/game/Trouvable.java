package game;

import java.util.List;

public class Trouvable {

    // l'entite contenue peut etre un Objet, une Connaissance ou une Personne
    private Object entite;
    private boolean visible;
    private boolean actif;
    private List<Condition> conditionsVisibilite;
    private List<Condition> conditionsActivation;

}
