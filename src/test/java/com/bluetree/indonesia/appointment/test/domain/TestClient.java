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

import com.bluetree.indonesia.appointment.domain.Client;
import com.bluetree.indonesia.appointment.repository.ClientRepository;
import com.bluetree.indonesia.appointment.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, 
	loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestClient {
	
	@Inject
	private ClientRepository clientRepository;
	
	@Test
	@Rollback(true)
	public void testSave() {
		Client client = new Client();
		client.setFirstName("First Name");
		client.setEmail("Email");
	
		Client clientAfterSave = clientRepository.save(client);
		clientAfterSave = clientRepository.findOne(clientAfterSave.getId());
		
		Assert.assertNotNull(clientAfterSave);
		Assert.assertNotNull(clientAfterSave.getId());
		Assert.assertNull(clientAfterSave.getExternalId());
		Assert.assertEquals(client.getFirstName(), clientAfterSave.getFirstName());
		Assert.assertNull(clientAfterSave.getMiddleName());
		Assert.assertNull(clientAfterSave.getLastName());
		Assert.assertNull(clientAfterSave.getPhone());
		Assert.assertNull(clientAfterSave.getMobile());
		Assert.assertEquals(client.getEmail(), clientAfterSave.getEmail());
		Assert.assertEquals(client.isActive(), clientAfterSave.isActive());
	}

}
