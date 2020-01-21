package com.inti.formation.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organism extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @author fatima ezzahra zd
	 */
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long idOrganism;
	private String organismName;
	private String organismSpeciality;
	private String organismDocumentation;
	private String turnover;
	private String phoneNumber;
	private String webSite;
	@Embedded
	private Address address;
	private String organismState;
	
}

