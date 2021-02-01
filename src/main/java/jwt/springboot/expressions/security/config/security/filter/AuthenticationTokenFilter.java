package jwt.springboot.expressions.security.config.security.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jwt.springboot.expressions.security.config.security.jwt.JwtTokenUtil;
import jwt.springboot.expressions.security.utilities.bean.Response;
import jwt.springboot.expressions.security.utilities.enums.ErrorHandl;
import jwt.springboot.expressions.security.web.exception.IllegalArgumentInJwtException;
import jwt.springboot.expressions.security.web.exception.InvalidHeaderException;




/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 5:44:32 PM
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private Response response;
	
	@Autowired
	private ObjectMapper mapper;

	private final String tokenHeader = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		final String requestHeader = request.getHeader(this.tokenHeader);

		String username = null;
		String authToken = null;
		
		 try {
			 if ((requestHeader != null && requestHeader.startsWith("Bearer "))) {
					authToken = requestHeader.substring(7);
					try {
						username = jwtTokenUtil.getUsernameFromToken(authToken);
					} catch (MalformedJwtException e) {
						logger.error("an error occured during getting username from token", e);
						throw new IllegalArgumentInJwtException();
					} catch (ExpiredJwtException e) {
						logger.warn("the token is expired and not valid anymore", e);
						throw new jwt.springboot.expressions.security.web.exception.ExpiredJwtException();
					}
				} 
			    //ignore token when login , replace Bearer 'token' -> auth 'username'
				else if (requestHeader != null && requestHeader.startsWith("auth ")){
					username = requestHeader.substring(5);
					
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
				else {
					throw new InvalidHeaderException(2," invalid header ");
				}

				logger.info(" checking authentication for user with other services USERNAME -> " + username);
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

					// For simple validation it is completely sufficient to just check the token integrity. You don't have to call
					// the database compellingly. 
					if (jwtTokenUtil.validateToken(authToken, userDetails)) {
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						logger.info("authenticated user " + username + ", setting security context");
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
				chain.doFilter(request, response);

	        } catch (RuntimeException e) {
	        	/* HANDLE ALL EXCEPTION IN FILTER */
	        	if (e instanceof jwt.springboot.expressions.security.web.exception.UserNotFoundException) {
	        		this.response.setCode(ErrorHandl.USER_NOT_FOUND.getErrorCode());
		            this.response.setMessage(ErrorHandl.USER_NOT_FOUND.toString());
	        	} else if (e instanceof jwt.springboot.expressions.security.web.exception.UsernameNotFoundException) {
	        		this.response.setCode(ErrorHandl.USERNAME_NOT_FOUND.getErrorCode());
		            this.response.setMessage(ErrorHandl.USERNAME_NOT_FOUND.toString());
	        	} else if (e instanceof jwt.springboot.expressions.security.web.exception.InvalidHeaderException) {
	        		this.response.setCode(ErrorHandl.INVALID_HEADER.getErrorCode());
		            this.response.setMessage(ErrorHandl.INVALID_HEADER.toString());
	        	} else if (e instanceof  jwt.springboot.expressions.security.web.exception.IllegalArgumentInJwtException) {
	        		this.response.setCode(ErrorHandl.ILLEGAL_ARGUMENT_IN_JWT.getErrorCode());
		            this.response.setMessage(ErrorHandl.ILLEGAL_ARGUMENT_IN_JWT.toString());
	        	} else if (e instanceof jwt.springboot.expressions.security.web.exception.ExpiredJwtException) {
	        		this.response.setCode(ErrorHandl.EXPIRED_JWT.getErrorCode());
		            this.response.setMessage(ErrorHandl.EXPIRED_JWT.toString());
	        	} else {
	        		this.response.setCode(666);
		            this.response.setMessage("internal server error");
	        	}
	        	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	            response.getWriter().write(convertObjectToJson(this.response));
	    }
	}
	
	/*create response json*/
	public String convertObjectToJson(Object object) throws JsonProcessingException {
		Optional<Object> opt = Optional.ofNullable(object);
        if (!opt.isPresent()) return null;
        return mapper.writeValueAsString(object);
    }
}