package game;

import java.util.List;

/** Classe définissant le jeu
 * Contient la plus part des éléments qui seront contenues dans le jeu
 * 
 */
public class Jeu {
	
	private String name; // Le nom du jeu
	private List<Lieu> lieux; // Tous les lieux du jeu
	private List<Chemin> chemins; // Tous les chemins du lieu
	private Explorateur joueur; // Le joueur
	private List<Difficulte> difficultes; // Toutes les difficultés possibles
	private List<Connaissance> connaissances; // Toutes les connaissances du jeu
	private List<Objet> objets; // Tous les objets du jeu
	private List<Personne>  personnes; // Toutes les personnes du jeu
	private Lieu lieuDepart; // Le lieu de départ
	private Lieu lieuArrivee; // Le lieu d'arrivée
	
	public Jeu(String name, List<Lieu> lieux, List<Chemin> chemins, Explorateur joueur, List<Difficulte> difficultes,
			List<Connaissance> connaissances, List<Objet> objets, List<Personne> personnes, Lieu lieuDepart,
			Lieu lieuArrivee) {
		this.name = name;
		this.lieux = lieux;
		this.chemins = chemins;
		this.joueur = joueur;
		this.difficultes = difficultes;
		this.connaissances = connaissances;
		this.objets = objets;
		this.personnes = personnes;
		this.lieuDepart = lieuDepart;
		this.lieuArrivee = lieuArrivee;
	}

	public String getName() {
		return name;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}

	public List<Chemin> getChemins() {
		return chemins;
	}

	public Explorateur getJoueur() {
		return joueur;
	}

	public List<Difficulte> getDifficultes() {
		return difficultes;
	}

	public List<Connaissance> getConnaissances() {
		return connaissances;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public Lieu getLieuDepart() {
		return lieuDepart;
	}

	public Lieu getLieuArrivee() {
		return lieuArrivee;
	}
	
	
	


	

}
