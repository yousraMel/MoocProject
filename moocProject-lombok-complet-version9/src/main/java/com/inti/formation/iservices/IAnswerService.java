package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Answer;
import com.inti.formation.entities.Question;

public interface IAnswerService {
	Answer save(Answer answer);

	Answer find(Long id);

	Answer update(Answer newAnswer);

	void delete(Answer answer);

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}
