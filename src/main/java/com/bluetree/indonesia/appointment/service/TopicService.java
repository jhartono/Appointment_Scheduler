package com.bluetree.indonesia.appointment.service;

import java.util.List;

import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.dto.TopicDto;

public interface TopicService extends TranslatingService<Topic, TopicDto> {

	List<TopicDto> findActive();
	
}
