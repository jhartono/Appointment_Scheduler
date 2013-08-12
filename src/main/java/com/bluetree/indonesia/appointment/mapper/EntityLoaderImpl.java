package com.bluetree.indonesia.appointment.mapper;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;

@Component
@Transactional(readOnly = true)
public class EntityLoaderImpl implements EntityLoader {
	
	private static final long serialVersionUID = -7765220498312697620L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public <T extends AbstractEntity> T load(Class<T> entityClass, Long id) {
		return entityManager.find(entityClass, id);
	}
	
	@Override
	public <T extends AbstractEntity> T load(Class<T> entityClass, Long id, LockModeType lock) {
		return entityManager.find(entityClass, id, lock);
	}
}
