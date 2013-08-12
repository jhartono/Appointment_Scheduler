package com.bluetree.indonesia.appointment.test.domain;

import java.util.Date;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Appointment;
import com.bluetree.indonesia.appointment.domain.Client;
import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.repository.AppointmentRepository;
import com.bluetree.indonesia.appointment.repository.ClientRepository;
import com.bluetree.indonesia.appointment.repository.EmployeeRepository;
import com.bluetree.indonesia.appointment.repository.LocationRepository;
import com.bluetree.indonesia.appointment.repository.TopicRepository;
import com.bluetree.indonesia.appointment.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, 
	loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestAppointment {
	
	@Inject
	private TopicRepository topicRepository;
	
	@Inject
	private LocationRepository locationRepository;
	
	@Inject
	private EmployeeRepository employeeRepository;
	
	@Inject
	private ClientRepository clientRepository;
	
	@Inject
	private AppointmentRepository appointmentRepository;
	
	@Test
	@Rollback(true)
	public void testSave() {
		Topic topic1 = new Topic();
		topic1.setText("Topic 1");
	
		Topic topic1AfterSave = topicRepository.save(topic1);
		
		Location location = new Location();
		location.setName("Location");
		location.setAddress1("Address1");
		location.setCity("City");
		location.setState("State");
		location.setCountry("Country");
		location.setZipCode("ZipCode");
	
		Location locationAfterSave = locationRepository.save(location);
		
		Employee employee = new Employee();
		employee.setLocation(locationAfterSave);
		employee.setFirstName("First Name");
		employee.setEmail("Email");
	
		Employee employeeAfterSave = employeeRepository.save(employee);
		
		Client client = new Client();
		client.setFirstName("First Name");
		client.setEmail("Email");
	
		Client clientAfterSave = clientRepository.save(client);
		
		Appointment appointment = new Appointment();
		appointment.setTopic(topic1AfterSave);
		appointment.setLocation(locationAfterSave);
		appointment.setEmployee(employeeAfterSave);
		appointment.setClient(clientAfterSave);
		appointment.setAppointmentDate(new Date());
		appointment.setStartTime(new Date());
		appointment.setEndTime(new Date());
		
		Appointment appointmentAfterSave = appointmentRepository.save(appointment);
		appointmentAfterSave = appointmentRepository.findOne(appointmentAfterSave.getId());
		
		Assert.assertNotNull(appointmentAfterSave);
		Assert.assertNotNull(appointmentAfterSave.getId());
		Assert.assertNotNull(appointmentAfterSave.getTopic());
		Assert.assertEquals(appointment.getTopic().getId(), appointmentAfterSave.getTopic().getId());
		Assert.assertNotNull(appointmentAfterSave.getLocation());
		Assert.assertEquals(appointment.getLocation().getId(), appointmentAfterSave.getLocation().getId());
		Assert.assertNotNull(appointmentAfterSave.getEmployee());
		Assert.assertEquals(appointment.getEmployee().getId(), appointmentAfterSave.getEmployee().getId());
		Assert.assertNotNull(appointmentAfterSave.getClient());
		Assert.assertEquals(appointment.getClient().getId(), appointmentAfterSave.getClient().getId());
		Assert.assertEquals(appointment.getAppointmentDate(), appointmentAfterSave.getAppointmentDate());
		Assert.assertEquals(appointment.getStartTime(), appointmentAfterSave.getStartTime());
		Assert.assertEquals(appointment.getEndTime(), appointmentAfterSave.getEndTime());
		Assert.assertNull(appointmentAfterSave.getAdditionalDetail());
	}
	
	@Test
	@Rollback(true)
	public void testSaveCascadeClient() {
		Topic topic1 = new Topic();
		topic1.setText("Topic 1");
	
		Topic topic1AfterSave = topicRepository.save(topic1);
		
		Location location = new Location();
		location.setName("Location");
		location.setAddress1("Address1");
		location.setCity("City");
		location.setState("State");
		location.setCountry("Country");
		location.setZipCode("ZipCode");
	
		Location locationAfterSave = locationRepository.save(location);
		
		Employee employee = new Employee();
		employee.setLocation(locationAfterSave);
		employee.setFirstName("First Name");
		employee.setEmail("Email");
	
		Employee employeeAfterSave = employeeRepository.save(employee);
		
		Client client = new Client();
		client.setFirstName("First Name");
		client.setEmail("Email");
		
		Appointment appointment = new Appointment();
		appointment.setTopic(topic1AfterSave);
		appointment.setLocation(locationAfterSave);
		appointment.setEmployee(employeeAfterSave);
		appointment.setClient(client);
		appointment.setAppointmentDate(new Date());
		appointment.setStartTime(new Date());
		appointment.setEndTime(new Date());
		
		Appointment appointmentAfterSave = appointmentRepository.save(appointment);
		appointmentAfterSave = appointmentRepository.findOne(appointmentAfterSave.getId());
		
		Assert.assertNotNull(appointmentAfterSave);
		Assert.assertNotNull(appointmentAfterSave.getId());
		
		Assert.assertNotNull(appointmentAfterSave.getClient());
		Assert.assertEquals(appointment.getClient().getId(), appointmentAfterSave.getClient().getId());
		Assert.assertEquals(appointment.getClient().getFirstName(), appointmentAfterSave.getClient().getFirstName());
		Assert.assertEquals(appointment.getClient().getEmail(), appointmentAfterSave.getClient().getEmail());
		
	}

}
