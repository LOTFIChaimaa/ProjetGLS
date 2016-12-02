package game;

public class Personne extends Trouvable {

    private String name; // Le nom de la personne
    private Description description; // La description du personnage
    private boolean obligatoire; // Indique si la personne est obligatoire
    private Interaction interaction; // L'interraction avec le personnage

    public Personne(String name, Description description, boolean obligatoire, Interaction interaction) {
        this.name = name;
        this.description = description;
        this.obligatoire = obligatoire;
        this.interaction = interaction;
    }
    public String getName() {
        return name;
    }
    public Description getDescription() {
        return description;
    }
    public boolean isObligatoire() {
        return obligatoire;
    }
    public Interaction getInteraction() {
        return interaction;
    }
}
