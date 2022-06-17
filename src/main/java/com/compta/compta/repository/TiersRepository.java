package com.compta.compta.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.compta.compta.model.Tiers;
@CrossOrigin
@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long> {

	
	
}
