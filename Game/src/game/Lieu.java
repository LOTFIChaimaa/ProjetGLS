package game;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Lieu {

    private String name; // Le nom du lieu
    private List<Description> descriptions;
    // Les objets, personnes ou connaissance trouvables dans le lieu
    private List<Trouvable> trouvables;
    private List<Objet> objets; // Les objets déposés dans le lieu
    private List<Chemin> cheminsPossibles; // Les chemins possibles reliés au lieu
    private List<Chemin> cheminsObligatoires; // Les chemins obligatoires reliés au lieu

    public Lieu(String name, List<Trouvable> trouvables, List<Objet> objets,
            List<Chemin> cheminsPossibles, List<Chemin> cheminsObligatoires) {
        this.name = name;
        this.trouvables = trouvables;
        this.objets = objets;
        this.cheminsPossibles = cheminsPossibles;
        this.cheminsObligatoires = cheminsObligatoires;
    }
    public String getName() {
        return name;
    }
    public List<Trouvable> getTrouvables() {
        return trouvables;
    }
    public List<Objet> getObjets() {
        return objets;
    }
    public List<Chemin> getCheminsPossibles() {
        return cheminsPossibles;
    }
    public List<Chemin> getCheminsObligatoires() {
        return cheminsObligatoires;
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

    /** Get all discoverables that are visible by the player.
    * @param player Explorateur
    * @return List<Trouvable>
    */
    public List<Trouvable> getTrouvablesVisibles(Explorateur player) {
        return this.trouvables.stream()
            .filter(tr -> tr.estVisible(player))
            .collect(Collectors.toList());
    }

    /** Get all discoverables of a class that are visible by the player.
    * @param player Explorateur
    * @return List<Trouvable>
    */
    public List<?> getTrouvablesVisibles(Explorateur player, Class<?> entite) {
        return this.trouvables.stream()
            .filter(tr -> tr.estVisible(player))
            .map(tr -> tr.typeEntite() == entite.getName())
            .collect(Collectors.toList());
    }
}
