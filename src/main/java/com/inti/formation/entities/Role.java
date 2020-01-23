package com.inti.formation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "role")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String roleName;

}