package com.algaworks.springsecurityapp.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Substitui a minha query do banco de dados, ao invés disso, basta passar esse objeto
 */
public class UserDetailsSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String login;
	private String senha;
	private boolean ativo;
	private Collection<GrantedAuthority> permissoes = new ArrayList<>();
	
	public UserDetailsSecurity() {
		
	}
	
	public UserDetailsSecurity(String nome, String login, String senha, boolean ativo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	@Override
	public String getUsername() {
		return login;
	}
	
	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return ativo;
	}
	
	@Override
	public String toString() {
		return "User [nome=" + nome + ", login=" + login + ", senha=" + senha + ", ativo=" + ativo + "]";
	}
}
