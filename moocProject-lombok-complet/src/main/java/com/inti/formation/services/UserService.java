package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.User;
import com.inti.formation.iservices.IUserService;
import com.inti.formation.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repo;

	@Override
	public User saveOrUpdateUser(User a) {
return repo.save(a);
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
	public List<User> gettAllUser() {
		return repo.findAll();
	}

	@Override
	public User login(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

}
