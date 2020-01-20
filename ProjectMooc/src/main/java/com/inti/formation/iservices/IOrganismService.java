package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Image;
import com.inti.formation.entities.Organism;

public interface IOrganismService {
	public Organism saveOrUpdateOrganism(Organism u);
	public void deleteByIdOrganism(Long id);
	public Organism getByIdOrganism(Long id);
	public List<Organism> getAllOrganism();
	 public void mergeNewImages(Long id, List<Image> imageList);
	  
}
