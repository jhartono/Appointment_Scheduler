package com.bluetree.indonesia.appointment.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class TopicDto extends AbstractDto {

    private static final long serialVersionUID = -3125192612900314492L;
    
    @NotBlank
    @Length(max = 100)
    private String text;
    
    @Length(max = 255)
    private String description;
    
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
