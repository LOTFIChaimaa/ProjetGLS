package game;

@SuppressWarnings("serial")

/** For when the player should receive an item but can't because it would
 * surpass their inventory space.
 */
public class InventorySpaceError extends Exception {
    public InventorySpaceError(String message) {
        super(message);
    }
}
