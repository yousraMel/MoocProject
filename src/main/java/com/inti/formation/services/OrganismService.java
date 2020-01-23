package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Image;
import com.inti.formation.entities.Organism;
import com.inti.formation.exeptions.BadRequestHandler;
import com.inti.formation.iservices.IOrganismService;
import com.inti.formation.repositories.IOrganismRepository;

@Service
public class OrganismService implements IOrganismService {
	@Autowired
	private IOrganismRepository repo;

	@Override
	public Organism saveOrUpdateOrganism(Organism u) {
		return repo.save(u);
	}

	@Override
	public void deleteByIdOrganism(Long id) {
		repo.deleteById(id);

	}

	@Override
	public Organism getByIdOrganism(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Organism> getAllOrganism() {
		return repo.findAll();
	}

	@Override
	public List<Organism> findByOrganismState(String organismState) {
		return repo.findByOrganismState(organismState);
	}

	@Override
	public void mergeNewImages(Long id, List<Image> imageList) {
		 if (id == 0 || imageList == null)
	            throw new BadRequestHandler("No valid auction id or Image list provided!");

	        Organism organism = getByIdOrganism(id);
	        organism.setImages(imageList);
	        saveOrUpdateOrganism(organism);		
	}

}
