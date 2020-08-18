package com.user.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String firstname;
	
	private String middlename;
	
	private String lastname;
	
	public User(String firstname, String middlename,String lastname) {
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}
}
