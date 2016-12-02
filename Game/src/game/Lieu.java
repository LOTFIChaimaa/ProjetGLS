package game;

import java.util.List;

public class Lieu {

    private String name; // Le nom du lieu
    private List<Trouvable> trouvables; // Les objets, personnes ou connaissance trouvables dans le lieu
    private List<Deposable> deposables; // Les objets déposés dans le lieu
    private List<Chemin> cheminsPossibles; // Les chemins possibles reliés au lieu
    private List<Chemin> cheminsObligatoires; // Les chemins obligatoires reliés au lieu

    public Lieu(String name, List<Trouvable> trouvables, List<Deposable> deposables, List<Chemin> cheminsPossibles,
            List<Chemin> cheminsObligatoires) {
        this.name = name;
        this.trouvables = trouvables;
        this.deposables = deposables;
        this.cheminsPossibles = cheminsPossibles;
        this.cheminsObligatoires = cheminsObligatoires;
    }
    public String getName() {
        return name;
    }
    public List<Trouvable> getTrouvables() {
        return trouvables;
    }
    public List<Deposable> getDeposables() {
        return deposables;
    }
    public List<Chemin> getCheminsPossibles() {
        return cheminsPossibles;
    }
    public List<Chemin> getCheminsObligatoires() {
        return cheminsObligatoires;
    }


}
