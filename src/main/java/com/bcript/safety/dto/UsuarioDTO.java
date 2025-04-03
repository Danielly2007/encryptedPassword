package com.bcript.safety.dto;

import com.bcript.safety.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	private String email;
	private String password;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		email = entity.getEmail();
		password = entity.getPassword();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
