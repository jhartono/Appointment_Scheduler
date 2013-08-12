package com.bluetree.indonesia.appointment.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.bluetree.indonesia.appointment.command.AppointmentFlowCommand;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.Timeslot;
import com.bluetree.indonesia.appointment.dto.TopicDto;

public interface AppointmentFlowFacade extends Serializable {

	AppointmentFlowCommand createCommandObject();
	
	List<TopicDto> getActiveTopics();
	
	List<LocationDto> searchLocation(AppointmentFlowCommand appointmentFlowCommand);
	
	List<List<Timeslot>> buildTimeslots(AppointmentFlowCommand appointmentFlowCommand) throws ParseException;
	
	Event assignEmployee(RequestContext context);
	
	Event assignClient(RequestContext context);
	
	Event confirmAppointment(RequestContext context);
}
