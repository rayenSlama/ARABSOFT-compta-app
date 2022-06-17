package com.compta.compta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.compta.compta.model.User;
@CrossOrigin("*")
@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findByCode(Long code);
	Boolean existsByUsername(String username);
	Boolean existsByCode(Long code);
	Boolean existsByEmail(String email);
	
	/* @RestResource(path = "/byName")
		public List<User> findByUsername1(@Param("des") String des);*/
	 @RestResource(path = "/byEmail")
		public List<User> findByEmail(@Param("email") String email);
	 @RestResource(path = "/byAdresse")
		public List<User> findByAdresse(@Param("adresse") String adresse);
		
	 @RestResource(path = "/byTelephone")
		public List<User> findByTelephone(@Param("tel") String tel);
	
	 Optional<User> findById(long id);

}
