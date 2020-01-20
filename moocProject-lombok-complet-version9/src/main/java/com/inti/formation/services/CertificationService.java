package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Certification;
import com.inti.formation.iservices.ICertificationService;
import com.inti.formation.repositories.ICertificationRepository;

@Service
public class CertificationService implements ICertificationService {
	
	@Autowired
	private ICertificationRepository repo;

	@Override
	public Certification saveOrUpdateCertification(Certification c) {
		return repo.save(c);
	}

	@Override
	public void deleteCertification(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Certification getByIdCertification(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Certification> getAllCertification() {
		return repo.findAll();
	}

}
