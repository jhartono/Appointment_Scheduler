package com.bluetree.indonesia.appointment.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ma.glasnost.orika.MapperFacade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;
import com.bluetree.indonesia.appointment.dto.AbstractDto;
import com.bluetree.indonesia.appointment.service.TranslatingService;

public abstract class AbstractTranslatingService<S extends AbstractEntity, D extends AbstractDto> 
	extends AbstractService<S> implements TranslatingService<S, D> {

	private static final long serialVersionUID = -7357689523669630327L;
	
	private Class<S> entityClass;
	private Class<D> dtoClass;
	
	@Inject
	private MapperFacade mapper;
	
	private JpaRepository<S, Long> repository;
	
	@SuppressWarnings("unchecked")
	public AbstractTranslatingService(JpaRepository<S, Long> repository) {
		this.repository = repository;
		this.entityClass = (Class<S>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.dtoClass = (Class<D>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Override
	@Transactional(readOnly = true)
	public D findOne(Long id) {
		S entity = repository.findOne(id);
      return translateFromEntity(entity);
	}

	@Override
	@Transactional
	public D save(D dto) {
		S entity = translateToEntity(dto);
		entity = repository.save(entity);
		return translateFromEntity(entity);
	}
	
	protected List<D> translateFromEntity(List<S> entities) {
		List<D> dtos = new ArrayList<D>();
		for (S entity : entities) {
			dtos.add(translateFromEntity(entity));
		}
		return dtos;
	}

	protected D translateFromEntity(S entity) {
		return mapper.map(entity, dtoClass);
	}

	protected List<S> translateToEntity(List<D> dtos) {
		List<S> entities = new ArrayList<S>();
		for (D dto : dtos) {
			entities.add(translateToEntity(dto));
		}
		return entities;
	}

	protected S translateToEntity(D dto) {
		return mapper.map(dto, entityClass);
	}
	
	protected MapperFacade getMapper() {
		return mapper;
	}
	
	protected JpaRepository<S, Long> getRepository() {
		return repository;
	}

}
