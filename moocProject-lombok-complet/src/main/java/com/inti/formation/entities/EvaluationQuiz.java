package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluation_quiz")
//@AssociationOverrides({
//		@AssociationOverride(name = "primaryKey.quiz", joinColumns = @JoinColumn(name = "quiz_id")),
//		@AssociationOverride(name = "primaryKey.learner", joinColumns = @JoinColumn(name = "learner_id")) })
public class EvaluationQuiz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	private Long idEvaluationQuiz;
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "quiz_id")  
	private Quiz quiz;
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "learner_id")  
	private Learner learner;
	private double score;
	

//	@EmbeddedId
//	private EvaluationQuizId primaryKey = new EvaluationQuizId();
//	private double score;
//
//	@Transient
//	public Learner getLearner() {
//		return getPrimaryKey().getLearner();
//	}
//
//	public void setLearner(Learner learner) {
//		getPrimaryKey().setLearner(learner);
//	}
//
//	@Transient
//	public Quiz getQuiz() {
//		return getPrimaryKey().getQuiz();
//	}
//
//	public void setQuiz(Quiz quiz) {
//		getPrimaryKey().setQuiz(quiz);
//	}
}
