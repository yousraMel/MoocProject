package com.inti.formation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Note {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idNote;
	 @OneToOne
	 @JoinColumn(unique=true,nullable=true)  
	private Learner learner;
	 @OneToOne
	 @JoinColumn(unique=true,nullable=true)  
	private Course course;
	
	private double note;
	

}
