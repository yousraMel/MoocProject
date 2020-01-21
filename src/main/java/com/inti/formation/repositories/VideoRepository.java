package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
