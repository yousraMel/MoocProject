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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inti.formation.enumeration.AccountType;
import com.inti.formation.enumeration.CourseState;
import com.inti.formation.enumeration.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourse;
	private String title;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	@Enumerated(EnumType.STRING)
	private Level level;
	private String duration;
	private String keyWords;
	private String description;
	@Enumerated(EnumType.STRING)
	private CourseState state; 
	private String objectives;
	private double courseNote;
	private AccountType accountType;
	private String language;
	@OneToOne
	@JoinColumn(unique=true,nullable=true)
	@JsonIgnore
	private Quiz quiz;
	@OneToMany
//	(targetEntity = Chapter.class, fetch = FetchType.LAZY, mappedBy= "course")
	@JsonIgnore
	private List<Chapter> chapters;
	@OneToOne
	
	@JsonIgnore
	private CourseFile courseFiles;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Long idCourse, String title, Date createDate, Date updateDate, Level level, String duration,
			String keyWords, String description, CourseState state, String objectives, double courseNote,
			AccountType accountType, String language, Quiz quiz, List<Chapter> chapters, CourseFile courseFiles) {
		super();
		this.idCourse = idCourse;
		this.title = title;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.level = level;
		this.duration = duration;
		this.keyWords = keyWords;
		this.description = description;
		this.state = state;
		this.objectives = objectives;
		this.courseNote = courseNote;
		this.accountType = accountType;
		this.language = language;
		this.quiz = quiz;
		this.chapters = chapters;
		this.courseFiles = courseFiles;
	}
	
	
	public Course(String keyWords, String description, List<Chapter> chapters) {
		super();
		this.keyWords = keyWords;
		this.description = description;
		this.chapters = chapters;
	}
	public Long getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseState getState() {
		return state;
	}
	public void setState(CourseState state) {
		this.state = state;
	}
	public String getObjectives() {
		return objectives;
	}
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	public double getCourseNote() {
		return courseNote;
	}
	public void setCourseNote(double courseNote) {
		this.courseNote = courseNote;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	public CourseFile getCourseFiles() {
		return courseFiles;
	}
	public void setCourseFiles(CourseFile courseFiles) {
		this.courseFiles = courseFiles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Course(String title, Date createDate, Date updateDate, String duration, String keyWords, String description,
			String objectives, double courseNote) {
		super();
		this.title = title;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.duration = duration;
		this.keyWords = keyWords;
		this.description = description;
		this.objectives = objectives;
		this.courseNote = courseNote;
	}
	
	
	
	
	
}
