package com.jws.jwtdemo;
import static org.springframework.security.config.Customizer.withDefaults;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JwtFilter jwtFilter;
		
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//		http.formLogin(withDefaults());
		http.csrf(Customizer->Customizer.disable()).authorizeHttpRequests(request->{
		request.requestMatchers("/register").permitAll();
		request.requestMatchers("/get").permitAll();
		request.requestMatchers("/user").permitAll();
		request.anyRequest().authenticated();});
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));      
		/*		used to make apis stateless  */
		http.httpBasic(withDefaults());
		return http.build();
	}
	@Bean
	AuthenticationProvider authprovier() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setPasswordEncoder(passwordEncocoder());
		return provider;
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
@Bean
	PasswordEncoder passwordEncocoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
