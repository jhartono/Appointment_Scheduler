package com.bluetree.indonesia.appointment.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class LocationDto extends AbstractDto {

	private static final long serialVersionUID = 2716112550565032879L;

	@NotBlank
	@Length(max = 100)
	private String name;
	
	@Length(max = 100)
	private String description;
	
	@NotBlank
	@Length(max = 45)
	private String address1;
	
	@Length(max = 45)
	private String address2;
	
	@Length(max = 45)
	private String address3;
	
	@NotBlank
	@Length(max = 100)
	private String city;
	
	@NotBlank
	@Length(max = 100)
	private String state;
	
	@NotBlank
	@Length(max = 100)
	private String country;
	
	@NotBlank
	@Length(max = 10)
	private String zipCode;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	@Length(max = 45)
	private String phone;
	
	@Length(max = 45)
	private String fax;
	
	@Length(max = 255)
	private String email;
	
	private Date startDate;
	
	private Date endDate;
	
	@Valid
    private List<TopicDto> topics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<TopicDto> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicDto> topics) {
		this.topics = topics;
	}
}
