package com.compta.compta.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.compta.compta.domaine.Message;
import com.compta.compta.config.JwtTokenUtil;
import com.compta.compta.domaine.JwtResponse;
import com.compta.compta.exception.ResourceNotFoundException;
import com.compta.compta.model.Exercice_comptable;
import com.compta.compta.model.LigneEcriture;
import com.compta.compta.model.User;
import com.compta.compta.repository.ExerciceRepository;
import com.compta.compta.repository.UserRepository;
import com.compta.compta.request.LoginRequest;
import com.compta.compta.request.RegisterRequest;
import com.compta.compta.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired 	UserRepository repository;
	@Autowired 	AuthenticationManager authenticationManager;
	@Autowired ExerciceRepository exerciceRep;

	@Autowired	UserRepository userRepository;

	@Autowired	PasswordEncoder encoder;

	@Autowired	JwtTokenUtil jwtUtils;

	/*@GetMapping("/pwd")
	public ResponseEntity<?> genPwd() throws Exception{
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(16);
		String encodedPassword=encoder.encode("12345678");
		
		return ResponseEntity.ok(new Message(encodedPassword));
		
	}
	*/
	
	
	
	
	 @GetMapping("/users")
	  public List<User> getAllUtilisateur() {
	    System.out.println("Get all Utilisateur...");
	 
	    List<User> Utilisateur = new ArrayList<>();
	    repository.findAll().forEach(Utilisateur::add);
	 
	    return Utilisateur;
	  }
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUtilisateurById(@PathVariable(value = "id") Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = repository.findById(UtilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + UtilisateurId));
		return ResponseEntity.ok().body(Utilisateur);
	}

	 
	
	
	
		@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = repository.findById(UtilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found  id :: " + UtilisateurId));

		repository.delete(Utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/users/delete")
	  public ResponseEntity<String> deleteAllUtilisateur() {
	    System.out.println("Delete All Utilisateur...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Utilisateurs have been deleted!", HttpStatus.OK);
	  }
	 
	

	  @PutMapping("/users/{id}")
	  public ResponseEntity<User> updateUtilisateur(@PathVariable("id") long id, @RequestBody User Utilisateur) {
	    System.out.println("Update Utilisateur with ID = " + id + "...");
	 
	    Optional<User> UtilisateurInfo = repository.findById(id);
	 
	    if (UtilisateurInfo.isPresent()) {
	    	User utilisateur = UtilisateurInfo.get();
	    	utilisateur.setRole(Utilisateur.getRole());
	    	utilisateur.setCode(Utilisateur.getCode());
	    	utilisateur.setEmail(Utilisateur.getEmail());
	    	utilisateur.setUsername(Utilisateur.getUsername());
	    	utilisateur.setPassword(Utilisateur.getPassword());
	    	utilisateur.setActive(Utilisateur.isActive());
	    	utilisateur.setAdresse(Utilisateur.getAdresse());
	    	utilisateur.setTelephone(Utilisateur.getTelephone());
	    	utilisateur.setImage(Utilisateur.getImage());
	      return new ResponseEntity<>(repository.save(Utilisateur), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
		/*@PostMapping("/users/login")*/
	  
	  
	  @RequestMapping(value = "/authenticate" , method = RequestMethod.POST )
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest data) {
			System.out.println("aaaa");
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
				            
							data.getUsername(),
							data.getPassword())
				           
					);
			
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		/*	System.out.println(jwt);
			System.out.println(userDetails.getUsername());
			System.out.println(userDetails.getRole());*/

			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getCode(),
													 userDetails.getUsername(), 
													 userDetails.getEmail(), 
													 userDetails.getRole()));
		}

		@PostMapping("/users")
		public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
			
			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new Message("Error: Username is already taken!"));
			}

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new Message("Error: Email is already in use!"));
			}
			if (userRepository.existsByCode(signUpRequest.getCode())) {
				return ResponseEntity
						.badRequest()
						.body(new Message("Error: Code user is already in use!"));
			}

			// Create new user's account
			User user = new User(signUpRequest.getCode(),
					             signUpRequest.getUsername(), 
								 signUpRequest.getEmail(),
								 true,
								 encoder.encode(signUpRequest.getPassword()),
								signUpRequest.getRole(),
								signUpRequest.getAdresse(),
								signUpRequest.getTelephone());
			userRepository.save(user);
			
			List<Exercice_comptable> lexercices = user.getLexercices();
		    for (Exercice_comptable le : lexercices) {
		        
		        le.setUser(user);	
		        exerciceRep.save(le);
		}	
		    return ResponseEntity.ok(new Message("User registered successfully!"));
		}
		
		
		@GetMapping(path = "/imageUser/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	    public byte[]images(@PathVariable(name="id") Long id) throws IOException {
	        User e =userRepository.findById(id).get();
	        String photoName=e.getImage();
	        File file = new File(System.getProperty("user.home")+"/Desktop/pfe web dev/ComptaAPP/src/assets/img/"+photoName);
	        Path path = Paths.get(file.toURI());
	        return Files.readAllBytes(path);
	    }

}
