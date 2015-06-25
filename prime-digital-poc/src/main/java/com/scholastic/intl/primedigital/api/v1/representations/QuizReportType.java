package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;


@XmlRootElement(name="quizreportType")
@JsonRootName("quizreportType")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuizReportType {
	
	private Integer studentId;
	
	private List<ListQuizeType> lstquizTypes;
	private List<ListQuizeResultType> lstquizResultType;
	
	public List<ListQuizeType> getLstquizTypes() {
		
		if (lstquizTypes == null) {
			lstquizTypes = new ArrayList<ListQuizeType>();
		}
		
		return lstquizTypes;
	}
	
	public void setLstquizTypes(List<ListQuizeType> lstquizTypes) {
		this.lstquizTypes = lstquizTypes;
	}
	
	public List<ListQuizeResultType> getLstquizResultType() {
		
		if (lstquizResultType == null) {
			lstquizResultType = new ArrayList<ListQuizeResultType>();
		}
		return lstquizResultType;
	}
	
	public void setLstquizResultType(List<ListQuizeResultType> lstquizResultType) {
		this.lstquizResultType = lstquizResultType;
	}
	
	
	public void addLstquizTypes(ListQuizeType listQuizeType) {
		if (listQuizeType != null) {
			getLstquizTypes().add(listQuizeType);
		}
	}
	
	public void addListQuizeResultType(ListQuizeResultType lstQuizeResultType) {
		if (lstQuizeResultType != null) {
			getLstquizResultType().add(lstQuizeResultType);
		}
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
	
	
	
	

}
