package com.compta.compta.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Utilisateur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"
				+ ""),
		@UniqueConstraint(columnNames = "email") ,
		@UniqueConstraint(columnNames = "code")
	})
public class User {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  @NotBlank
		@Size(max = 20)
	  private String username;
	  @NotBlank
	  @Size(max = 20)
	  @Email
	  private String email;
	  private String password;
/**/	  private boolean isActive;
      @Size(max = 8)
      private String telephone;
      private String adresse;
      private String image;
      
      
	  public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private String role;
	 
	
	 private Long code;
	
	 @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
     @Valid
	  private List<Exercice_comptable> lexercices = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Exercice_comptable> getLexercices() {
		return lexercices;
	}
	public void setLexercices(List<Exercice_comptable> lexercices) {
		this.lexercices = lexercices;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public User(long code,@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) @Email String email, boolean isActive
			,String password, String role,String adresse,String telephone) {
		super();
		this.code=code;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.role = role;
		this.adresse=adresse;
		this.telephone=telephone;
	}
	
	
	/*public User(long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) @Email String email,
			String password, boolean isActive, @Size(max = 8) String telephone, String adresse, String image,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.telephone = telephone;
		this.adresse = adresse;
		this.image = image;
		this.role = role;
	}*/
	
	
	
	public User() {
		
		this.isActive = true;
	}
	public User(long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) @Email String email,
			String password, boolean isActive, @Size(max = 8) String telephone, String adresse, String image,
			String role, @NotNull Long code, @Valid List<Exercice_comptable> lexercices) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.telephone = telephone;
		this.adresse = adresse;
		this.image = image;
		this.role = role;
		this.code = code;
		this.lexercices = lexercices;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", isActive=" + isActive + ", telephone=" + telephone + ", adresse=" + adresse + ", image=" + image
				+ ", role=" + role + ", code=" + code + ", lexercices=" + lexercices + "]";
	}

	

	
}