package com.bluetree.indonesia.appointment.domain;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public abstract class AbstractEntity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -4225997038976075861L;

}
