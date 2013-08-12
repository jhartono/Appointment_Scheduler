package com.bluetree.indonesia.appointment.mapper;

import java.io.Serializable;

import javax.persistence.LockModeType;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;

public interface EntityLoader extends Serializable {

	<T extends AbstractEntity> T load(Class<T> entityClass, Long id);
	
	<T extends AbstractEntity> T load(Class<T> entityClass, Long id, LockModeType lock);
}
