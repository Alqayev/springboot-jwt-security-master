package jwt.springboot.expressions.security.web.exception;

public class UsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1363312971559580524L;
	
	public UsernameNotFoundException(Long errorCode,String message) {
		super(message);
	}
	
}