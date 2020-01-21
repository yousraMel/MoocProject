package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.User;

public interface IUserService {
public User saveOrUpdateUser(User a);
public  void deleteUser(Long idAdmin);
public User getByIdUser(Long idAdmin);
public List<User> gettAllUser();
public User login(String email, String password);

}
