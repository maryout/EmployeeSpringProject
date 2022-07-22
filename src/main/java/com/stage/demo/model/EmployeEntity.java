package com.stage.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employe")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="Name")
	private String name;
	
	@Column(name="LastName")
	private String lastName;
	
	
	@Column(name="email")
	private String email;

	
    
	@ManyToOne
	@JoinColumn(name="post_id")
	private PostEntity post;
	
	
}
