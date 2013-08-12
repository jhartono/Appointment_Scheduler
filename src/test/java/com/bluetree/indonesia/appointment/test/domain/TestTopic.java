package com.bluetree.indonesia.appointment.test.domain;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.repository.TopicRepository;
import com.bluetree.indonesia.appointment.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, 
	loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestTopic {
	
	@Inject
	private TopicRepository topicRepository;
	
	@Test
	@Rollback(true)
	public void testSave() {
		Topic topic = new Topic();
		topic.setText("Topic");
	
		Topic topicAfterSave = topicRepository.save(topic);
		topicAfterSave = topicRepository.findOne(topicAfterSave.getId());
		
		Assert.assertNotNull(topicAfterSave);
		Assert.assertNotNull(topicAfterSave.getId());
		Assert.assertEquals(topic.getText(), topicAfterSave.getText());
		Assert.assertNull(topicAfterSave.getDescription());
		Assert.assertEquals(topic.isActive(), topicAfterSave.isActive());
	}
	
}
