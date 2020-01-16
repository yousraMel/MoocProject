package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Choice;

public interface IAnswerService {
	public Choice saveOrUpdateAnswer(Choice u);
	public void deleteByIdAnswer(Long id);
	public Choice getByIdAnswer(Long id);
	public List<Choice> getAllAnswer();
}
