package com.bluetree.indonesia.appointment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic extends AbstractAuditableEntity {
	
	private static final long serialVersionUID = -8111264709641685701L;
	
	@Column(name = "text", nullable = false, length = 100)
	private String text;
	
	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "active")
	private boolean active = Boolean.TRUE;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
