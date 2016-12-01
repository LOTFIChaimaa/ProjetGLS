package game;

import java.util.List;

public class Connaissance {
	
	private String name; // Le nom de la description
	private List<Description> descriptions; // Toutes les descriptions possibles de la connaissance

	public Connaissance(String name, List<Description> descriptions) {
		this.name = name;
		this.descriptions = descriptions;
	}

	public String getName() {
		return name;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}
}
