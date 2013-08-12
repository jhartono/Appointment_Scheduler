package com.bluetree.indonesia.appointment.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.Formatter;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;
import com.bluetree.indonesia.appointment.dto.AbstractDto;
import com.bluetree.indonesia.appointment.service.TranslatingService;

public  class AbstractDtoFormatter<S extends AbstractEntity, D extends AbstractDto> implements Formatter<D> {
	
	private TranslatingService<S,D> service;
	
	public AbstractDtoFormatter(TranslatingService<S,D> service) {
		this.service = service;
	}

	@Override
	public String print(D object, Locale locale) {
		if (object != null && object.getId() != null) {
			return object.getId().toString();
		}
		return null;
	}

	@Override
	public D parse(String text, Locale locale) throws ParseException {
		if (!StringUtils.isEmpty(text)) {
			return service.findOne(Long.valueOf(text));
		}
		return null;
	}

}
