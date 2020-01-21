package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Role;

public interface IRoleService {
	
	public Role saveOrUpdateRole(Role role);
	public void deleteRole (Long idRole);
	public Role getByIdRole(Long idRole);
	public List<Role> getAllRoles();
	public Role findByRoleName(String roleName);
}
