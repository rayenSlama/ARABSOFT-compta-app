package com.compta.compta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Compteur;


@Repository
public interface CompteurRepository extends JpaRepository<Compteur, Long>{

	Optional<Compteur> findByLig(int lig);
	Optional<Compteur> findByAnnee(int annee);
	Optional<Compteur> findByNumcomms(int numcomms);
}