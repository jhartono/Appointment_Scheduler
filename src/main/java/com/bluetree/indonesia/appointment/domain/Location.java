package com.bluetree.indonesia.appointment.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "location")
public class Location extends AbstractAuditableEntity {

	private static final long serialVersionUID = 1589076921346096403L;

	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "address1", nullable = false, length = 45)
	private String address1;
	
	@Column(name = "address2", length = 45)
	private String address2;
	
	@Column(name = "address3", length = 45)
	private String address3;
	
	@Column(name = "city", nullable = false, length = 100)
	private String city;
	
	@Column(name = "state", nullable = false, length = 100)
	private String state;
	
	@Column(name = "country", nullable = false, length = 100)
	private String country;
	
	@Column(name = "zipcode", nullable = false, length = 10)
	private String zipCode;
	
	@Column(name = "latitude")
	private BigDecimal latitude;
	
	@Column(name = "longitude")
	private BigDecimal longitude;
	
	@Column(name = "phone", length = 45)
	private String phone;
	
	@Column(name = "fax", length = 45)
	private String fax;
	
	@Column(name = "email", length = 255)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "location_topic", 
		joinColumns = @JoinColumn(name = "location_id"), 
		inverseJoinColumns = @JoinColumn(name = "topic_id")
	)
	private Set<Topic> topics = new HashSet<Topic>();

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

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	} 
	
}
