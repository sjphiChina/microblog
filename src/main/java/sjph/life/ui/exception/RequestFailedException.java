package sjph.life.ui.exception;

/**
 * @author shaohuiguo
 *
 */
public class RequestFailedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8088998331811289905L;

    /**
     * @param message
     * @param t
     */
    public RequestFailedException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * @param message
     * @param t
     */
    public RequestFailedException(String message) {
        super(message);
    }
}
