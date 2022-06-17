package com.compta.compta.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long>{

}