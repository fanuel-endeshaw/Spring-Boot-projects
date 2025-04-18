package com.oath.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(request->{request.requestMatchers("/").permitAll();
		request.anyRequest().authenticated();
		}).oauth2Login(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.build();
	}
}
