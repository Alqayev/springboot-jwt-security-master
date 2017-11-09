/**
 * 
 */
package jwt.springboot.expressions.security.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jwt.springboot.expressions.security.utilities.bean.Response;

/**
 * @author Alqayev Taleh
 * 2017 Nov 9, 2017 2:47:49 PM
 */
@Component
public class UsedBean {

	@Bean
	public Response responseBean (){
		return new Response();
	}
	
	@Bean
	public ObjectMapper mapper () {
		return new ObjectMapper();
	}
}
