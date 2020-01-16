package com.inti.formation.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuiz;
	@OneToMany(targetEntity = Question.class, fetch = FetchType.LAZY, mappedBy= "quiz",cascade = CascadeType.ALL)
	private List<Question> questions; 
	
	@OneToMany(targetEntity = EvaluationQuiz.class, fetch = FetchType.LAZY, mappedBy= "quiz",cascade = CascadeType.ALL)
	private Set<EvaluationQuiz> evaluationQuizs = new HashSet<EvaluationQuiz>();
	
	
}
