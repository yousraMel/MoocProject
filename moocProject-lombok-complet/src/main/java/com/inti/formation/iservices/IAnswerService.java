package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Answer;

public interface IAnswerService {
	public Answer saveOrUpdateAnswer(Answer u);
	public void deleteByIdAnswer(Long id);
	public Answer getByIdAnswer(Long id);
	public List<Answer> getAllAnswer();
}
