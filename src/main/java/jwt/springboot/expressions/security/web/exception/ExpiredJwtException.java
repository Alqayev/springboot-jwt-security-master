/**
 * 
 */
package jwt.springboot.expressions.security.web.exception;

/**
 * @author Taleh-PC
 * 2017 Nov 9, 2017 5:17:58 PM
 */
public class ExpiredJwtException extends RuntimeException {
	private static final long serialVersionUID = 1363312971559580524L;

	public ExpiredJwtException() {
		super();
	}
}
