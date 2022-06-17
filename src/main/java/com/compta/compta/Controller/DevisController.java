package com.compta.compta.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compta.compta.exception.ResourceNotFoundException;
import com.compta.compta.model.Devis;
import com.compta.compta.repository.DevisRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DevisController {
	@Autowired 	DevisRepository repository;
	@Autowired  ServletContext context;
	 @GetMapping("/devis")
	  public List<Devis> getAllDeviss() {
	    System.out.println("Get all Devis...");
	    List<Devis> Deviss = new ArrayList<>();
	    repository.findAll().forEach(Deviss::add);
	    return Deviss;
	  }
	
	@GetMapping("/devis/{id}")
	public ResponseEntity<Devis> getDevisById(@PathVariable(value = "id") Long DevisId)
			throws ResourceNotFoundException {
		Devis Devis = repository.findById(DevisId)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not found for this id :: " + DevisId));
		return ResponseEntity.ok().body(Devis);
	}

	/*@PostMapping("/devis")
	public ResponseEntity<Devis> createComm(@Valid @RequestBody Devis Devis)  throws JsonParseException , JsonMappingException , Exception{
		repository.save(Devis);
		List<Ldevis> ldevis = Devis.getLdeviss();
	    for (Ldevis lc : ldevis) {
	        lc.setNumero(Devis.getNumero());
       		repo.save(lc);
	       }	 
	
     Optional<Compteur> CompteurInfo = comptrepo.findByAnnee(Devis.getAnnee());
     	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setNumdev(compteur.getNumdev()+1);
	         compteur =   comptrepo.save(compteur);
     	}
		 return new ResponseEntity<>(HttpStatus.OK);
	}*/

	@DeleteMapping("/devis/{id}")
	public Map<String, Boolean> deleteDevis(@PathVariable(value = "id") Long DevisId)
			throws ResourceNotFoundException {
		Devis Devis = repository.findById(DevisId)
				.orElseThrow(() -> new ResourceNotFoundException("Devis not found  id :: " + DevisId));
		repository.delete(Devis);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	 
	  @DeleteMapping("/devis/delete")
	  public ResponseEntity<String> deleteAllDeviss() {
	    System.out.println("Delete All Deviss...");
	    repository.deleteAll();
	    return new ResponseEntity<>("All Deviss have been deleted!", HttpStatus.OK);
	  }
	 
	  @PutMapping("/devis/{id}")
	  public ResponseEntity<Devis> updateDevis(@PathVariable("id") long id, @RequestBody Devis Devis) {
	    System.out.println("Update Devis with ID = " + id + "...");
	    Optional<Devis> DevisInfo = repository.findById(id);
	    if (DevisInfo.isPresent()) {
	    	Devis devis = DevisInfo.get();
	    
	      return new ResponseEntity<>(repository.save(Devis), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
