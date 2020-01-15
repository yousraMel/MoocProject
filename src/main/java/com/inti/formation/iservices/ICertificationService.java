package com.inti.formation.iservices;

import java.util.List;
import java.util.Optional;

import com.inti.formation.entities.Certification;

public interface ICertificationService {
	
	public Certification saveOrUpdateCertification(Certification c);
	public void deleteCertification(Long id);
	public Certification getByIdCertification(Long id);
	public List<Certification> getAllCertification();

}
