package com.inti.formation.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String mail;
	private String password;
	private String passwordConfirm;
	@ManyToMany
	@JsonIgnore
	private Set<Role> roles;
	public User(Long idUser, String mail, String password, String passwordConfirm) {
		super();
		this.idUser = idUser;
		this.mail = mail;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	

}
