package game;

import java.util.List;

public class Resultat {
	
	private Objet objet; // L'objet résultat
	private List<Condition> conditions; // Les conditions définissant l'objet résultant
	
	public Resultat(Objet objet, List<Condition> conditions) {
		this.objet = objet;
		this.conditions = conditions;
	}

	public Objet getObjet() {
		return objet;
	}

	public List<Condition> getConditions() {
		return conditions;
	}
	
}
