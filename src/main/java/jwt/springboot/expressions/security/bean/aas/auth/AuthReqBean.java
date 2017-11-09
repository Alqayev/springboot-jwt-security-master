package jwt.springboot.expressions.security.bean.aas.auth;



/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 6:07:51 PM
 */
public class AuthReqBean {
     
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationReqBean [username=" + username + ", password=" + password + "]";
	}
}
