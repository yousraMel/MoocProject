package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
