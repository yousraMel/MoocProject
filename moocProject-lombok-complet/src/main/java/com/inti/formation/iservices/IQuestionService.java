package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Answer;
import com.inti.formation.entities.Question;
import com.inti.formation.entities.Quiz;



public interface IQuestionService {
	Question save(Question question);

	Question find(Long id);

	List<Question> findQuestionsByQuiz(Quiz quiz);
	
	List<Question> findAllQuizes();

	List<Question> findValidQuestionsByQuiz(Quiz quiz);

	Question update(Question question);

	void delete(Question question);

	Boolean checkIsCorrectAnswer(Question question, Long answer_id);

	void setCorrectAnswer(Question question, Answer answer);

	Answer getCorrectAnswer(Question question);

	Answer addAnswerToQuestion(Answer answer, Question question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
}
