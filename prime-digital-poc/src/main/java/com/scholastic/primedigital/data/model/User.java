package com.scholastic.primedigital.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * @author dora.babu
 *
 */
@Entity
@Table(name = "users",uniqueConstraints=@UniqueConstraint(columnNames={"user_name"}))
@NamedQueries({ 
	@NamedQuery(name = User.QUERY_FIND_USER, 
			query = "SELECT uN FROM User uN WHERE uN.userName = :userName")
		
})
public class User  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public final static String QUERY_FIND_USER = "user.findUser";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name", length = 255)
	private String first_name;
	
	@Column(name = "last_name", length = 255)
	private String last_name;
	
	@Column(name = "role", length = 255)
	private String role;
	
	@Column(name = "user_name",length = 255)
	private String userName;
	
	@Column(name = "password",length = 255)
	private String password;
	
	@Column(name = "email",length = 255)
	private String email;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
