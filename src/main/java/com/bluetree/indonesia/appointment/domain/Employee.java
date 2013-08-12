package com.bluetree.indonesia.appointment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends AbstractAuditableEntity {

	private static final long serialVersionUID = -5770204892454464508L;
	
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
	
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_topic", 
		joinColumns = @JoinColumn(name = "employee_id"), 
		inverseJoinColumns = @JoinColumn(name = "topic_id")
	)
	private Set<Topic> topics = new HashSet<Topic>();

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

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}
