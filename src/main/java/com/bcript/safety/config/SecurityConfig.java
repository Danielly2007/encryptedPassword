package com.bcript.safety.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() { // só esse método para cripitar a senha.
		return new BCryptPasswordEncoder(); // ainda vai usar o método, ele nãofunfa ainda.
	}
	
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	    	http.csrf(csrf -> csrf.disable());
	    	http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
	    	return http.build();
	    } // permite que faça o cadastro sem depender de um token, ou seja, todos podemfazer cadastro.
	
	

}
