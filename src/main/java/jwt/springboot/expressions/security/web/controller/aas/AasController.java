package jwt.springboot.expressions.security.web.controller.aas;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jwt.springboot.expressions.security.bean.aas.auth.AuthReqBean;
import jwt.springboot.expressions.security.bean.aas.auth.AuthRespBean;
import jwt.springboot.expressions.security.config.security.jwt.JwtTokenUtil;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 5, 2017 8:50:53 PM
 */
@RestController("/")
public class AasController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authManager;


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private String tokenHeader = "Authorization";

	@PostMapping(value = "/auth")
//	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AuthRespBean> createAuthenticationToken(@RequestBody AuthReqBean requestBean,
			HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {

		UsernamePasswordAuthenticationToken tokenAuth = new UsernamePasswordAuthenticationToken(
				requestBean.getUsername(), requestBean.getPassword());

		final Authentication authentication = authManager.authenticate(tokenAuth);
		
		if (!authentication.isAuthenticated()) {
			throw new BadCredentialsException("Unknown username or password");
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(requestBean.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthRespBean(token));
	}


	@GetMapping("/refreshToken")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {

		String token = request.getHeader(tokenHeader).substring(7);
		
		String refreshedToken = jwtTokenUtil.refreshToken(token);
		
		return ResponseEntity.ok(new AuthRespBean(refreshedToken));
	}
}
