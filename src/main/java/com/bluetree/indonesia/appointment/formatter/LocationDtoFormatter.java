package com.bluetree.indonesia.appointment.formatter;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.service.LocationService;

@Component
public class LocationDtoFormatter extends AbstractDtoFormatter<Location, LocationDto> {
	
	@Inject
	public LocationDtoFormatter(LocationService locationService) {
		super(locationService);
	}

}
