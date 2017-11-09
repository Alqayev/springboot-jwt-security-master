package jwt.springboot.expressions.security.web.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jwt.springboot.expressions.security.utilities.bean.Response;
import jwt.springboot.expressions.security.utilities.enums.ErrorHandl;
import jwt.springboot.expressions.security.web.exception.ExpiredJwtException;
import jwt.springboot.expressions.security.web.exception.InvalidHeaderException;
import jwt.springboot.expressions.security.web.exception.MissingJwtException;
import jwt.springboot.expressions.security.web.exception.UsernameNotFoundException;
import jwt.springboot.expressions.security.web.exception.UserNotFoundException;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 5:51:12 PM
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<?> handleUserNotFound(final Exception ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.USER_NOT_FOUND;
		return ResponseEntity.ok(new Response(cm));
	}
	
	@ExceptionHandler({ InvalidHeaderException.class })
	public ResponseEntity<Object> invalidHeader(final RuntimeException ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.INVALID_HEADER;
		return ResponseEntity.ok(new Response(cm));
	}
	
	@ExceptionHandler({ ExpiredJwtException.class })
	public ResponseEntity<Object> expiredJwtException(final RuntimeException ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.EXPIRED_JWT;
		return ResponseEntity.ok(new Response(cm));
	}
	
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<Object> illegalArgumentException(final RuntimeException ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.ILLEGAL_ARGUMENT_IN_JWT;
		return ResponseEntity.ok(new Response(cm));
	}
	
	@ExceptionHandler({ UsernameNotFoundException.class })
	public ResponseEntity<Object> userNameNotFoundException(final RuntimeException ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.USERNAME_NOT_FOUND;
		return ResponseEntity.ok(new Response(cm));
	}
	
	@ExceptionHandler({ MissingJwtException.class })
	public ResponseEntity<Object> handleJwt(final Exception ex, final WebRequest request) {
		ErrorHandl cm = ErrorHandl.USER_NOT_FOUND;
		return ResponseEntity.ok(new Response(cm));
	}
	
	
}
