package com.bluetree.indonesia.appointment.command;

import java.io.Serializable;

import com.bluetree.indonesia.appointment.dto.AppointmentDto;
import com.bluetree.indonesia.appointment.dto.ClientDto;

public class AppointmentFlowCommand implements Serializable {
	
	private static final long serialVersionUID = -221871457083571384L;
	
	private AppointmentDto appointment;
	private SearchLocationFormCommand searchLocationForm;
	private String memberStatus;
	
	public AppointmentFlowCommand() {
		AppointmentDto appointment = new AppointmentDto();
		ClientDto client = new ClientDto();
		appointment.setClient(client);
		
		this.appointment = appointment;
		this.searchLocationForm = new SearchLocationFormCommand();
	}

	public AppointmentDto getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDto appointment) {
		this.appointment = appointment;
	}

	public SearchLocationFormCommand getSearchLocationForm() {
		return searchLocationForm;
	}

	public void setSearchLocationForm(SearchLocationFormCommand searchLocationForm) {
		this.searchLocationForm = searchLocationForm;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

}
