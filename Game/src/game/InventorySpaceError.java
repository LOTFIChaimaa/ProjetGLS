package game;

@SuppressWarnings("serial")

/** For when the player should receive an item but can't because it would
 * surpass their inventory space.
 */
public class InventorySpaceError extends Exception {

    private Objet objet;

    public InventorySpaceError(String message, Objet objet) {
        super(message);
        this.objet = objet;
    }

    /** get the objets which provoke the execption
     * @return the objet
     */
    public Objet getErrorObjet() {
        return objet;
    }
}
