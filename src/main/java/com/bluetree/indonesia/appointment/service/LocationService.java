package com.bluetree.indonesia.appointment.service;

import java.util.List;

import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.TopicDto;

public interface LocationService extends TranslatingService<Location, LocationDto> {
	
	List<LocationDto> findByTopicAndZipCode(TopicDto topicDto, String zipCode);
    
    List<LocationDto> findByTopicAndCity(TopicDto topicDto, String city);
    
    List<LocationDto> findByTopicAndZipCodeAndCity(TopicDto topicDto, String zipCode, String city);

}
