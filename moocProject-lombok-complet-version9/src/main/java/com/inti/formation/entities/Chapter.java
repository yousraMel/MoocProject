package com.inti.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@ToString
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idChapter;
	private String objectives;
	private int numero;
	private String title;
	private String content;
	private String description;
	@OneToOne
	@JoinColumn(unique=true,nullable=true)
	private Quiz quiz;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	@OneToMany(mappedBy="chapter")
	private List<ChapterFile> chapterFiles;
	
	
}
