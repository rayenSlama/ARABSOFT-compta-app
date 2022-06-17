package com.compta.compta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compta.compta.model.Status;


@Repository
public interface StateRepository extends JpaRepository<Status, Long> {

	Optional<Status> findByStatusDescritpion(String status);

}
