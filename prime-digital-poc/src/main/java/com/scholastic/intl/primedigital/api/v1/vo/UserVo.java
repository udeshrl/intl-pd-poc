package com.scholastic.intl.primedigital.api.v1.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.scholastic.intl.api.primedigital.constants.PrimeDigitalConstants;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = PrimeDigitalConstants.USER)
public class UserVo {
	
	@XmlElement(name="user_name")
	@JsonProperty("user_name")
	private String user_name;
	
	@XmlElement(name="password")
	@JsonProperty("password")
	private String password;
	
	@XmlElement(name="id")
	@JsonProperty("id")
	private Integer id;
	
	@XmlElement(name="fristName")
	@JsonProperty("fristName")
	private String fristName;
	
	@XmlElement(name="lastName")
	@JsonProperty("lastName")
	private String lastName;
	
	@XmlElement(name="role")
	@JsonProperty("role")
	private String role;
	
	@XmlElement(name="email")
	@JsonProperty("email")
	private String email;

	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	
	
	
	

}
