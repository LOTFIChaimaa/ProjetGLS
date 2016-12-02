package game;

import java.util.List;

public class Transmission {

    private List<Objet> objetsTransmis;
    private List<Objet> objetsConsommes;
    private List<Connaissance> connaissances;
    private List<Condition> conditions;

    public Transmission(List<Objet> transmis, List<Objet> consommes,
            List<Connaissance> connaissances, List<Condition> conditions) {
        this.objetsTransmis = transmis;
        this.objetsConsommes = consommes;
        this.connaissances = connaissances;
        this.conditions = conditions;
    }
}
