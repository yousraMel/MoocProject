package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Badge;

public interface IBadgeRepository extends JpaRepository<Badge, Long> {

}
