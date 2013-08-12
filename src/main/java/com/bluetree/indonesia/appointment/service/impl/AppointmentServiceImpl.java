package com.bluetree.indonesia.appointment.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bluetree.indonesia.appointment.domain.Appointment;
import com.bluetree.indonesia.appointment.dto.AppointmentDto;
import com.bluetree.indonesia.appointment.repository.AppointmentRepository;
import com.bluetree.indonesia.appointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl extends AbstractTranslatingService<Appointment, AppointmentDto>
		implements AppointmentService {

	private static final long serialVersionUID = 5424437782699567232L;

	@Inject
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super(appointmentRepository);
	}
}
