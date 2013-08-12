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

import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.repository.LocationRepository;
import com.bluetree.indonesia.appointment.repository.TopicRepository;
import com.bluetree.indonesia.appointment.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, 
	loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestLocation {
	
	@Inject
	private TopicRepository topicRepository;
	
	@Inject
	private LocationRepository locationRepository;
	
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
		
		Assert.assertNotNull(locationAfterSave);
		Assert.assertNotNull(locationAfterSave.getId());
		Assert.assertEquals(location.getName(), locationAfterSave.getName());
		Assert.assertNull(locationAfterSave.getDescription());
		Assert.assertEquals(location.getAddress1(), locationAfterSave.getAddress1());
		Assert.assertNull(locationAfterSave.getAddress2());
		Assert.assertNull(locationAfterSave.getAddress3());
		Assert.assertEquals(location.getCity(), locationAfterSave.getCity());
		Assert.assertEquals(location.getState(), locationAfterSave.getState());
		Assert.assertEquals(location.getCountry(), locationAfterSave.getCountry());
		Assert.assertEquals(location.getZipCode(), locationAfterSave.getZipCode());
		Assert.assertNull(locationAfterSave.getLatitude());
		Assert.assertNull(locationAfterSave.getLongitude());
		Assert.assertNull(locationAfterSave.getPhone());
		Assert.assertNull(locationAfterSave.getFax());
		Assert.assertNull(locationAfterSave.getEmail());
		Assert.assertNull(locationAfterSave.getStartDate());
		Assert.assertNull(locationAfterSave.getEndDate());
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
		location.setTopics(topics);
	
		Location locationAfterSave = locationRepository.save(location);
		locationAfterSave = locationRepository.findOne(locationAfterSave.getId());
		
		Assert.assertNotNull(locationAfterSave);
		Assert.assertNotNull(locationAfterSave.getId());
		
		Set<Topic> topicsAfterSave = locationAfterSave.getTopics();
		Assert.assertNotNull(topicsAfterSave);
		Assert.assertFalse(topicsAfterSave.isEmpty());
		Assert.assertEquals(topics.size(), topicsAfterSave.size());
		
		locationAfterSave.setTopics(new HashSet<Topic>());
		
		Location locationAfterSave2 = locationRepository.save(locationAfterSave);
		locationAfterSave2 = locationRepository.findOne(locationAfterSave.getId());
		Set<Topic> topicsAfterSave2 = locationAfterSave2.getTopics();
		Assert.assertNotNull(topicsAfterSave2);
		Assert.assertTrue(topicsAfterSave2.isEmpty());
	}

}
