package com.bluetree.indonesia.appointment.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.dto.TopicDto;
import com.bluetree.indonesia.appointment.repository.TopicRepository;
import com.bluetree.indonesia.appointment.service.TopicService;

@Service
public class TopicServiceImpl extends AbstractTranslatingService<Topic, TopicDto>
		implements TopicService {

	private static final long serialVersionUID = -6195982626492047282L;
	
	@Inject
	public TopicServiceImpl(TopicRepository topicRepository) {
		super(topicRepository);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TopicDto> findActive() {
		return translateFromEntity(((TopicRepository) getRepository()).findByActiveTrue());
	}

}
