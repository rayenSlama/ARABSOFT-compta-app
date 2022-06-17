package com.compta.compta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Devis;




@Repository
public interface DevisRepository extends JpaRepository<Devis, Long>{
	/*Iterable<Devis> findAllByCode(String code_devise);*/
}
