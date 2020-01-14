package com.inti.formation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private Long idCourse;
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
	@OneToOne
	@JoinColumn(unique=true,nullable=true)
	private QuizCourse quiz;
	@OneToMany(targetEntity = Chapter.class, fetch = FetchType.LAZY, mappedBy= "course",cascade = CascadeType.ALL)
	private List<Chapter> chapters;
	
}
