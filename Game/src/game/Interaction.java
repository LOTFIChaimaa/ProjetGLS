package game;

import java.util.List;

public class Interaction {

    private List<Transmission> transmissions; // Les transmissions possibles de l'intéraction
    private List<Choix> choix; // Tous les choix possibles de l'intéraction

    public Interaction(List<Transmission> transmissions, List<Choix> choix) {
        this.transmissions = transmissions;
        this.choix = choix;
    }

    public List<Transmission> getTransmissions() {
        return transmissions;
    }

    public List<Choix> getChoix() {
        return choix;
    }
}
