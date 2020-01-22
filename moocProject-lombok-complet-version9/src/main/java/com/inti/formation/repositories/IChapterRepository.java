package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Chapter;

public interface IChapterRepository extends JpaRepository<Chapter,Long>  {
	
	
	
	public List<Chapter> getChaptersByCourseIdCourse(Long id);

}
