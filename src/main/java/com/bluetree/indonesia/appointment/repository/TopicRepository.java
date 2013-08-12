package com.bluetree.indonesia.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bluetree.indonesia.appointment.domain.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>, JpaSpecificationExecutor<Topic> {
	
	public List<Topic> findByActiveTrue();
	public List<Topic> findByTextContaining(String text);
    
}
