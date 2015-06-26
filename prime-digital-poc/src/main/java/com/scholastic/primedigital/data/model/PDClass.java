package com.scholastic.primedigital.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="classes")
@NamedQueries({ 
	@NamedQuery(name = PDClass.QUERY_ALL, 
			query = "SELECT PDC FROM PDClass PDC WHERE PDC.teacher.id= :teacherId ")
		
})
public class PDClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String QUERY_ALL = "pDClass.getTeacherClass";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="class_name",length = 20)
	private String className;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private  User teacher; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "calss_students",
			joinColumns={@JoinColumn(name = "student_id", referencedColumnName = "id")},
			inverseJoinColumns={@JoinColumn(name = "class_id", referencedColumnName = "id")})
	@BatchSize(size = 40)
	private List<User> studentUser = new ArrayList<User>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public List<User> getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(List<User> studentUser) {
		this.studentUser = studentUser;
	}
	
	
	

}
