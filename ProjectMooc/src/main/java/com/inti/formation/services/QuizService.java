package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Quiz;
import com.inti.formation.iservices.IQuizService;
import com.inti.formation.repositories.IQuizRepository;
@Service
public class QuizService implements IQuizService {
	 @Autowired
		private IQuizRepository repo;
		
		
		@Override
		public Quiz saveOrUpdateQuiz(Quiz u) {
			// TODO Auto-generated method stub
			return repo.save(u);
		}

		@Override
		public void deleteByIdQuiz(Long id) {
			// TODO Auto-generated method stub
			 repo.deleteById(id);;
		}

		@Override
		public Quiz getByIdQuiz(Long id) {
			// TODO Auto-generated method stub
			return repo.findById(id).get();
		}

		@Override
		public List<Quiz> getAllQuiz() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}

	}



