package game;

import java.util.List;

public class Objet {
	
	private String name; // Le nom de l'objet
	private List<Description> descriptions; // Les descriptions possibles de l'objets
	private List<Transformation> transformations; // Les transformations possibles de l'objets
	private int taille; // La taille de l'objet
	
	public Objet(String name, List<Description> descriptions, List<Transformation> transformations, int taille) {
		this.name = name;
		this.descriptions = descriptions;
		this.transformations = transformations;
		this.taille = taille;
	}

	public String getName() {
		return name;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public List<Transformation> getTransformations() {
		return transformations;
	}

	public int getTaille() {
		return taille;
	}
	
}
