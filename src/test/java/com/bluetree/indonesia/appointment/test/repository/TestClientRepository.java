package com.bluetree.indonesia.appointment.test.repository;

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
public class TestClientRepository {
	
	@Inject
	private ClientRepository clientRepository;
	
	@Test
	@Rollback(true)
	public void testFindClient() {
		Client client = new Client();
		client.setExternalId("0101209999");
		client.setFirstName("Test Client1");
		client.setEmail("testclient@yahoo.com");
		
		Client clientAfterSave = clientRepository.save(client);
		
		Client clientToFind = clientRepository.findByExternalId("0101209999");
		Assert.assertEquals(clientAfterSave.getId(),clientToFind.getId());
		Assert.assertEquals("0101209999", clientToFind.getExternalId());
		
	}

}
