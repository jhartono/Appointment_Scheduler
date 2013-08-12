package com.bluetree.indonesia.appointment.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.City;
import com.bluetree.indonesia.appointment.dto.CityDto;
import com.bluetree.indonesia.appointment.repository.CityRepository;
import com.bluetree.indonesia.appointment.service.CityService;

@Service
public class CityServiceImpl extends AbstractTranslatingService<City, CityDto>
		implements CityService {

	private static final long serialVersionUID = 1510509657600785460L;

	@Inject
	public CityServiceImpl(CityRepository cityRepository) {
		super(cityRepository);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CityDto> findByNameStartingWith(String nameFragment) {
		return translateFromEntity(((CityRepository) getRepository()).
				findByNameStartingWith(nameFragment));
	}

}
