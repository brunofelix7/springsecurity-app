package com.algaworks.springsecurityapp.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static com.algaworks.springsecurityapp.util.SQLQuery.*;

/**
 * Busca os usuários no banco de dados
 */
//@Configuration
public class InDatabaseSecurityConfig {

	/**
	 * 01. Informa ao Spring Security como buscar um usuário pelo username que está tentando se autenticar
	 * 02. Informa ao Spring Security como buscar as permissões do usuário que está tentando se autenticar
	 * 03. Informa ao Spring Security como buscar as grupos do usuário que está tentando se autenticar
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception {
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(USUARIO_POR_LOGIN)
			.authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO)
			.groupAuthoritiesByUsername(PERMISSOES_POR_GRUPO);
	}
	
}
