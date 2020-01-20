package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Committee;
import com.inti.formation.iservices.ICommitteeService;
import com.inti.formation.repositories.ICommitteRepository;

@Service
public class CommitteeService implements ICommitteeService {
	
	@Autowired
	private ICommitteRepository repo;

	@Override
	public Committee saveOrUpdateCommittee(Committee c) {
		return repo.save(c);
	}

	@Override
	public void deleteCommittee(Long id) {
		repo.delete(repo.getOne(id));
	}

	@Override
	public Committee getByIdCommittee(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Committee> getAllCommittee() {
		return repo.findAll();
	}

	@Override
	public int getNbrOfMembersCommittee(Long idCommittee) {
		return repo.nbrOfMembers(idCommittee);
	}

}
