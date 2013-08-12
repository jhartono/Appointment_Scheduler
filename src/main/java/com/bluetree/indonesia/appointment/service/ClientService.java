package com.bluetree.indonesia.appointment.service;

import com.bluetree.indonesia.appointment.domain.Client;
import com.bluetree.indonesia.appointment.dto.ClientDto;

public interface ClientService extends TranslatingService<Client, ClientDto> {
	
	ClientDto findByExternalId(String externalId);
}
