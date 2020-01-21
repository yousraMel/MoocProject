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
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Avatar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvatar;
	@OneToOne
	@JoinColumn(name = "learner_id")
	private Learner learner;

}
