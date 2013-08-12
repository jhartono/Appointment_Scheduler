package com.bluetree.indonesia.appointment.facade;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.bluetree.indonesia.appointment.command.AppointmentFlowCommand;
import com.bluetree.indonesia.appointment.command.SearchLocationFormCommand;
import com.bluetree.indonesia.appointment.dto.AppointmentDto;
import com.bluetree.indonesia.appointment.dto.ClientDto;
import com.bluetree.indonesia.appointment.dto.EmployeeDto;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.Timeslot;
import com.bluetree.indonesia.appointment.dto.TopicDto;
import com.bluetree.indonesia.appointment.service.AppointmentService;
import com.bluetree.indonesia.appointment.service.ClientService;
import com.bluetree.indonesia.appointment.service.EmployeeService;
import com.bluetree.indonesia.appointment.service.LocationService;
import com.bluetree.indonesia.appointment.service.TopicService;

@Service("appointmentFlowFacade")
public class AppointmentFlowFacadeImpl extends MultiAction
		implements AppointmentFlowFacade {

	private static final long serialVersionUID = 8340664163863917747L;

	@Inject
	private TopicService topicService;
	
	@Inject 
	private LocationService locationService;
	
	@Inject
	private EmployeeService employeeService;
	
	@Inject
	private ClientService clientService;
	
	@Inject
	private AppointmentService appointmentService;
	
	@Inject 
	private DateTimeConverter dateTimeConverter;
	
	@Inject
	private TimeslotBuilder timeslotBuilder;

	@Override
	public AppointmentFlowCommand createCommandObject() {
		return new AppointmentFlowCommand();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TopicDto> getActiveTopics() {
		return topicService.findActive();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LocationDto> searchLocation(
			AppointmentFlowCommand appointmentFlowCommand) {
		SearchLocationFormCommand searchLocationFormCommand = appointmentFlowCommand.getSearchLocationForm();
		AppointmentDto appointmentDto = appointmentFlowCommand.getAppointment();
		TopicDto topicDto = appointmentDto.getTopic();
		
		if (!StringUtils.isEmpty(searchLocationFormCommand.getZipCode()) && 
				StringUtils.isEmpty(searchLocationFormCommand.getLocality())) {
			 return locationService.findByTopicAndZipCode(topicDto, searchLocationFormCommand.getZipCode());
		} else if (StringUtils.isEmpty(searchLocationFormCommand.getZipCode()) && 
				!StringUtils.isEmpty(searchLocationFormCommand.getLocality())) {
			return locationService.findByTopicAndCity(topicDto, searchLocationFormCommand.getLocality());
		} else if (!StringUtils.isEmpty(searchLocationFormCommand.getZipCode()) && 
				!StringUtils.isEmpty(searchLocationFormCommand.getLocality())) {
			return locationService.findByTopicAndZipCodeAndCity(topicDto, searchLocationFormCommand.getZipCode(), 
					searchLocationFormCommand.getLocality());
		} else {
			return new ArrayList<LocationDto>();
		}
	}
	
	@Override
	public List<List<Timeslot>> buildTimeslots(
			AppointmentFlowCommand appointmentFlowCommand) throws ParseException {
		List<List<Timeslot>> timeslotsList = new ArrayList<List<Timeslot>>();
		
		Date morningStartTime = dateTimeConverter.parseTime("08:00");
		Date morningEndTime = dateTimeConverter.parseTime("12:00");
		timeslotsList.add(timeslotBuilder.buildTimeslots(morningStartTime, morningEndTime, 30));
		
		Date afternoonStartTime = dateTimeConverter.parseTime("13:00");
		Date afternoonMorningEndTime = dateTimeConverter.parseTime("17:00");
		timeslotsList.add(timeslotBuilder.buildTimeslots(afternoonStartTime, afternoonMorningEndTime, 30));
		
		return timeslotsList;
	}

	@Override
	@Transactional(readOnly = true)
	public Event assignEmployee(RequestContext context) {
		AppointmentFlowCommand appointmentFlowCommand = (AppointmentFlowCommand)context.getFlowScope().get("appointment");
		AppointmentDto appointmentDto = appointmentFlowCommand.getAppointment();
		TopicDto topicDto = appointmentDto.getTopic();
		LocationDto locationDto = appointmentDto.getLocation();
		
		List<EmployeeDto> employees = employeeService.findByActiveTrueAndTopicsTextAndLocation(topicDto, locationDto);
		if (employees != null && !employees.isEmpty()) {
			appointmentDto.setEmployee(employees.get(BigInteger.ZERO.intValue()));
			
			
			
			
			//TODO: Remove
			//Reset Client
			appointmentDto.setClient(new ClientDto());
			
			
			
			
			return success();
		} 	
		context.getMessageContext().addMessage(
                new MessageBuilder().error().defaultText("Unable to book resource (Employee), please try a different topic, location, or date to proceed").build());
            return error();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Event assignClient(RequestContext context) {
		AppointmentFlowCommand appointmentFlowCommand = (AppointmentFlowCommand)context.getFlowScope().get("appointment");
		AppointmentDto appointmentDto = appointmentFlowCommand.getAppointment();
		ClientDto clientDto = appointmentDto.getClient();
		
		if ("Y".equalsIgnoreCase(appointmentFlowCommand.getMemberStatus())) {
			ClientDto client = clientService.findByExternalId(clientDto.getExternalId());
			if (client != null && client.getId() != null) {
				appointmentDto.setClient(client);
				return success();
			}
			context.getMessageContext().addMessage(
	                new MessageBuilder().error().defaultText("Please specify a valid member number to proceed").build());
	            return error();
		} else {
			clientDto.setExternalId(null);
			return success();
		}
	}

	@Override
	@Transactional
	public Event confirmAppointment(RequestContext context) {
		AppointmentFlowCommand appointmentFlowCommand = (AppointmentFlowCommand)context.getFlowScope().get("appointment");
		AppointmentDto appointmentDto = appointmentFlowCommand.getAppointment();
		appointmentService.save(appointmentDto);
		return success();
	}
	
}
