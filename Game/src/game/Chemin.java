package game;

import java.util.List;

public class Chemin {
	
	private String name; // Le nom du chemin
	private List<Description> descriptions; // Les descriptions possibles décrivant le chemin
	private Lieu lieu1; // un lieu au bout du chemin
	private Lieu lieu2; // un autre lieu au bout du chemin
	private boolean ouvert; // Indique si le chemin est ouvert
	private boolean visible; // Indique si le chemin est visible
	private List<Condition> conditionsVisibilite; // Les conditions de visibilité du chemin
	private List<Condition> conditionsOuverture; // Les conditions d'ouverture du chemin

}
