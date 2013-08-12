package com.bluetree.indonesia.appointment.test.repository;

import java.util.List;

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
public class TestTopicRepository {
	
	@Inject
	private TopicRepository topicRepository;
	
	@Test
	@Rollback(true)
	public void testFindAllActive() {
		Topic topic = new Topic();
		topic.setText("Topic True");		
		
		Topic topicAfterSave = topicRepository.save(topic);
		
		Topic topic2 = new Topic();
		topic2.setText("Topic False");
		topic2.setActive(false);
		
		topicRepository.save(topic2);
		
		List<Topic> activeTopics = topicRepository.findByActiveTrue();
		
		Assert.assertNotNull(activeTopics);
		Assert.assertFalse(activeTopics.isEmpty());
		
		Topic activeTopic = activeTopics.get(0);
		Assert.assertEquals(topicAfterSave.getId(), activeTopic.getId());
		
		Assert.assertEquals(1, activeTopics.size());
	}

	@Test
	@Rollback(true)
	public void testFindAllContaining() {
		Topic topic = new Topic();
		topic.setText("Credit Card");		
		
		Topic topicAfterSave = topicRepository.save(topic);
		
		Topic topic2 = new Topic();
		topic2.setText("Debit Card");
	
		Topic topicAfterSave2 = topicRepository.save(topic2);
			
		Topic topic3 = new Topic();
		topic3.setText("Kartu Kredit");
		
		Topic topicAfterSave3 = topicRepository.save(topic3);
		
		List<Topic> containingTopics = topicRepository.findByTextContaining("card");
		
		Assert.assertNotNull(containingTopics);
		Assert.assertFalse(containingTopics.isEmpty());
		
		Assert.assertEquals(2, containingTopics.size());
		
		for (Topic tpc : containingTopics) {
			Assert.assertNotSame(topicAfterSave3.getId(), tpc.getId());
			
		}
	}


}
