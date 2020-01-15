package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTrainer;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern ="yyyy-mm-dd")
	private Date dateOfBirth;
	private String mail;
	private String password;
	private int phoneNumber;
	@Embedded
	private Address address;
	private String cv;
	private int nbrOfCourses;
	private String specialiy;
	private String diploma;
	private String experience;
	private String gender;
	private String trainerState;
	

	
	
	

}
