package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entites.User;

public interface IUserRepository extends JpaRepository <User,Long> {

}
