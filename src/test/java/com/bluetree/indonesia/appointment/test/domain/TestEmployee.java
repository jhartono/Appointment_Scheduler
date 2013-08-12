package com.bluetree.indonesia.appointment.test.domain;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Employee;
import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.repository.EmployeeRepository;
import com.bluetree.indonesia.appointment.repository.LocationRepository;
import com.bluetree.indonesia.appointment.repository.TopicRepository;
import com.bluetree.indonesia.appointment.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, 
	loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestEmployee {
	
	@Inject
	private TopicRepository topicRepository;
	
	@Inject
	private LocationRepository locationRepository;
	
	@Inject
	private EmployeeRepository employeeRepository;
	
	@Test
	@Rollback(true)
	public void testSave() {
		Location location = new Location();
		location.setName("Location");
		location.setAddress1("Address1");
		location.setCity("City");
		location.setState("State");
		location.setCountry("Country");
		location.setZipCode("ZipCode");
	
		Location locationAfterSave = locationRepository.save(location);
		locationAfterSave = locationRepository.findOne(locationAfterSave.getId());
		
		Employee employee = new Employee();
		employee.setLocation(locationAfterSave);
		employee.setFirstName("First Name");
		employee.setEmail("Email");
	
		Employee employeeAfterSave = employeeRepository.save(employee);
		employeeAfterSave = employeeRepository.findOne(employeeAfterSave.getId());
		
		Assert.assertNotNull(employeeAfterSave);
		Assert.assertNotNull(employeeAfterSave.getId());
		Assert.assertNull(employeeAfterSave.getExternalId());
		Assert.assertNotNull(employeeAfterSave.getLocation());
		Assert.assertEquals(employee.getLocation().getId(), employeeAfterSave.getLocation().getId());
		Assert.assertEquals(employee.getFirstName(), employeeAfterSave.getFirstName());
		Assert.assertNull(employeeAfterSave.getMiddleName());
		Assert.assertNull(employeeAfterSave.getLastName());
		Assert.assertNull(employeeAfterSave.getPhone());
		Assert.assertNull(employeeAfterSave.getMobile());
		Assert.assertEquals(employee.getEmail(), employeeAfterSave.getEmail());
		Assert.assertEquals(employee.isActive(), employeeAfterSave.isActive());
	}
	
	@Test
	@Rollback(true)
	public void testSaveWithTopic() {
		Topic topic1 = new Topic();
		topic1.setText("Topic 1");
	
		Topic topic1AfterSave = topicRepository.save(topic1);
		
		Topic topic2 = new Topic();
		topic2.setText("Topic 2");
	
		Topic topic2AfterSave = topicRepository.save(topic2);
		
		Set<Topic> topics = new HashSet<Topic>();
		topics.add(topic1AfterSave);
		topics.add(topic2AfterSave);
		
		Location location = new Location();
		location.setName("Location");
		location.setAddress1("Address1");
		location.setCity("City");
		location.setState("State");
		location.setCountry("Country");
		location.setZipCode("ZipCode");
	
		Location locationAfterSave = locationRepository.save(location);
		locationAfterSave = locationRepository.findOne(locationAfterSave.getId());
		
		Employee employee = new Employee();
		employee.setLocation(locationAfterSave);
		employee.setFirstName("First Name");
		employee.setEmail("Email");
		employee.setTopics(topics);
	
		Employee employeeAfterSave = employeeRepository.save(employee);
		employeeAfterSave = employeeRepository.findOne(employeeAfterSave.getId());
		
		Assert.assertNotNull(employeeAfterSave);
		Assert.assertNotNull(employeeAfterSave.getId());
		
		Set<Topic> topicsAfterSave = employeeAfterSave.getTopics();
		Assert.assertNotNull(topicsAfterSave);
		Assert.assertFalse(topicsAfterSave.isEmpty());
		Assert.assertEquals(topics.size(), topicsAfterSave.size());
		
		employeeAfterSave.setTopics(new HashSet<Topic>());
		
		Employee employeeAfterSave2 = employeeRepository.save(employeeAfterSave);
		employeeAfterSave2 = employeeRepository.findOne(employeeAfterSave.getId());
		Set<Topic> topicsAfterSave2 = employeeAfterSave2.getTopics();
		Assert.assertNotNull(topicsAfterSave2);
		Assert.assertTrue(topicsAfterSave2.isEmpty());
	}

}
