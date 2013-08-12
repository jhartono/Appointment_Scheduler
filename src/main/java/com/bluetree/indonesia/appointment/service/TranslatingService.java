package com.bluetree.indonesia.appointment.service;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;
import com.bluetree.indonesia.appointment.dto.AbstractDto;

public interface TranslatingService<S extends AbstractEntity, D extends AbstractDto> {
	
	D findOne(Long id);
	
	D save(D dto);
	
}
