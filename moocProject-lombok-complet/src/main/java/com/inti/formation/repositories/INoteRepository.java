package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.Note;

public interface INoteRepository extends JpaRepository<Note, Long> {
	
	List<Note> findByCourse(Course course);
	
	 @Query(value="SELECT COUNT(note) FROM note WHERE course=:x",nativeQuery=true)
	 int nbrOfNotesByCourse(@Param("x") Course course);

}
