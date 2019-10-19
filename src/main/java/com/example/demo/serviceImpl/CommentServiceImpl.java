package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public Comment addCommentByBookId(Comment comment) {
		return commentRepository.save(comment);		
	}

	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);	
	}

	public Comment getCommentById(Long id) {
		Optional<Comment> op = commentRepository.findById(id);
		
		if(op != null) {
			return op.get();
		}
		
		return new Comment();
	}

}
