package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="listquizreportType")
@JsonRootName("listquizreportType")
@XmlAccessorType(XmlAccessType.FIELD)
public class LstQuizReportType {
	
	//private Integer studenId;
	
	private List<QuizReportType> quizeReportType;

	public List<QuizReportType> getQuizeReportType() {
		if (quizeReportType == null) {
			quizeReportType = new ArrayList<QuizReportType>();
		}
		return quizeReportType;
		
	}

	public void setQuizeReportType(List<QuizReportType> quizeReportType) {
		this.quizeReportType = quizeReportType;
	}
	
	public void addQuizReportType(QuizReportType quizReportType) {
		if (quizReportType != null) {
			getQuizeReportType().add(quizReportType);
		}
	}

	
	
	

}
