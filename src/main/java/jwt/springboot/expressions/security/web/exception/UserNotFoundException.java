package jwt.springboot.expressions.security.web.exception;

/**
 * @author Taleh-PC
 * 2017 Nov 4, 2017 12:50:28 AM
 */
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1363312971559580524L;
	
	public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }	
}
