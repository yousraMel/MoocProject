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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBadge;
	private String description;
	@ManyToOne
	@JoinColumn(name = "learner_id")
	private Learner learner;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
}
