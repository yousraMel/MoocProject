package com.inti.formation.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inti.formation.enumeration.QuestionState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;
	private int numero;
	private String content;
	private String answer;
	@Enumerated(EnumType.STRING)
	private QuestionState questionState;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm:ss")
	private Date chrono;
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
}
