package com.algaworks.springsecurityapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.algaworks.springsecurityapp.security.UserDetailsServiceSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Realiza a busca do usuário no banco de dados de forma personalizada
 */
@Configuration
public class UserDetailsSecurityConfig {

	/**
	 * @param passwordEncoder Para que o Spring consiga comparar o hash do banco com o hash da senha que o usuário vai digitar no formulário
	 * @param userDetailsService 
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, UserDetailsServiceSecurity userDetailsService) throws Exception {
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
}
