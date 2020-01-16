package com.inti.formation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Choice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAnswer;
	private String answerContent;
	private Boolean state;
	@ManyToOne
	@JoinColumn(name= "choice_id")
	private Question question;
	
	

}
