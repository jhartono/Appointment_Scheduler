package com.bluetree.indonesia.appointment.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CountryDto extends AbstractDto {
    
	private static final long serialVersionUID = -634331284022322679L;

	@NotBlank
    @Length(max = 3)
    private String code;
    
    @NotBlank
    @Length(max = 52)
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
