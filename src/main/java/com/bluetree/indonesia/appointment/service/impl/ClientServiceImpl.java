package com.bluetree.indonesia.appointment.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Client;
import com.bluetree.indonesia.appointment.dto.ClientDto;
import com.bluetree.indonesia.appointment.repository.ClientRepository;
import com.bluetree.indonesia.appointment.service.ClientService;

@Service
public class ClientServiceImpl extends AbstractTranslatingService<Client, ClientDto>
		implements ClientService {

	private static final long serialVersionUID = 6366185863779529125L;

	@Inject
	public ClientServiceImpl(ClientRepository clientRepository) {
		super(clientRepository);
	}

	@Override
	@Transactional(readOnly = true)
	public ClientDto findByExternalId(String externalId) {
		return translateFromEntity(((ClientRepository) getRepository()).
				findByExternalId(externalId));
	}


}
