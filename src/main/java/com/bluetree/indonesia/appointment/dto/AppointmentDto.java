package com.bluetree.indonesia.appointment.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AppointmentDto extends AbstractDto {

	private static final long serialVersionUID = -1975160995076090050L;

	@Valid
	@NotNull
	private TopicDto topic;
	
	@Valid
	@NotNull
	private LocationDto location;
	
	@NotNull
	private Date appointmentDate;
	
	@NotNull
	private Date startTime;
	
	@NotNull
	private Date endTime;
	
	@Valid
	@NotNull
	private EmployeeDto employee;
	
	@Valid
	@NotNull
	private ClientDto client;
	
	@Length(max=800)
	private String additionalDetail;

	public TopicDto getTopic() {
		return topic;
	}

	public void setTopic(TopicDto topic) {
		this.topic = topic;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

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
	
}
