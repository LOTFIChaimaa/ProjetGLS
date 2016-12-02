package game;

@SuppressWarnings("serial")

/** For when no description is valid.
 * This is a RuntimeException because it should never happen!
 */
public class DescriptionError extends RuntimeException {
    public DescriptionError(String message) {
        super(message);
    }
}
