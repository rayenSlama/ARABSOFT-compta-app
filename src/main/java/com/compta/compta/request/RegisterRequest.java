package com.compta.compta.request;




import javax.validation.constraints.*;
public class RegisterRequest {
	@NotBlank
    @Size(min = 3, max = 40)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email 
    private String email;
    @NotBlank
    private String role;
    @NotBlank
    @Size(min = 6, max = 220)
    private String password;
    @NotNull
    private Long code;
    
    public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	private String adresse;
    private String telephone;
   
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
