package com.compta.compta.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.compta.compta.model.Ecriture;

import com.compta.compta.model.Compteur;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
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
import com.compta.compta.model.LigneEcriture;
import com.compta.compta.model.Societe;
import com.compta.compta.repository.CompteurRepository;
import com.compta.compta.repository.JournalRepository;
import com.compta.compta.repository.LigneEcritureRepository;
import com.compta.compta.repository.SocieteRepository;
import com.fasterxml.jackson.databind.JsonMappingException;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LigneEcritureController {
	@Autowired	
	LigneEcritureRepository ligneRepository;
	@Autowired
	CompteurRepository comptrepo;
	@Autowired
	 SocieteRepository   sterepository;
	@GetMapping("/lecrts")
	  public List<LigneEcriture> getAllJournals() {
	    System.out.println("Get all LigneEcritures...");
	 
	    List<LigneEcriture> LigneEcritures = new ArrayList<>();
	    ligneRepository.findAll().forEach(LigneEcritures::add);
	 
	    return LigneEcritures;
	  }
	
	@GetMapping("/lecrts/{numero}")
	  public List<LigneEcriture> getAllByNumero(@PathVariable(value = "numero") int numero) {
	    System.out.println("Get all ligne ecritures while numero d'écriture est" +numero);
	  
	    List<LigneEcriture> Lecritures = new ArrayList<>();
	    ligneRepository.findAllByNumero(numero).forEach(Lecritures::add);

	    return Lecritures;
	  }
	
	
	
/*	@GetMapping("/lecrts/{id}")
	public ResponseEntity<LigneEcriture> getLigneEcritureById(@PathVariable(value = "id") Long LigneEcritureId)
			throws ResourceNotFoundException {
		LigneEcriture LigneEcriture = ligneRepository.findById(LigneEcritureId)
				.orElseThrow(() -> new ResourceNotFoundException("LigneEcriture not found for this id :: " + LigneEcritureId));
		return ResponseEntity.ok().body(LigneEcriture);
	}*/
	
	
	/*@PostMapping("/lecrts")
	public @Valid LigneEcriture createLigneEcriture(@Valid @RequestBody LigneEcriture LigneEcriture) {
		
	Optional<Compteur> CompteurInfo1 = comptrepo.findByLig(Ecriture.getNumecrt());
     	if (CompteurInfo1.isPresent()) {
	    	Compteur compteur = CompteurInfo1.get();
	      
	       compteur.setLig(compteur.getLig()+1);
	         compteur =   comptrepo.save(compteur);
		
     	}*/
		
		
	/*	
		return ligneRepository.save(LigneEcriture);
		
		 
	}

	*/
	
	@PostMapping("/lecrts")
	public @Valid LigneEcriture createLigneEcrt(@Valid @RequestBody LigneEcriture LigneEcriture){
		  
    /* Optional<Compteur> CompteurInfo = comptrepo.findByLig(LigneEcriture.getLig());*/
     	/*if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	          /* compteur.setLig(compteur.getLig()+1);*/
	       
	       /*  compteur =   comptrepo.save(compteur);*/
     /*	}*/
		
		
		
		
		
	/*	long id = 1;
		Optional<Societe> SocieteInfo = sterepository.findById(id);
 	    if (SocieteInfo.isPresent()) {
	    	Societe ste = SocieteInfo.get();
	        /*   ste.setNumc(ste.getNumc()+1);*/
	       /*    ste.setRang(ste.getRanglig()+1);
	           ste = sterepository.save(ste);
	    }*/
		
 	  /* Optional<Compteur> CompteurInfo = comptrepo.findByAnnee(LigneEcriture.getAnnee());
    	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setLig(compteur.getLig()+1);
	       
	         compteur =   comptrepo.save(compteur);
    	}*/
     
		Optional<Compteur> CompteurInfo1 = comptrepo.findByAnnee(LigneEcriture.getAnnee());
    	if (CompteurInfo1.isPresent()) {
	    	Compteur compteur = CompteurInfo1.get();
	           compteur.setLig(compteur.getLig()+1);
	       
	         compteur =   comptrepo.save(compteur);
    	}
 	    
 	    
 	    
     	return ligneRepository.save(LigneEcriture);
     	
     	
	
	}

	
	
	@DeleteMapping("/lecrts/{id}")
	public Map<String, Boolean> deleteJournal(@PathVariable(value = "id") Long LecritureId)
			throws ResourceNotFoundException {
		LigneEcriture LigneEcriture = ligneRepository.findById(LecritureId)
				.orElseThrow(() -> new ResourceNotFoundException("Journal not found  id :: " + LecritureId));

	ligneRepository.delete(LigneEcriture);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/lecrts/delete")
	  public ResponseEntity<String> deleteAllLigneEcriture() {
	    System.out.println("Delete All LigneEcriture...");
	 
	    ligneRepository.deleteAll();
	 
	    return new ResponseEntity<>("All LigneEcriture have been deleted!", HttpStatus.OK);
	  }
	
	
	 @PutMapping("/lecrts/{id}")
	  public ResponseEntity<LigneEcriture> updateLigneEcriture(@PathVariable("id") long id, @RequestBody LigneEcriture LigneEcriture ) {
	    System.out.println("Update LigneEcriture with ID = " + id + "...");
	    Optional<LigneEcriture> LigneEcritureInfo = ligneRepository.findById(id);
	   
	    
	    if (LigneEcritureInfo.isPresent()) {
	    	LigneEcriture ligneEcriture = LigneEcritureInfo.get();
	     
	    	
	       
	  	/*ligneEcriture.setCode_JRN(LigneEcriture.getCode_JRN());*/
	    	
	        
	    	return new ResponseEntity<>(ligneRepository.save(LigneEcriture), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
}

