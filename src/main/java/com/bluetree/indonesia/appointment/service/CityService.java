package com.bluetree.indonesia.appointment.service;

import java.util.List;

import com.bluetree.indonesia.appointment.domain.City;
import com.bluetree.indonesia.appointment.dto.CityDto;

public interface CityService extends TranslatingService<City, CityDto> {
	
	List<CityDto> findByNameStartingWith(String nameFragment);

}
