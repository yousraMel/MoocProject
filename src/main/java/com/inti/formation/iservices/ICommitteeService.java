package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Committee;

public interface ICommitteeService {
	
	public Committee saveOrUpdateCommittee(Committee c);
	public void deleteCommittee(Long id);
	public Committee getByIdCommittee(Long id);
	public List<Committee> getAllCommittee();

}
