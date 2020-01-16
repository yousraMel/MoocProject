package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Admin;

public interface IAdminService {
public Admin saveOrUpdateAdmin(Admin a);
public  void deleteAdmin(Long idAdmin);
public Admin getByIdAdmin(Long idAdmin);
public List<Admin> gettAllAdmin();

}
