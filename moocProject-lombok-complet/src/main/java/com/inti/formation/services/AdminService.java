package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Admin;
import com.inti.formation.iservices.IAdminService;
import com.inti.formation.repositories.IAdminRepository;
@Service
public class AdminService  implements IAdminService{
    
	@Autowired
	private IAdminRepository repo;
	
	@Override
	public Admin saveOrUpdateAdmin(Admin a) {
	 
		return repo.save(a);
	}

	@Override
	public void deleteAdmin(Long idAdmin) {
		 repo.deleteById(idAdmin);
		
	}

	@Override
	public Admin getByIdAdmin(Long idAdmin) {
	 
		return  repo.findById(idAdmin).get();
	}

	@Override
	public List<Admin> gettAllAdmin() {
	 
		return repo.findAll();
	}

}
