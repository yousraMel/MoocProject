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
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Progress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProgress;
	@ManyToOne
	@JoinColumn(name = "learner_id")
	private Learner learner;
	@ManyToOne
	@JoinColumn(name = "course")
	private Course course;
	private int state;

}
