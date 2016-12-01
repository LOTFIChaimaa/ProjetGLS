package game;

import java.util.List;
import java.util.Random;

public class Condition {

    private List<Objet> objetsPossedes;
    private List<Objet> objetsManquants;
    private List<Connaissance> connaissancesPossedees;
    private List<Connaissance> connaissancesManquantes;
    private Difficulte difficulte;
    private int hasard;

    public List<Objet> getObjetsPossedes() {
        return this.objetsPossedes;
    }

    public void setObjetsPossedes(List<Objet> o) {
        this.objetsPossedes = o;
    }

    public List<Objet> getObjetsManquants() {
        return this.objetsManquants;
    }

    public void setObjetsManquants(List<Objet> o) {
        this.objetsManquants = o;
    }

    public List<Connaissance> getConnaissancesPossedees() {
        return this.connaissancesPossedees;
    }

    public void setConnaissancesPossedees(List<Connaissance> c) {
        this.connaissancesPossedees = c;
    }

    public List<Connaissance> getConnaissancesManquantes() {
        return this.connaissancesManquantes;
    }

    public void setConnaissancesManquantes(List<Connaissance> c) {
        this.connaissancesManquantes = c;
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
