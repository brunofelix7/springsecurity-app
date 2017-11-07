package com.algaworks.springsecurityapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import com.algaworks.springsecurityapp.security.UserDetailsServiceSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceSecurity userDetailsService;

	/**
	 * 01. Para cada requisição o meu usuário precisa estar autenticado
	 * 02. Para determinada URL o usuário precisa ter determinado perfil, (protege as páginas)
	 * 03. Gera um formulário de Login
	 * 04. Informa ao Spring Security minha página de login e solicita permissão para acessar essa URL	
	 * 05. Informa ao Spring Security minha URL de logout
	 * 06. Lembra do usuário caso ele feche o navegador e não ultrapasse 60 segundos
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/projects").hasAnyRole("PG_PROJETOS")
				.antMatchers("/cost-reports").hasAnyRole("PG_REL_CUSTOS")
				.antMatchers("/team-reports").hasAnyRole("PG_REL_EQUIPE")
				.anyRequest()
				.authenticated()
//				.sessionManagement()
//				.maximumSessions(30)
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
				.rememberMe()
				.userDetailsService(userDetailsService)
				.tokenValiditySeconds(60);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/layout/**");
	}
	
}
