package game;

import java.util.ArrayList;
import java.util.List;

public class Interaction {

    private List<Transmission> transmissions; // Les transmissions possibles de l'intéraction
    private List<Choix> choix; // Tous les choix possibles de l'intéraction

    /** Simple constructor */
    public Interaction() {
        this.transmissions = new ArrayList<>();
        this.choix = new ArrayList<>();
    }

    /** Complete constructor */
    public Interaction(List<Transmission> transmissions, List<Choix> choix) {
        this.transmissions = transmissions;
        this.choix = choix;
    }

    /** get the next choix of the interraction
     * @param explorateur explorateur
     * @return choix choix
     */
    public Choix getPossibleChoix(Explorateur explorateur) {
        for (Choix c : choix) {
            if (c.check(explorateur) && !c.isEstDebut()) {
                return c;
            }
        }
        return null;
    }

    /** get the first choix of the interaction
     * @param explorateur explorateur
     * @return choix choix
     */
    public Choix getFirstChoix(Explorateur explorateur) {
        for (Choix c : choix) {
            if (c.check(explorateur) && c.isEstDebut()) {
                return c;
            }
        }
        return null;
    }

    public List<Transmission> getTransmissions() {
        return transmissions;
    }

    public void addTransmission(Transmission t) {
        this.transmissions.add(t);
    }

    public List<Choix> getChoix() {
        return choix;
    }

    public void addChoix(Choix cx) {
        this.choix.add(cx);
    }

    /** Get the valid trade (Transmission) for the player.
     * @param player Explorateur
     * @return Transmission
     *
     * Returns null if no trade is valid.
     */
    public Transmission getTransmission(Explorateur player) {
        for (Transmission t : this.transmissions) {
            if (t.check(player)) {
                return t;
            }
        }

        return null;
    }
}
