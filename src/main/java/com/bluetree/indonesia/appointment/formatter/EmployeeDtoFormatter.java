package com.bluetree.indonesia.appointment.formatter;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.dto.EmployeeDto;
import com.bluetree.indonesia.appointment.service.EmployeeService;

@Component
public class EmployeeDtoFormatter extends AbstractDtoFormatter<Employee, EmployeeDto> {
	
	@Inject
	public EmployeeDtoFormatter(EmployeeService employeeService) {
		super(employeeService);
	}

}
