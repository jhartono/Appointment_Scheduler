package com.bluetree.indonesia.appointment.command;

import java.io.Serializable;

public class SearchLocationFormCommand implements Serializable {

	private static final long serialVersionUID = -1471825232303481338L;

	private String zipCode;
	private String locality;
	private int counter = 0;
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
