/**
 * 
 */
package com.hoc.motobox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.hoc.motobox.utils.SuperEntity;

/**
 * @author adminHOC
 *
 */
@Entity
public class Message extends SuperEntity {
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "content",nullable = true, length = 200)
	private String content;
	

	public String getContent() {
		return content;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
