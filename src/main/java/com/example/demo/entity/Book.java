package com.example.demo.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 100)
	@Column(nullable = false)
	@Getter
	@Setter
	private String title;
	
	@Size(max = 4000)
	@Column(nullable = false)
	@Getter
	@Setter
	private String description;
	
	@Size(max = 10)
	@Column(nullable = false)
	@Getter
	@Setter
	private String publish_year;
	
	@Size(max = 100)
	@Column(nullable = false)
	@Getter
	@Setter
	private String author_name;

	@Size(max = 10)
	@Getter
	@Setter
	private String last_update;

	@Getter
	@Setter
	private int status = 1;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private long created_by;
}
