package jwt.springboot.expressions.security.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jwt.springboot.expressions.security.config.security.filter.AuthenticationTokenFilter;
import jwt.springboot.expressions.security.config.security.override.CustomAuthenticationEntryPoint;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:47:52 PM
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Value("${security.signing-key}")
	private String signingKey;

	@Value("${security.encoding-strength}")
	private Integer encodingStrength;

	@Value("${security.security-realm}")
	private String securityRealm;
	
	@Autowired
	private CustomAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		        .passwordEncoder(new ShaPasswordEncoder(encodingStrength));
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new AuthenticationTokenFilter();
	}  

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		// we don't need CSRF because our token is invulnerable
		.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		// don't create session
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
		//		 .antMatchers("/auth/**").hasRole("ADMIN")
		.antMatchers("/auth/**")
		.permitAll()
		.anyRequest()
		.authenticated();
		httpSecurity
		.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// disable page caching
		httpSecurity.headers().cacheControl();
	}	
}
