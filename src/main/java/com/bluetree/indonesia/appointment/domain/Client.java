package com.bluetree.indonesia.appointment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends AbstractAuditableEntity {
	
	private static final long serialVersionUID = -484066184555651120L;

	@Column(name = "external_id", length = 25)
	private String externalId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "middle_name", length = 50)
	private String middleName;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "phone", length = 45)
	private String phone;
	
	@Column(name = "mobile", length = 45)
	private String mobile;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "active")
	private boolean active = Boolean.TRUE;

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
	
}
