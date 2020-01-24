package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Assignment;
import com.inti.formation.iservices.IAssignmentService;
import com.inti.formation.repositories.IAssignmentRepository;

@Service
public class AssignmentService implements IAssignmentService {

	@Autowired
	private IAssignmentRepository repo;

	@Override
	public Assignment saveOrUpdateAssignment(Assignment assignment) {
		return repo.save(assignment);
	}

	@Override
	public void deleteAssignment(Long idAssignment) {
		repo.deleteById(idAssignment);
		
	}

	@Override
	public Assignment getByIdAssignment(Long idAssignment) {
		return repo.findById(idAssignment).get();
	}

	@Override
	public List<Assignment> getAllAssignment() {
		return repo.findAll();
	}

}