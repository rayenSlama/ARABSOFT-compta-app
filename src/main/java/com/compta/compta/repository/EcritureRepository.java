package com.compta.compta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.compta.compta.model.Client;
import com.compta.compta.model.Ecriture;
import com.compta.compta.model.User;
@CrossOrigin("*")
@Repository
@RepositoryRestResource
public interface EcritureRepository extends JpaRepository<Ecriture, Long>{
	Optional<Ecriture> findByNumecrt(int numecrt);
	
	/* @RestResource(path = "/byDate")
		public List<Ecriture> findByDate_ecrt(@Param("date_ecrt") String date_ecrt);*/
	/*@RestResource(path = "/byNumcompte")
	public List<Ecriture> findByNumcompte(@Param("numcompte") String numcompte);*/
	
	List<Ecriture>findByNumcompte(String numcompte);
}