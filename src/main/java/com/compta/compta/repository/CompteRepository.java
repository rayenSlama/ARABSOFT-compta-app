package com.compta.compta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import com.compta.compta.model.Compte;
@Repository
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

	
	Optional<Compte> findByCode(int id);
}
