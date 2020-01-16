package com.inti.formation.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inti.formation.enumeration.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Learner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLearner;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String email;
	private String password;
	private String country;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@OneToMany(mappedBy = "learner")
	private Set<EvaluationQuiz> evaluationQuizs = new HashSet<EvaluationQuiz>();
	@OneToOne
	@JoinColumn(name= "choice_id")
	private Choice choice;

}
