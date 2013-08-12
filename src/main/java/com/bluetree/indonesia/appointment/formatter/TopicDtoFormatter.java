package com.bluetree.indonesia.appointment.formatter;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.domain.Topic;
import com.bluetree.indonesia.appointment.dto.TopicDto;
import com.bluetree.indonesia.appointment.service.TopicService;

@Component
public class TopicDtoFormatter extends AbstractDtoFormatter<Topic, TopicDto> {
	
	@Inject
	public TopicDtoFormatter(TopicService topicService) {
		super(topicService);
	}
}
