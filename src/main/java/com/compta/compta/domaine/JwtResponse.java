package com.compta.compta.domaine;

public class JwtResponse  {

	private String jwt;
	private Long id;
	private Long code;
	private String username;
	private String email;
	private String role;

	public JwtResponse(String jwt, Long id,Long code, String username, String email, String role) {
		this.jwt = jwt;
		this.id = id;
		this.code=code;
		this.username = username;
		this.email = email;
		this.role = role;
	}

	

	
	
	public String getJwt() {
		return jwt;
	}





	public void setJwt(String jwt) {
		this.jwt = jwt;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}