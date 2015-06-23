package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "classtype")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCalssType {
	
	private List<ClassType> classType;

	public List<ClassType> getClassType() {
		if (classType == null) {
			classType = new ArrayList<ClassType>();
		}
		return classType;
	}
	
	public void addClassType(ClassType classType) {
		if (classType != null) {
			getClassType().add(classType);
		}
	}

	public void setClassType(List<ClassType> classType) {
		this.classType = classType;
	}
	
	

}
