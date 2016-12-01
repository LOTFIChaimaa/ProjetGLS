package game;

import java.util.List;

public class Difficulte {
	
	private String name; // La description
	private List<Connaissance> connaissances; // Les connaissances de départ
	private List<Objet> objets; // Les objets de départ

	public Difficulte(String name, List<Connaissance> connaissances, List<Objet> objets) {
		this.name = name;
		this.connaissances = connaissances;
		this.objets = objets;
	}
	
	public String getName() {
		return name;
	}
	public List<Connaissance> getConnaissances() {
		return connaissances;
	}
	public List<Objet> getObjets() {
		return objets;
	}
	
	

}
