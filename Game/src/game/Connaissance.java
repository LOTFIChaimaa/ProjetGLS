package game;

import java.util.List;

public class Connaissance extends Trouvable {

    private String name; // Le nom de la connaissance
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

    /** Get the correct description according to the player consulting it.
     * @param player Explorateur
     * @return Description
     */
    public Description getDescription(Explorateur player) {
        for (Description d : this.descriptions) {
            if (d.check(player)) {
                return d;
            }
        }

        throw new DescriptionError(this.name + " has no description for " +
                player.getName());
    }
}
