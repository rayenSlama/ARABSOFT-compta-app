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
import com.compta.compta.model.Client;
import com.compta.compta.model.Exercice_comptable;
import com.compta.compta.model.Societe;
import com.compta.compta.repository.ExerciceRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ExerciceController {
	@Autowired	
	ExerciceRepository exerciceRepository;
	
	@GetMapping("/exercices")
	  public List<Exercice_comptable> getAllExercice_comptables() {
	    System.out.println("Get all exercice_comptables...");
	 
	    List<Exercice_comptable> Exercice_comptables = new ArrayList<>();
	    exerciceRepository.findAll().forEach(Exercice_comptables::add);
	 
	    return Exercice_comptables;
	  }
	
	  
	  @PostMapping("/exercices")
		public Exercice_comptable createExercice(@Valid @RequestBody Exercice_comptable Exercice_comptable) {
			
	 		return exerciceRepository.save(Exercice_comptable);
		} 
	  
	  
	  
	  
	  
	  
	
	@GetMapping("/exercices/{id}")
	public ResponseEntity<Exercice_comptable> getExercice_comptableById(@PathVariable(value = "id") Long Exercice_comptableId)
			throws ResourceNotFoundException {
		Exercice_comptable Exercice_comptable = exerciceRepository.findById(Exercice_comptableId)
				.orElseThrow(() -> new ResourceNotFoundException("Exercice_comptable not found for this id :: " + Exercice_comptableId));
		return ResponseEntity.ok().body(Exercice_comptable);
	}

	
	
	@DeleteMapping("/exercices/{id}")
	public Map<String, Boolean> deleteExercice_comptable(@PathVariable(value = "id") Long Exercice_comptableId)
			throws ResourceNotFoundException {
		Exercice_comptable Exercice_comptable = exerciceRepository.findById(Exercice_comptableId)
				.orElseThrow(() -> new ResourceNotFoundException("Exercice_comptable not found  id :: " + Exercice_comptableId));

		exerciceRepository.delete(Exercice_comptable);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/exercices/delete")
	  public ResponseEntity<String> deleteAllExercice_comptable() {
	    System.out.println("Delete All Exercice_comptables...");
	 
	    exerciceRepository.deleteAll();
	 
	    return new ResponseEntity<>("All Exercice_comptables have been deleted!", HttpStatus.OK);
	  }
	
	
	 @PutMapping("/exercices/{id}")
	  public ResponseEntity<Exercice_comptable> updateExercice_comptable(@PathVariable("id") long id, @RequestBody Exercice_comptable Exercice_comptable) {
	    System.out.println("Update Exercice_comptable with ID = " + id + "...");
	    Optional<Exercice_comptable> Exercice_comptableInfo = exerciceRepository.findById(id);
	   
	    
	    if (Exercice_comptableInfo.isPresent()) {
	    	Exercice_comptable exercice_comptable = Exercice_comptableInfo.get();
	        exercice_comptable.setAnnee(Exercice_comptable.getAnnee());
	        exercice_comptable.setClot(Exercice_comptable.getClot());
	      
	        exercice_comptable.setDate_debut(Exercice_comptable.getDate_debut());
	        exercice_comptable.setDate_fin(Exercice_comptable.getDate_fin());
	     
	    	return new ResponseEntity<>(exerciceRepository.save(Exercice_comptable), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	  
}
