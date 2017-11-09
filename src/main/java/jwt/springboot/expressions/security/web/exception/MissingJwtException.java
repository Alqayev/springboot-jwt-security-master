package jwt.springboot.expressions.security.web.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Taleh-PC
 * 2017 Nov 8, 2017 11:00:21 PM
 */
public class MissingJwtException extends AuthenticationException {

	private static final long serialVersionUID = 1363312971559580524L;

	public MissingJwtException(String msg) {
        super(msg);
    }
	
}
