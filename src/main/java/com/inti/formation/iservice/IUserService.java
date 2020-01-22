package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entites.User;

public interface IUserService {
public User saveOrUpdateUser(User u);
public void deleteUser(Long id);
public User getByIdUser(Long id);
public List<User> getAllUser();


}
