package com.inti.formation.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question")
public class Question  {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idQuastion;
	@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
//	@NotNull(message = "Question text not provided")
	private String text;

	@ManyToOne
	@JsonIgnore
	private Quiz quiz;

	@Column(name = "q_order")
	private Integer order;

	@JsonIgnore
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	@JsonIgnore
	@OneToOne
	private Answer correctAnswer;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;

	@JsonIgnore
	private Boolean isValid = false;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Long idQuastion,
			@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters") @NotNull(message = "Question text not provided") String text,
			Quiz quiz, Integer order, List<Answer> answers, Answer correctAnswer, Calendar createdDate,
			Boolean isValid) {
		super();
		this.idQuastion = idQuastion;
		this.text = text;
		this.quiz = quiz;
		this.order = order;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.createdDate = createdDate;
		this.isValid = isValid;
	}

	public Question(Long idQuastion,
			@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters") @NotNull(message = "Question text not provided") String text,
			Quiz quiz, Integer order) {
		super();
		this.idQuastion = idQuastion;
		this.text = text;
		this.quiz = quiz;
		this.order = order;
	}

	public Long getIdQuastion() {
		return idQuastion;
	}

	public void setIdQuastion(Long idQuastion) {
		this.idQuastion = idQuastion;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Question(
			@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters") @NotNull(message = "Question text not provided") String text,
			Integer order) {
		super();
		this.text = text;
		this.order = order;
	}

	public Question(Long idQuastion, Integer order) {
		super();
		this.idQuastion = idQuastion;
		this.order = order;
	}
	

	
}
