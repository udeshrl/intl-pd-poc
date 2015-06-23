package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "classes")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassType {
	
	private Integer id;
	private String name;
	
	private List<UserType> students = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserType> getStudents() {
		if (students == null) {
			students = new ArrayList<UserType>();
		}
		return students;
	}
	
	public void addUserType(UserType userType) {
		if (userType != null) {
			 getStudents().add(userType);
		}
	}

	public void setStudents(List<UserType> students) {
		this.students = students;
	}
	
	

}
