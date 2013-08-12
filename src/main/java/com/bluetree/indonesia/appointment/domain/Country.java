package com.bluetree.indonesia.appointment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country extends AbstractEntity {

	private static final long serialVersionUID = -3422162661605501781L;

	@Column(name = "code", nullable = false, length = 3)
	private String code;

	@Column(name = "name", nullable = false, length = 52)
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
