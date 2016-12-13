package game;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Lieu {

    private String name; // Le nom du lieu
    private List<Description> descriptions;
    // Les objets, personnes ou connaissance trouvables dans le lieu
    private List<Trouvable> trouvables;
    private List<Chemin> cheminsPossibles; // Les chemins possibles reliés au lieu
    private List<Chemin> cheminsObligatoires; // Les chemins obligatoires reliés au lieu

    /** Simple constructor. */
    public Lieu(String name) {
        this.name = name;
        this.cheminsObligatoires = new ArrayList<>();
        this.cheminsPossibles = new ArrayList<>();
        this.trouvables = new ArrayList<>();
    }

    /** Complete constructor. */
    public Lieu(String name, List<Trouvable> trouvables, List<Chemin> cheminsPossibles,
            List<Chemin> cheminsObligatoires) {
        this.name = name;
        this.trouvables = trouvables;
        this.cheminsPossibles = cheminsPossibles;
        this.cheminsObligatoires = cheminsObligatoires;
    }

    public String getName() {
        return name;
    }

    public List<Trouvable> getTrouvables() {
        return trouvables;
    }

    public void addTrouvable(Trouvable t) {
        this.trouvables.add(t);
    }

    public List<Chemin> getCheminsPossibles() {
        return cheminsPossibles;
    }

    public void addCheminPossible(Chemin ch) {
        this.cheminsPossibles.add(ch);
    }

    /** Adds a mandatory path.
     * @param ch Chemin
     *
     * Path is also registered in cheminsPossibles if not already.
     */
    public void addCheminObligatoire(Chemin ch) {
        this.cheminsObligatoires.add(ch);
    
        // Add to cheminsPossibles if not already in
        if (!this.cheminsPossibles.contains(ch)) {
            this.cheminsPossibles.add(ch);
        }
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

    public void addDescription(Description d) {
        this.descriptions.add(d);
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
            .filter(tr -> tr.estVisible(player) && entite.isInstance(tr))
                .collect(Collectors.toList());

    }

    /** Take an objet in the place
     * @param objet objet to take
     */
    public void prendreObjet(Objet objet) {
        trouvables.remove(objet);
    }
}
