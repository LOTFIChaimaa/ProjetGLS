package game;

import java.util.List;

public class Personne extends Trouvable {

    private String name; // Le nom de la personne
    private Description description; // La description du personnage
    private Interaction interaction; // L'interraction avec le personnage
    private boolean obligatoire;
    private List<Condition> conditionsObligation;

    /** Simple constructor */
    public Personne(String name) {
        this.name = name;
    }

    /** Complete constructor */
    public Personne(String name, Description description, Interaction interaction, boolean obligatoire) {
        this.name = name;
        this.description = description;
        this.interaction = interaction;
        this.obligatoire = obligatoire;
    }
    public String getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description d) {
        this.description = d;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction i) {
        this.interaction = i;
    }

    public boolean estObligatoire() {
        return this.obligatoire;
    }

    public void setObligatoire(boolean value) {
        this.obligatoire = value;
    }
}
