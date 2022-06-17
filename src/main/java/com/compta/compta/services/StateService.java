package com.compta.compta.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.compta.compta.model.Status;
import com.compta.compta.repository.StateRepository;


@Service
public class StateService {
	private StateRepository stateRepository;

	public StateService(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}
	public List<Status> findAllStatus(){
		return stateRepository.findAll();
		
	}
	public void addStatus(String status){

		if ( ! stateRepository.findByStatusDescritpion(status).isPresent()) {

		stateRepository.save( new Status(status));}
		
	}
}
