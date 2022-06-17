package com.compta.compta.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Optional;

import javax.servlet.ServletContext;
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

import com.compta.compta.model.Ecriture;
import com.compta.compta.model.Journal;
import com.compta.compta.model.LigneEcriture;
import com.compta.compta.model.Societe;
import com.compta.compta.model.Compteur;
import com.compta.compta.repository.CompteurRepository;
import com.compta.compta.repository.EcritureRepository;
import com.compta.compta.repository.JournalRepository;
import com.compta.compta.repository.LigneEcritureRepository;
import com.compta.compta.repository.SocieteRepository;
import com.fasterxml.jackson.databind.JsonMappingException;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EcritureController {
	@Autowired	
	EcritureRepository ecrtRepository;
	@Autowired
	JournalRepository jrnRepository;
	@Autowired
	LigneEcritureRepository lecrtRepository;
	@Autowired 
	ServletContext context;
	@Autowired
	CompteurRepository comptrepo;
	@Autowired
	SocieteRepository sterepository;
	
	@GetMapping("/ecritures")
	  public List<Ecriture> getAllEcritures() {
	    System.out.println("Get all ecritures...");
	 
	    List<Ecriture> Ecritures = new ArrayList<>();
	    ecrtRepository.findAll().forEach(Ecritures::add);
	 
	    return Ecritures;
	  }
	
	
	/*@GetMapping("/ecritures/{id}")
	public ResponseEntity<Ecriture> getEcritureById(@PathVariable(value = "id") Long EcritureId)
			throws ResourceNotFoundException {
		Ecriture Ecriture = ecrtRepository.findById(EcritureId)
				.orElseThrow(() -> new ResourceNotFoundException("Ecriture not found for this id :: " + EcritureId));
		return ResponseEntity.ok().body(Ecriture);
	}*/

	@GetMapping("/ecritures/{numecrt}")
	public ResponseEntity<Ecriture> getEcritureById(@PathVariable(value = "numecrt") int numecrt)
			throws ResourceNotFoundException {
		Ecriture Ecriture = ecrtRepository.findByNumecrt(numecrt)
				.orElseThrow(() -> new ResourceNotFoundException("Ecriture not found for this numero :: " + numecrt));
		return ResponseEntity.ok().body(Ecriture);
	}
	
	
	
	
	
	
	@GetMapping("/ecritures/num/{numcompte}")
	public ResponseEntity<List<Ecriture>> getEcritureByNumcompte(@PathVariable(value = "numcompte") String numcompte)
			 {
		List<Ecriture> Ecriture = ecrtRepository.findByNumcompte(numcompte);
				
	/*	return ResponseEntity.ok().body(Ecriture);*/
		  return new ResponseEntity<>(Ecriture, HttpStatus.OK);
	}
	
	@PostMapping("/ecritures")
	public ResponseEntity<Ecriture> createEcrt(@Valid @RequestBody Ecriture Ecriture)  
			throws JsonParseException , JsonMappingException , Exception{
		  
    	ecrtRepository.save(Ecriture);
		
		List<LigneEcriture> lecritures = Ecriture.getLecritures();
	  /*  for (LigneEcriture le : lecritures) {
	        le.setNumero(Ecriture.getNumecrt());
	      /*  le.setCode_JRN(Ecriture.getCode_JRN());
	        le.setLib_ecrt(Ecriture.getLibelle());*/
	      /* Ecriture.setNumcompte(le.getNumcompte());
	        Ecriture.setNum_piece(le.getNum_piece());
	        Ecriture.setCode(le.getCode());
	        Ecriture.setCodetier(le.getCodetier());
	        Ecriture.setLib_tier(le.getLib_tier());
	        Ecriture.setLibellec(le.getLibellec());
	        Ecriture.setLig(le.getLig());*/
	  Iterator<LigneEcriture> itr = lecritures.iterator();
	  while(itr.hasNext()) {
		  LigneEcriture le = itr.next();
		  le.setNumero(Ecriture.getNumecrt());
		  Ecriture.setNumcompte(le.getNumcompte());
	        Ecriture.setNum_piece(le.getNum_piece());
	        Ecriture.setCode(le.getCode());
	        Ecriture.setCodetier(le.getCodetier());
	        Ecriture.setLib_tier(le.getLib_tier());
	        Ecriture.setLibellec(le.getLibellec());
	        Ecriture.setLig(le.getLig());
		  
		  
	     	
	  
	      	}
	     /* le.setLig(Ecriture.getLig());*/
	      
	      
	     /*   le.setCode(Ecriture.getCode());*/
	   /* le.setLib_ecrt(Ecriture.getLibelle());*/
	       /* le.setNum_piece(Ecriture.getNum_piece());*/	
	    /*    le.setLig(Ecriture.getLig()+1);/*   le.setLibelle(Ecriture.);*/
	   
	     	
	    	
	     /*	Optional<Compteur> CompteurInfo1 = comptrepo.findByLig(Ecriture.getNumecrt());
	     	if (CompteurInfo1.isPresent()) {
		    	Compteur compteur = CompteurInfo1.get();
		      
		       compteur.setLig(compteur.getLig()+1);
		         compteur =   comptrepo.save(compteur);
	     	}*/
	    	     
	        
	        
	        
	        
	        
       	
       		
	       	 
	
     Optional<Compteur> CompteurInfo = comptrepo.findByAnnee(Ecriture.getAnnee());
     	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setNumecrt(compteur.getNumecrt()+1);
	       
	         compteur =   comptrepo.save(compteur);
     	}
     	
     	/*Optional<Compteur> CompteurInfo1 = comptrepo.findByAnnee(Ecriture.getAnnee());
    	if (CompteurInfo1.isPresent()) {
	    	Compteur compteur = CompteurInfo1.get();
	           compteur.setLig(compteur.getLig()+1);
	       
	         compteur =   comptrepo.save(compteur);
    	}*/
     	
     	
     	
     	
     	
     	
     /*	Optional<Compteur> CompteurInfo1 = comptrepo.findByLig(Ecriture.getLig());
     	if (CompteurInfo1.isPresent()) {
	    	Compteur compteur = CompteurInfo1.get();
	           compteur.setLig(compteur.getLig()+1);
	       
	         compteur =   comptrepo.save(compteur);
     	}*/
     
     	
    
     	
     	
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	@DeleteMapping("/ecritures/{id}")
	public ResponseEntity<Ecriture>  deleteEcriture(@PathVariable(value = "id") Long EcritureId)
	{
		Optional<Ecriture> EcritureInfo = ecrtRepository.findById(EcritureId);
	  if (EcritureInfo.isPresent()) {
		 
		  Ecriture Ecriture = EcritureInfo.get();
		  lecrtRepository.deleteByNumero(Ecriture.getNumecrt());
		  ecrtRepository.delete(Ecriture);
		  return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	 
	  @DeleteMapping("/ecritures/delete")
	  public ResponseEntity<String> deleteAllEcritures() {
	    System.out.println("Delete All Ecritures...");
	    ecrtRepository.deleteAll();
	    return new ResponseEntity<>("All Ecritures have been deleted!", HttpStatus.OK);
	  }
	 
	  @PutMapping("/ecritures/{id}")
	  public ResponseEntity<Ecriture> updateEcriture(@PathVariable("id") long id, @RequestBody Ecriture Ecriture) {
	    System.out.println("Update Ecriture with ID = " + id + "...");
	    Optional<Ecriture> EcritureInfo = ecrtRepository.findById(id);
	   /* List<LigneEcriture> lecritures = Ecriture.getLecritures();
	    for (LigneEcriture le : lecritures) {
	     
	        Ecriture.setNumcompte(le.getNumcompte());
	        Ecriture.setNum_piece(le.getNum_piece());
	   
	      Ecriture.setLig(le.getLig());
	    le.setLib_ecrt(Ecriture.getLibelle());
	    le.setMontant(Ecriture.getMontant());*/
	    
	    
	    
	    
	    if (EcritureInfo.isPresent()) {
	    	Ecriture ecriture = EcritureInfo.get();
	    	ecriture.setLibelle(Ecriture.getLibelle());
	    	ecriture.setCodetier(Ecriture.getCodetier());
	    	ecriture.setNumcompte(Ecriture.getNumcompte());
	    	ecriture.setMontant(ecriture.getMontant());
	    	ecriture.setNum_piece(ecriture.getNum_piece());
	    	ecriture.setCode_devise(ecriture.getCode_devise());
	    	ecriture.setTaux(ecriture.getTaux());
	    	ecriture.setTotcred(ecriture.getTotcred());
	    	ecriture.setTotdeb(ecriture.getTotcred());
	    	ecriture.setSolde(ecriture.getSolde());
	    	ecriture.setSens(ecriture.getSens());
	      return new ResponseEntity<>(ecrtRepository.save(ecriture), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	
	
	
}
