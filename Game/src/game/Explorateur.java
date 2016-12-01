package game;

import java.util.List;

public class Explorateur {
	
	private String name; // Son nom
	private Difficulte difficulte; // La difficulté actuelle
	private int tailleMax; // La taille max de l'inventaire
	private List<Connaissance> connaissances; // Ses connaissances
	private List<Objet> objets; // Ses objets
	private Lieu lieuActuel; // Le lieu actuel du personnage

	public Explorateur(String name, Difficulte difficulte, int tailleMax, List<Connaissance> connaissances,
			List<Objet> objets, Lieu lieuActuel) {
		this.name = name;
		this.difficulte = difficulte;
		this.tailleMax = tailleMax;
		this.connaissances = connaissances;
		this.objets = objets;
		this.lieuActuel = lieuActuel;
	}

	public String getName() {
		return name;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public int getTailleMax() {
		return tailleMax;
	}

	public List<Connaissance> getConnaissances() {
		return connaissances;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public Lieu getLieuActuel() {
		return lieuActuel;
	} 
	
	
	
	

}
