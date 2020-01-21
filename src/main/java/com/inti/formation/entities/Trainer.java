package com.inti.formation.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.inti.formation.enumeration.Gender;
import com.inti.formation.enumeration.TrainerState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainer extends User {
	
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long idTrainer;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern ="yyyy-mm-dd")
	private Date dateOfBirth;
//	private String email;
//	private String password;
	private int phoneNumber;
//	@Embedded
//	private Address address;
	private String cv;
	private int nbrOfCourses;
	private String specialiy;
	private String experience;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private TrainerState trainerState = TrainerState.notYetValidated;
	@ManyToOne
	@JoinColumn(name="committee_id")
	private Committee committee;
	
	
	public Trainer(Long id, String email, String password, String passwordConfirm, Set<Role> roles, String firstName,
			String lastName, Date dateOfBirth, int phoneNumber, String specialiy, String experience, Gender gender,
			TrainerState trainerState) {
		super(id, email, password, passwordConfirm, roles);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.specialiy = specialiy;
		this.experience = experience;
		this.gender = gender;
		this.trainerState = trainerState;
	}
	

	
	
	

}
