package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Image;

public interface IFileRepository extends JpaRepository<Image, Long> {
}
