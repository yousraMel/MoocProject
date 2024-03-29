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
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "idLearner")
	private Learner learner;

}
