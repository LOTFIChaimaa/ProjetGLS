package game;

import java.util.List;

public class Chemin {
	
	private String name; // Le nom du chemin
	private List<Description> descriptions; // Les descriptions possibles décrivant le chemin
	private Lieu lieu1; // un des lieux relies par le chemin
	private Lieu lieu2; // l'autre lieu relie par le chemin
	private boolean ouvert; // Indique si le chemin est ouvert
	private boolean visible; // Indique si le chemin est visible
	private List<Condition> conditionsVisibilite;
	private List<Condition> conditionsOuverture;

}
