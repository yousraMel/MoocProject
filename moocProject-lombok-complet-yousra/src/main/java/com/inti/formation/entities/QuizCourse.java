package com.inti.formation.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class QuizCourse extends Quiz{
	
	private String quizType;

}
