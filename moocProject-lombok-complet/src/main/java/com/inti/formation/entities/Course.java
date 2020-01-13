package com.inti.formation.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inti.formation.enumeration.AccountType;
import com.inti.formation.enumeration.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CourseId;
	private String title;
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createDate;
	@JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date updateDate;
	 @Enumerated(EnumType.STRING)
	private Level level;
	private String duration;
	private String keyWords;
	private String description;
	private String state;
	private String objectives;
	private double note;
	private AccountType accountType;
	private String language;
	
}
