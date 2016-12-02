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

    /** Checks if the trade can be made.
     * @param player Explorateur
     * @return boolean
     */
    public boolean check(Explorateur player) {
        // Player must have all required objets in inventory
        if (!player.getObjets().containsAll(this.objetsConsommes)) {
            return false;
        }

        // Player must posses all required knowledge
        if (!player.getConnaissances().containsAll(this.connaissances)) {
            return false;
        }

        // Player must meet all conditions
        for (Condition c : this.conditions) {
            if (!player.check(c)) {
                return false;
            }
        }

        return true;
    }

    /** Makes the trade.
     * @param player Explorateur
     * This should only be called if the trade is valid!
     */
    public void transmettre(Explorateur player) throws InventorySpaceError {
        // Remove consumed objects
        for (Objet o : this.objetsConsommes) {
            player.retirerObjet(o);
        }

        // Give player objects
        for (Objet o : this.objetsTransmis) {
            player.ajouterObjet(o);
        }

        // Give player knowledge
        for (Connaissance c : this.connaissances) {
            player.ajouterConnaissance(c);
        }
    }
}
