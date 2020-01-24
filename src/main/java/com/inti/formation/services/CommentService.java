package com.inti.formation.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Comment;
import com.inti.formation.iservices.ICommentService;
import com.inti.formation.repositories.ICommentRepository;

@Service

public class CommentService implements ICommentService {
	
	@Autowired
	private ICommentRepository repo;
	
	@Override
	public Comment saveOrUpdateComment(Comment c) {
		return repo.save(c);
	}

	@Override
	public void deleteComment(Long id) {
		repo.delete(repo.getOne(id));
	}

	@Override
	public Comment getByIdComment(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Comment> getAllComment() {
		return repo.findAll();
	}

}
