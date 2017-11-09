/**
 * 
 */
package jwt.springboot.expressions.security.web.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Taleh-PC
 * 2017 Nov 9, 2017 12:51:25 PM
 */
public class InvalidHeaderException extends AuthenticationException {

	private static final long serialVersionUID = 1363312971559580524L;

	public InvalidHeaderException(long code , String msg) {
        super(msg);
    }
	
}