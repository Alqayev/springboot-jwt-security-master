package jwt.springboot.expressions.security.web.exception;

/**
 * @author Taleh-PC
 * 2017 Nov 8, 2017 11:04:47 PM
 */
public class UserAlreadyException extends RuntimeException {

	private static final long serialVersionUID = 1363312971559580524L;
	
	public UserAlreadyException(Long errorCode,String message) {
		super(message);
	}
	
}
