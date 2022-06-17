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
import com.compta.compta.model.Journal;
import com.compta.compta.repository.JournalRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class JournalController {
	@Autowired	
	JournalRepository journalRepository;
	
	@GetMapping("/journals")
	  public List<Journal> getAllJournals() {
	    System.out.println("Get all Journals...");
	 
	    List<Journal> Journals = new ArrayList<>();
	    journalRepository.findAll().forEach(Journals::add);
	 
	    return Journals;
	  }
	
/*	@GetMapping("/journals/{code_JRN}")
	  public List<Journal> getAllByCodeJRN(@PathVariable(value = "code_JRN") int code_JRN) {
	    System.out.println("Get all Journals...");
	 
	    List<Journal> Lecritures = new ArrayList<>();
	    journalRepository.findAllByCodeJRN(code_JRN).forEach(Lecritures::add);

	    return Lecritures;
	  }
	*/
	
	
	@GetMapping("/journals/{id}")
	public ResponseEntity<Journal> getJournalById(@PathVariable(value = "id") Long JournalId)
			throws ResourceNotFoundException {
		Journal Journal = journalRepository.findById(JournalId)
				.orElseThrow(() -> new ResourceNotFoundException("Journal not found for this id :: " + JournalId));
		return ResponseEntity.ok().body(Journal);
	}
	
	
	@PostMapping("/journals")
	public @Valid Journal createJournal(@Valid @RequestBody Journal Journal) {
		
		return journalRepository.save(Journal);
		
		 
	}

	
	
	@DeleteMapping("/journals/{id}")
	public Map<String, Boolean> deleteJournal(@PathVariable(value = "id") Long JournalId)
			throws ResourceNotFoundException {
		Journal Journal = journalRepository.findById(JournalId)
				.orElseThrow(() -> new ResourceNotFoundException("Journal not found  id :: " + JournalId));

		journalRepository.delete(Journal);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/journals/delete")
	  public ResponseEntity<String> deleteAllJournal() {
	    System.out.println("Delete All Journals...");
	 
	    journalRepository.deleteAll();
	 
	    return new ResponseEntity<>("All Journals have been deleted!", HttpStatus.OK);
	  }
	
	
	 @PutMapping("/journals/{id}")
	  public ResponseEntity<Journal> updateJournal(@PathVariable("id") long id, @RequestBody Journal Journal) {
	    System.out.println("Update Journal with ID = " + id + "...");
	    Optional<Journal> JournalInfo = journalRepository.findById(id);
	   
	    
	    if (JournalInfo.isPresent()) {
	    	Journal journal = JournalInfo.get();
	     
	        journal.setLibelle(Journal.getLibelle());
	       
	        journal.setType_JRN(Journal.getType_JRN());
	        
	        
	    	return new ResponseEntity<>(journalRepository.save(Journal), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
}
