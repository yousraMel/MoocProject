package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
