package com.bluetree.indonesia.appointment.dto;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CityDto extends AbstractDto {
    
	private static final long serialVersionUID = 8651140927026087745L;

	@NotBlank
    @Length(max = 35)
    private String name;
    
    @NotBlank
    @Length(max = 20)
    private String district;
    
    @NotBlank
    @Valid
    private CountryDto countryDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public CountryDto getCountryDto() {
		return countryDto;
	}

	public void setCountryDto(CountryDto countryDto) {
		this.countryDto = countryDto;
	}

}
