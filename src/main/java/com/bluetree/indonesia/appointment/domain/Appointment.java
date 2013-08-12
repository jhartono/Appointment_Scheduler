package com.bluetree.indonesia.appointment.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "appointment")
public class Appointment extends AbstractAuditableEntity {

	private static final long serialVersionUID = -7303373246790964381L;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "appt_date", nullable = false)
	private Date appointmentDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "start_time", nullable = false)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "end_time", nullable = false)
	private Date endTime;
	
	@Column(name = "details", length = 1000)
	private String additionalDetail;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAdditionalDetail() {
		return additionalDetail;
	}

	public void setAdditionalDetail(String additionalDetail) {
		this.additionalDetail = additionalDetail;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
