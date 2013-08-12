package com.bluetree.indonesia.appointment.service;

import java.util.List;

import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.dto.EmployeeDto;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.TopicDto;

public interface EmployeeService extends TranslatingService<Employee, EmployeeDto> {
	
	List<EmployeeDto> findByActiveTrueAndTopicsTextAndLocation(TopicDto topicDto, LocationDto locationDto);
}
