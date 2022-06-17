package com.compta.compta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Journal;

@Repository
@RepositoryRestResource
public interface JournalRepository extends JpaRepository<Journal, Long>{

	
/*	Iterable<Journal> findAllByCodeJRN(int code_JRN);
	
	@Modifying
    @Transactional
    @Query("delete from Journal j where code_JRN = ?1")
    void deleteByNumero(int code_JRN);*/
}
