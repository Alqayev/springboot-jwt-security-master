package jwt.springboot.expressions.security.bean.aas.auth;

import jwt.springboot.expressions.security.utilities.bean.Response;


/**
 * @author Alqayev Taleh
 * 2017 Nov 3, 2017 11:00:47 PM
 */
public class AuthRespBean extends Response {
	
	private String token;

	public AuthRespBean(final String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
