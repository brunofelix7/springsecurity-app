package com.algaworks.springsecurityapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Classe de configuração de acesso a partes da aplicação em memória
 */
//@Configuration
public class InMemorySecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("admin").password("123").roles("PG_PROJETOS", "PG_REL_CUSTOS", "PG_REL_EQUIPE")
			.and()
			.withUser("bruno").password("123").roles("PG_PROJETOS", "PG_REL_EQUIPE");
	}
	
}
