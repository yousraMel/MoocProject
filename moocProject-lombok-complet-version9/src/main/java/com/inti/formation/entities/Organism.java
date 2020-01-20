package com.inti.formation.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organism {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrganism;
	private String organismName;
	private String organismSpeciality;
	private String organismDocumentation;
	private String turnover;
	private String email;
	private String phoneNumber;
	private String webSite;
	private String password;
	@Embedded
	private Address address;
	@OneToMany(mappedBy="organism")

	private List<Image> images;
	
}
