package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Choice;
import com.inti.formation.iservices.IAnswerService;
import com.inti.formation.repositories.IAnswerRepository;
@Service
public class AnswerService implements IAnswerService{
	 @Autowired
		private IAnswerRepository repo;
		
		
		@Override
		public Choice saveOrUpdateAnswer(Choice u) {
			// TODO Auto-generated method stub
			return repo.save(u);
		}

		@Override
		public void deleteByIdAnswer(Long id) {
			// TODO Auto-generated method stub
			 repo.deleteById(id);;
		}

		@Override
		public Choice getByIdAnswer(Long id) {
			// TODO Auto-generated method stub
			return repo.findById(id).get();
		}

		@Override
		public List<Choice> getAllAnswer() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}

	}



