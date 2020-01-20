package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Chapter;

public interface IChapterRepository extends JpaRepository<Chapter,Long>  {

}
