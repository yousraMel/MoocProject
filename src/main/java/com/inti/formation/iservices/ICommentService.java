package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Comment;

public interface ICommentService {
	
	public Comment saveOrUpdateComment(Comment c);
	public void deleteComment(Long id);
	public Comment getByIdComment(Long id);
	public List<Comment> getAllComment();

}
