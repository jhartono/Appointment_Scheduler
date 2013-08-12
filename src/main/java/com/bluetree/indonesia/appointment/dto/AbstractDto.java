package com.bluetree.indonesia.appointment.dto;

import java.io.Serializable;

public class AbstractDto implements Serializable {

	private static final long serialVersionUID = -8866237841476695337L;

	private Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
