package com.bluetree.indonesia.appointment.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Location;
import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.dto.LocationDto;
import com.bluetree.indonesia.appointment.dto.TopicDto;
import com.bluetree.indonesia.appointment.repository.LocationRepository;
import com.bluetree.indonesia.appointment.service.LocationService;

@Service
public class LocationServiceImpl extends AbstractTranslatingService<Location, LocationDto>
		implements LocationService {
	
	private static final long serialVersionUID = -1833603552284773653L;

	@Inject
	public LocationServiceImpl(LocationRepository locationRepository) {
		super(locationRepository);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LocationDto> findByTopicAndZipCode(TopicDto topicDto, String zipCode) {
		Topic topic = getMapper().map(topicDto, Topic.class);
		return translateFromEntity(((LocationRepository) getRepository()).
				findByTopicsTextAndZipCode(topic.getText(), zipCode));
	}

	@Override
	@Transactional(readOnly = true)
	public List<LocationDto> findByTopicAndCity(TopicDto topicDto, String city) {
		Topic topic = getMapper().map(topicDto, Topic.class);
		return translateFromEntity(((LocationRepository) getRepository()).
				findByTopicsTextAndCity(topic.getText(), city));
	}

	@Override
	@Transactional(readOnly = true)
	public List<LocationDto> findByTopicAndZipCodeAndCity(TopicDto topicDto,
			String zipCode, String city) {
		Topic topic = getMapper().map(topicDto, Topic.class);
		return translateFromEntity(((LocationRepository) getRepository()).
				findByTopicsTextAndZipCodeAndCity(topic.getText(), zipCode, city));
	}


}
