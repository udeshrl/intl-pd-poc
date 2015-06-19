package com.scholastic.intl.primedigital.api.v1.representations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name="user_list")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class ListUserType {
	private List<UserType> userTypes;

	public List<UserType> getUserTypes() {
		if (userTypes == null) {
			userTypes = new ArrayList<UserType>();
		}
		return userTypes;
	}
	
	public void addUserType(UserType userType) {
		if (userType != null) {
			getUserTypes().add(userType);
		}
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	} 
	

}
