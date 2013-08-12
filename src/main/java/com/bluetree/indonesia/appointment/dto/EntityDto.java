package com.bluetree.indonesia.appointment.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public final class EntityDto implements Serializable {

	private static final long serialVersionUID = 8167917594126713847L;
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}
