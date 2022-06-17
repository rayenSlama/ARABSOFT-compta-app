package com.compta.compta.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compta.compta.exception.ResourceNotFoundException;
import com.compta.compta.model.Tiers;
import com.compta.compta.repository.ClientRepository;
import com.compta.compta.repository.TiersRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TiersController {
	@Autowired 	TiersRepository tierepository;
	@Autowired  ClientRepository clientrep;
	@Autowired FournisseurController fournisseurepository;
	
	 @GetMapping("/tiers")
	  public List<Tiers> getAllTiers() {
	    System.out.println("Get all Tiers...");
	 
	    List<Tiers> Tiers = new ArrayList<>();
	    tierepository.findAll().forEach(Tiers::add);
	    
	    return Tiers;
	  }
	
	@GetMapping("/tiers/{id}")
	public ResponseEntity<Tiers> getTiersById(@PathVariable(value = "id") Long TiersId)
			throws ResourceNotFoundException {
		Tiers Tiers = tierepository.findById(TiersId)
				.orElseThrow(() -> new ResourceNotFoundException("Tiers not found for this id :: " + TiersId));
		return ResponseEntity.ok().body(Tiers);
	}

	/*@GetMapping("/tiers/{code}")
	public ResponseEntity<Tiers> getTiersByCode(@PathVariable String code)
			throws ResourceNotFoundException {
		Tiers Tiers = tierepository.findByCode(code)
				.orElseThrow(() -> new ResourceNotFoundException("Tiers not found for this id :: " + code));
		return ResponseEntity.ok().body(Tiers);
	}
 */
	
	
	
		@DeleteMapping("/tiers/{id}")
	public Map<String, Boolean> deleteTiers(@PathVariable(value = "id") Long TiersId)
			throws ResourceNotFoundException {
		Tiers Tiers = tierepository.findById(TiersId)
				.orElseThrow(() -> new ResourceNotFoundException("Tiers not found  id :: " + TiersId));

		tierepository.delete(Tiers);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/tiers/delete")
	  public ResponseEntity<String> deleteAllTiers() {
	    System.out.println("Delete All Tiers...");
	 
	    tierepository.deleteAll();
	 
	    return new ResponseEntity<>("All tiers have been deleted!", HttpStatus.OK);
	  }
	 
	

	  @PutMapping("/tiers/{id}")
	  public ResponseEntity<Tiers> updateTiers(@PathVariable("id") long id, @RequestBody Tiers Tiers) {
	    System.out.println("Update Tiers with ID = " + id + "...");
	 
	    Optional<Tiers> TiersInfo = tierepository.findById(id);
	 
	    if (TiersInfo.isPresent()) {
	    	Tiers tiers = TiersInfo.get();
	   
	    	
	      return new ResponseEntity<>(tierepository.save(Tiers), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	 
	
	  
	  
	  
}
