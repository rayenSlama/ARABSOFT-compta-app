package com.compta.compta.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.compta.compta.model.Compteur;
import com.compta.compta.repository.CompteurRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompteurController {
	@Autowired
	CompteurRepository repository;
	
	 @GetMapping("/compteurs")
	  public List<Compteur> getAllCompteurs() {
	    System.out.println("Get all Compteurs...");
	 
	    List<Compteur> Compteurs = new ArrayList<>();
	    repository.findAll().forEach(Compteurs::add);
	 
	    return Compteurs;
	  }
	
	@GetMapping("/compteurs/{annee}")
	public ResponseEntity<Compteur> getCompteurByAnnee(@PathVariable(value = "annee") int annee)
			throws ResourceNotFoundException {
		Compteur Compteur = repository.findByAnnee(annee)
				.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this id :: " + annee));
		return ResponseEntity.ok().body(Compteur);
	}
	
	
	/*@GetMapping("/compteurs/rang/{lig}")
	public ResponseEntity<Compteur> getCompteurByLig(@PathVariable(value = "lig") int lig)
			throws ResourceNotFoundException {
		Compteur Compteur = repository.findByLig(lig)
				.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this lig :: " + lig));
		return ResponseEntity.ok().body(Compteur);
	}*/
	
	
	
	
	
	

	/*@GetMapping("/compteurs/rang/{numcomms}")
	public ResponseEntity<Compteur> getCompteurByNumComms(@PathVariable(value = "numcomms") int numcomms)
			throws ResourceNotFoundException {
		Compteur Compteur = repository.findByNumcomms(numcomms)
				.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this numcomms :: " + numcomms));
		return ResponseEntity.ok().body(Compteur);
	}*/
	
	/*@GetMapping("/compteurs/{id}")
	public ResponseEntity<Compteur> getCompteurById(@PathVariable(value = "id") long CompteurID)
			throws ResourceNotFoundException {
		Compteur Compteur = repository.findById(CompteurID)
				.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this id :: " + CompteurID));
		return ResponseEntity.ok().body(Compteur);
	}*/
	
	
	@PostMapping("/compteurs")
	public Compteur createCompteur(@Valid @RequestBody Compteur Compteur) {
		return repository.save(Compteur);
	}
	

	/*@DeleteMapping("/compteurs/{id}")
	public Map<String, Boolean> deleteCompteur(@PathVariable(value = "id") Long CompteurId)
			throws ResourceNotFoundException {
		Compteur Compteur = repository.findById(CompteurId)
				.orElseThrow(() -> new ResourceNotFoundException("Compteur not found  id :: " + CompteurId));

		repository.delete(Compteur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	/*  @DeleteMapping("/compteurs/delete")
	  public ResponseEntity<String> deleteAllCompteurs() {
	    System.out.println("Delete All Compteurs...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Compteurs have been deleted!", HttpStatus.OK);
	  }
	 
	

	/*  @PutMapping("/compteurs/{id}")
	  public ResponseEntity<Compteur> updateCompteur(@PathVariable("id") long id, @RequestBody Compteur Compteur) {
	    System.out.println("Update Compteur with ID = " + id );
	 
	    Optional<Compteur> CompteurInfo = repository.findById(id);
	 
	    if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	          
	       /*    Compteur.setNumbl(Compteur.getNumbl());
	           Compteur.setNumblf(Compteur.getNumblf());*/
	       /*    Compteur.setNumecrt(Compteur.getNumecrt());*/
	        /*  Compteur.setLig_ecrt(Compteur.getLig_ecrt());*/
	          
	           
	  /*    return new ResponseEntity<>(repository.save(compteur), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
*/
}
