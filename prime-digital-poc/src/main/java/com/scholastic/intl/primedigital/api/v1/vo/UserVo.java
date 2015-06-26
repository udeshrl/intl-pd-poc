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
	
	@XmlElement(name="first_name")
	@JsonProperty("first_name")
	private String first_name;
	
	@XmlElement(name="last_name")
	@JsonProperty("last_name")
	private String last_name;
	
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
