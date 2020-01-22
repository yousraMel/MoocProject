package com.inti.formation.entites;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourse;
	private String title;
	@JsonFormat( shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private   Date createDate;
 	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date updateDate;
	private String level;
	private String duration;
	private String keyWords;
	private String description;
	private String state;
	private String objectives;
	private double note;
	private boolean free;
	private String language;
  	@OneToMany(mappedBy= "course")
 	 private List<Chapter>chapters;
  

}
