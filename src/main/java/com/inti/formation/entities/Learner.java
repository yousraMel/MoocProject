package com.inti.formation.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inti.formation.enumeration.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper =false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name ="id")
public class Learner extends User{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idLearner;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
//	private String email;
//	private String password;
	private String country;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType = AccountType.FREE;
	@OneToMany(mappedBy = "learner")
	private Set<EvaluationQuiz> evaluationQuizs = new HashSet<EvaluationQuiz>();
	@OneToOne
	@JoinColumn(name= "choice_id")
	private Answer choice;
	
	@JsonIgnore
	@OneToMany(mappedBy = "learner")
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "learner")
	private List<Badge> badges;
	
	@JsonIgnore
	@OneToMany(mappedBy = "learner")
	private List<Certification> certifications;
	
	@JsonIgnore
	@OneToMany(mappedBy = "learner")
	private List<Avatar> avatars;

	


}
