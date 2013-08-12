package com.bluetree.indonesia.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.domain.Location;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
	
	List<Employee> findByActiveTrueAndTopicsTextAndLocation(String text, Location location);
}
