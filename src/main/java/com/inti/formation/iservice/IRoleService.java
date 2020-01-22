package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entites.Role;

 

public interface IRoleService {
	public Role saveOrUpdateRole(Role r);
	public void deleteRole (Long idRole);
	public Role getByIdRole(Long idRole);
	public List<Role> getAllRole();
	public Role findByRoleName(String roleName);
}
