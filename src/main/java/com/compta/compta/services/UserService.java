package com.compta.compta.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.compta.compta.repository.UserRepository;
import com.compta.compta.exception.ResourceNotFoundException;
import com.compta.compta.model.User;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;


	public void updateUserStatus(long id, boolean isActive) throws ResourceNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		user.setActive(isActive);
		userRepository.save(user);

	}
}
