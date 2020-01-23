package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Certification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCertification;
	private String title;

	@CreationTimestamp
	@JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date creationDate;
	@ManyToOne
	@JoinColumn(name = "idLearner")
	private Learner learner;
	@OneToOne
	@JoinColumn(name = "idCourse")
	@JsonIgnore
	private Course course;


}
