package com.inti.formation.entities;

import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@EqualsAndHashCode(callSuper = false)
public class Committee extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idCommittee;
	private String committeeName;
	@OneToMany(mappedBy ="committee")
	private List<Trainer> trainers;
	@OneToMany(mappedBy="committee")
	private List<Category> categories;
}
