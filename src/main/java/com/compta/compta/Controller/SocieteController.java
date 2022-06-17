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
import org.springframework.web.bind.annotation.RestController;

import com.compta.compta.exception.ResourceNotFoundException;
import com.compta.compta.model.Societe;
import com.compta.compta.model.User;
import com.compta.compta.repository.SocieteRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SocieteController {
	@Autowired
	SocieteRepository repository;
	
	 @GetMapping("/societes")
	  public List<Societe> getAllSocietes() {
	    System.out.println("Get all Societes...");
	 
	    List<Societe> Societes = new ArrayList<>();
	    repository.findAll().forEach(Societes::add);
	 
	    return Societes;
	  }
	
	@GetMapping("/societes/{id}")
	public ResponseEntity<Societe> getSocieteById(@PathVariable(value = "id") Long SocieteId)
			throws ResourceNotFoundException {
		Societe Societe = repository.findById(SocieteId)
				.orElseThrow(() -> new ResourceNotFoundException("Societe not found for this id :: " + SocieteId));
		return ResponseEntity.ok().body(Societe);
	}

	@PostMapping("/societes")
	public Societe createSociete(@Valid @RequestBody Societe Societe) {
		return repository.save(Societe);
	}
	

	@DeleteMapping("/societes/{id}")
	public Map<String, Boolean> deleteSociete(@PathVariable(value = "id") Long SocieteId)
			throws ResourceNotFoundException {
		Societe Societe = repository.findById(SocieteId)
				.orElseThrow(() -> new ResourceNotFoundException("Societe not found  id :: " + SocieteId));

		repository.delete(Societe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/societes/delete")
	  public ResponseEntity<String> deleteAllSocietes() {
	    System.out.println("Delete All Societes...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Societes have been deleted!", HttpStatus.OK);
	  }
	 
	

	  @PutMapping("/societes/{id}")
	  public ResponseEntity<Societe> updateSociete(@PathVariable("id") long id, @RequestBody Societe Societe) {
	    System.out.println("Update Societe with ID = " + id + "...");
	 
	    Optional<Societe> SocieteInfo = repository.findById(id);
	 
	    if (SocieteInfo.isPresent()) {
	    	Societe societe = SocieteInfo.get();
	          
	           societe.setLibelle(societe.getLibelle());
	          
	      return new ResponseEntity<>(repository.save(Societe), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  
	  
	  @GetMapping(path = "/imageEcrt/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	    public byte[]images(@PathVariable(name="id") Long id) throws IOException {
	        Societe s =repository.findById(id).get();
	        String photoName=s.getImage();
	        File file = new File(System.getProperty("user.home")+"/Desktop/pfe web dev/ComptaAPP/src/assets/img/"+photoName);
	        Path path = Paths.get(file.toURI());
	        return Files.readAllBytes(path);
	    }

}
