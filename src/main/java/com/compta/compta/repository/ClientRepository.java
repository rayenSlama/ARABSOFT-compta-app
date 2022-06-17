package com.compta.compta.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByCode(int id);

	
}
