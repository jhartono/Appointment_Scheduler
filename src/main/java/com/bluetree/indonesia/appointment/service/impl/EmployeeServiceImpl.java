package com.bluetree.indonesia.appointment.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.dto.EmployeeDto;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.TopicDto;
import com.bluetree.indonesia.appointment.repository.EmployeeRepository;
import com.bluetree.indonesia.appointment.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends AbstractTranslatingService<Employee, EmployeeDto>
		implements EmployeeService {
	
	private static final long serialVersionUID = 7215286577253297035L;

	@Inject
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super(employeeRepository);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> findByActiveTrueAndTopicsTextAndLocation(
			TopicDto topicDto, LocationDto locationDto) {
		Topic topic = getMapper().map(topicDto, Topic.class);
		Location location = getMapper().map(locationDto, Location.class);
		return translateFromEntity(((EmployeeRepository) getRepository()).
				findByActiveTrueAndTopicsTextAndLocation(topic.getText(), location));
	}

}
