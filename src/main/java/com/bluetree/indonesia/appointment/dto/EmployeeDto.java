package com.bluetree.indonesia.appointment.dto;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class EmployeeDto extends AbstractDto {

	private static final long serialVersionUID = -1680482352009969848L;

	@Length(max = 25)
	private String externalId;

	@NotBlank
    @Length(max = 50)
	private String firstName;
	
    @Length(max = 50)
	private String middleName;
	
    @Length(max = 50)
	private String lastName;
	
    @Length(max = 45)
	private String phone;
	
    @Length(max = 45)
	private String mobile;
	
	@NotBlank
    @Length(max = 255)
	private String email;
	
	private boolean active = Boolean.TRUE;
	
	@NotBlank
	@Valid
	private LocationDto location;
	
	@Valid
    private List<TopicDto> topics;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	public List<TopicDto> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicDto> topics) {
		this.topics = topics;
	}
	
}
