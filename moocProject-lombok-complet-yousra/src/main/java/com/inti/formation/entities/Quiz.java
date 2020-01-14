package com.inti.formation.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@MappedSuperclass
public abstract class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuiz;
	@OneToMany(targetEntity = Question.class, fetch = FetchType.LAZY, mappedBy= "quiz",cascade = CascadeType.ALL)
	private List<Question> questions; 
	
	
	
}
