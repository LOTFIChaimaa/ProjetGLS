package game;

import java.util.List;

public class Transformation {

	private List<Condition> conditions; // Les conditions qui indique si l'objet est transformable
	private List<Resultat> resultats; // Les objets possibles résultant de la transformation
	
	public Transformation(List<Condition> conditions, List<Resultat> resultats) {
		this.conditions = conditions;
		this.resultats = resultats;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public List<Resultat> getResultats() {
		return resultats;
	}
	
}
