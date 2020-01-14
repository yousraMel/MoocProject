package com.inti.formation.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class QuizChapter extends Quiz{
	
	private String quizType;

}
