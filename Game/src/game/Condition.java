package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Condition {

    private List<Objet> objetsPossedes; // Objets qui faut
    private List<Objet> objetsManquants; // Objets qui faut pas
    private List<Connaissance> connaissancesPossedees;
    private List<Connaissance> connaissancesManquantes;
    private Difficulte difficulte;
    private int hasard;

    public Condition() {
        hasard = 100;
        this.connaissancesManquantes = new ArrayList<>();
        this.connaissancesPossedees = new ArrayList<>();
        this.objetsManquants = new ArrayList<>();
        this.objetsPossedes = new ArrayList<>();
    }

    public List<Objet> getObjetsPossedes() {
        return this.objetsPossedes;
    }

    public void addObjetsPossedes(Objet o) {
        this.objetsPossedes.add(o);
    }

    public List<Objet> getObjetsManquants() {
        return this.objetsManquants;
    }

    public void addObjetsManquants(Objet o) {
        this.objetsManquants.add(o);
    }

    public List<Connaissance> getConnaissancesPossedees() {
        return this.connaissancesPossedees;
    }

    public void addConnaissancesPossedees(Connaissance c) {
        this.connaissancesPossedees.add(c);
    }

    public List<Connaissance> getConnaissancesManquantes() {
        return this.connaissancesManquantes;
    }

    public void addConnaissancesManquantes(Connaissance c) {
        this.connaissancesManquantes.add(c);
    }

    public Difficulte getDifficulte() {
        return this.difficulte;
    }

    public void setDifficulte(Difficulte d) {
        this.difficulte = d;
    }

    public int getHasard() {
        return this.hasard;
    }

    public void setHasard(int h) {
        this.hasard = h;
    }

    /** Checks against the random chance for this condition to fail.
     * @return boolean
     *
     * Return value is true if condition is meant to succeed, false if meant
     * to fail.
     */
    public boolean checkHasard() {
        Random r = new Random();
        if (this.hasard == 100) {
            return true;
        }
        else {
            return (this.hasard > r.nextInt(100));
        }
    }
}
