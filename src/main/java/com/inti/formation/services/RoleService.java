package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entites.Role;
import com.inti.formation.iservice.IRoleService;
import com.inti.formation.repositories.IRoleRepository;
@Service
public class RoleService implements IRoleService {
@Autowired
private IRoleRepository repo;

@Override
public Role saveOrUpdateRole(Role r) {
	 
	return repo.save(r);
}

@Override
public void deleteRole(Long idRole) {
	 repo.delete(repo.getOne(idRole));
	
}

@Override
public Role getByIdRole(Long idRole) {
	 
	return repo.findById(idRole).get() ;
}

@Override
public List<Role> getAllRole() {
	 
	return repo.findAll();
}

@Override
public Role findByRoleName(String roleName) {
	 
	return  repo.findByRoleName(roleName);
}
	 
}
