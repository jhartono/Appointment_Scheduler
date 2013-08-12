package com.bluetree.indonesia.appointment.validator;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.command.AppointmentFlowCommand;
import com.bluetree.indonesia.appointment.dto.AppointmentDto;
import com.bluetree.indonesia.appointment.dto.ClientDto;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.TopicDto;

@Component
public class AppointmentValidator {
	
	public void validateWhat(AppointmentFlowCommand appointmentCommand, ValidationContext context) {
		MessageContext messages = context.getMessageContext();
        
        AppointmentDto appointment = appointmentCommand.getAppointment();
        TopicDto topic = appointment.getTopic();
        if (topic == null || topic.getId() == null) {
        	messages.addMessage(new MessageBuilder().error().source("appointment.topic").
                    defaultText("Please select a topic to proceed").build());
        }
    }
	
	public void validateWhere(AppointmentFlowCommand appointmentCommand, ValidationContext context) {
		MessageContext messages = context.getMessageContext();
        
        AppointmentDto appointment = appointmentCommand.getAppointment();
        LocationDto location = appointment.getLocation();
        if (location == null || location.getId() == null) {
        	messages.addMessage(new MessageBuilder().error().source("appointment.location").
        			defaultText("Please select a location to proceed").build());
        }
    }
	
	public void validateWhen(AppointmentFlowCommand appointmentCommand, ValidationContext context) {
		MessageContext messages = context.getMessageContext();
        
        AppointmentDto appointment = appointmentCommand.getAppointment();
        Date appointmentDate = appointment.getAppointmentDate();
        if (appointmentDate == null) {
        	messages.addMessage(new MessageBuilder().error().source("appointment.appointmentDate").
        			defaultText("Please select a date to proceed").build());
        }
        
        Date appointmentStartTime = appointment.getStartTime();
        Date appointmentEndTime = appointment.getEndTime();
        if (appointmentStartTime == null || appointmentEndTime == null) {
        	messages.addMessage(new MessageBuilder().error().source("appointment.startDate").
        			defaultText("Please select a timeslot to proceed").build());
        }
    }
	
	public void validateWho(AppointmentFlowCommand appointmentCommand, ValidationContext context) {
		MessageContext messages = context.getMessageContext();
        
        AppointmentDto appointment = appointmentCommand.getAppointment();
        ClientDto client = appointment.getClient();
        
        if (StringUtils.isEmpty(appointmentCommand.getMemberStatus())) {
        	messages.addMessage(new MessageBuilder().error().source("memberStatus").
        			defaultText("Please tell us whether you are a member or non-member to proceed").build());
        } else {
        	if ("Y".equalsIgnoreCase(appointmentCommand.getMemberStatus())) {
        		if (StringUtils.isEmpty(client.getExternalId())) {
        			messages.addMessage(new MessageBuilder().error().source("appointment.client.externalId").
                			defaultText("Please specify your member number to proceed").build());
        		} 
        	} else {
        		if (StringUtils.isEmpty(client.getFirstName())) {
        			messages.addMessage(new MessageBuilder().error().source("appointment.client.firstName").
                			defaultText("Please specify your first name to proceed").build());
        		}
        		
        		if (StringUtils.isEmpty(client.getEmail())) {
        			messages.addMessage(new MessageBuilder().error().source("appointment.client.email").
                			defaultText("Please specify your email address to proceed").build());
        		}
        	}
        }
      
    }
}
