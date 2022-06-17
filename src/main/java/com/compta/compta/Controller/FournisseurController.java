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

import com.compta.compta.model.Fournisseur;
import com.compta.compta.model.Societe;
import com.compta.compta.repository.FournisseurRepository;
import com.compta.compta.repository.SocieteRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FournisseurController {
	@Autowired
	FournisseurRepository repository;
	@Autowired 	
	SocieteRepository sterepository;
	 @GetMapping("/four")
	  public List<Fournisseur> getAllFournisseurs() {
	    System.out.println("Get all Fournisseurs...");
	 
	    List<Fournisseur> Fournisseurs = new ArrayList<>();
	    repository.findAll().forEach(Fournisseurs::add);
	 
	    return Fournisseurs;
	  }
	
	@GetMapping("/four/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") Long FournisseurId)
			throws ResourceNotFoundException {
		Fournisseur Fournisseur = repository.findById(FournisseurId)
				.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + FournisseurId));
		return ResponseEntity.ok().body(Fournisseur);
	}

	
	

	@DeleteMapping("/four/{id}")
	public Map<String, Boolean> deleteFournisseur(@PathVariable(value = "id") Long FournisseurId)
			throws ResourceNotFoundException {
		Fournisseur Fournisseur = repository.findById(FournisseurId)
				.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found  id :: " + FournisseurId));

		repository.delete(Fournisseur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/four/delete")
	  public ResponseEntity<String> deleteAllFournisseurs() {
	    System.out.println("Delete All Fournisseurs...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Fournisseurs have been deleted!", HttpStatus.OK);
	  }
	 
	  @PostMapping("/four")
		public Fournisseur createFournisseur(@Valid @RequestBody Fournisseur Fournisseur) {
			long id = 1;
			Optional<Societe> SocieteInfo = sterepository.findById(id);
	 	    if (SocieteInfo.isPresent()) {
		    	Societe ste = SocieteInfo.get();
		           ste.setNumf(ste.getNumf()+1);
		           ste.setRangg(ste.getRangg()+1);
		           ste = sterepository.save(ste);
		    }
	 		return repository.save(Fournisseur);
		}

	  @PutMapping("/four/{id}")
	  public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id, 
			  @RequestBody Fournisseur Fournisseur) {
	    System.out.println("Update Fournisseur with ID = " + id + "...");
	 
	    Optional<Fournisseur> FournisseurInfo = repository.findById(id);
	 
	    if (FournisseurInfo.isPresent()) {
	    	Fournisseur four = FournisseurInfo.get();
	          
	           four.setLibelle(Fournisseur.getLibelle());
	           four.setAdresse(Fournisseur.getAdresse());
	          
	           four.setEmail(Fournisseur.getEmail());
	           four.setLogin(Fournisseur.getLogin());
	          
	           four.setPwd(Fournisseur.getPwd());
	           four.setTel(Fournisseur.getTel());
	         
	           
	      return new ResponseEntity<>(repository.save(Fournisseur), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
