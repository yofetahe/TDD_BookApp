package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Comment;

public interface CommentService {

	public Comment addCommentByBookId(Comment comment);
	public Comment updateComment(Comment comment);
	public Comment getCommentById(Long id);

}
