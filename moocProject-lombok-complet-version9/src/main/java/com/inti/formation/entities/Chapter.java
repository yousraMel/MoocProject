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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

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
	@JsonIgnore
	private Quiz quiz;
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;
	@OneToMany(mappedBy="chapter")
	@JsonIgnore
	private List<ChapterFile> chapterFiles;
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Chapter(String title, String content, String description, Course course) {
		super();
		this.title = title;
		this.content = content;
		this.description = description;
		this.course = course;
	}


	public Chapter(String title, String content, String description) {
		super();
		this.title = title;
		this.content = content;
		this.description = description;
	}


	public Chapter(Long idChapter, String objectives, int numero, String title, String content, String description,
			Quiz quiz, Course course, List<ChapterFile> chapterFiles) {
		super();
		this.idChapter = idChapter;
		this.objectives = objectives;
		this.numero = numero;
		this.title = title;
		this.content = content;
		this.description = description;
		this.quiz = quiz;
		this.course = course;
		this.chapterFiles = chapterFiles;
	}
	public Long getIdChapter() {
		return idChapter;
	}
	public void setIdChapter(Long idChapter) {
		this.idChapter = idChapter;
	}
	public String getObjectives() {
		return objectives;
	}
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<ChapterFile> getChapterFiles() {
		return chapterFiles;
	}
	public void setChapterFiles(List<ChapterFile> chapterFiles) {
		this.chapterFiles = chapterFiles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
