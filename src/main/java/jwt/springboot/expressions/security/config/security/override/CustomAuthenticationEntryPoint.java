/**
 * 
 */
package jwt.springboot.expressions.security.config.security.override;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Since our API only 'speaks' REST we give a HTTP 401 if user cannot be authenticated. There is no
 * login page top redirect to
 * 
 * @author Taleh-PC
 * 2017 Nov 8, 2017 11:13:52 PM
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = 3798723588865329956L;

	@Override
	public void commence(HttpServletRequest request,HttpServletResponse response,AuthenticationException authException) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}