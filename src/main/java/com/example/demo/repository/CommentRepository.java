package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
