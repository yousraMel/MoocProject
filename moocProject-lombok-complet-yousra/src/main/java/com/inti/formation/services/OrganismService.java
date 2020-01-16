package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Organism;
import com.inti.formation.iservices.IOrganismService;
import com.inti.formation.repositories.IOrganismRepository;

@Service
public class OrganismService implements IOrganismService {
	@Autowired
	private IOrganismRepository repo;

	@Override
	public Organism saveOrUpdateOrganism(Organism u) {
		// TODO Auto-generated method stub
		return repo.save(u);
	}

	@Override
	public void deleteByIdOrganism(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		;
	}

	@Override
	public Organism getByIdOrganism(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Organism> getAllOrganism() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
