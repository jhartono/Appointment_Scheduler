package com.bluetree.indonesia.appointment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends AbstractEntity {

	private static final long serialVersionUID = 3714147804666735252L;

	@Column(name = "name", nullable = false, length = 35)
	private String name;

	@Column(name = "district", nullable = false, length = 20)
	private String district;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
