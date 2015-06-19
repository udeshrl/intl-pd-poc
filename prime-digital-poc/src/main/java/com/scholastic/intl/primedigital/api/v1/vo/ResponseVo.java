package com.scholastic.intl.primedigital.api.v1.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.scholastic.intl.api.primedigital.constants.PrimeDigitalConstants;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = PrimeDigitalConstants.RESULT)
public class ResponseVo {
	
	/** The message attribute */
	@XmlElement
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
