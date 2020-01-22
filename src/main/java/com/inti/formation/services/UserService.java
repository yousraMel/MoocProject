package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entites.User;

import com.inti.formation.iservice.IUserService;
import com.inti.formation.repositories.IUserRepository;
@Service
public class UserService implements IUserService {
	@Autowired
	private IUserRepository repo;

	@Override
	public User saveOrUpdateUser(User u) {

		return repo.save(u);
	}

	@Override
	public void deleteUser(Long idUser) {
		repo.deleteById(idUser);

	}

	@Override
	public User getByIdUser(Long idUser) {
		 
		return repo.findById(idUser).get();
	}

	@Override
	public List<User> getAllUser() {
		 
		return repo.findAll() ;
	}

}
