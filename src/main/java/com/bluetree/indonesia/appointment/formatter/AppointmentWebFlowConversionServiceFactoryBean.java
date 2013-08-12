package com.bluetree.indonesia.appointment.formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.facade.DateTimeConverter;

@Component("appointmentWebFlowConversionService")
public class AppointmentWebFlowConversionServiceFactoryBean extends
	FormattingConversionServiceFactoryBean {
	
	@Inject
	private TopicDtoFormatter topicDtoFormatter;
	
	@Inject
	private LocationDtoFormatter locationDtoFormatter;
	
	@Inject
	private EmployeeDtoFormatter employeeDtoFormatter;
	
	@Inject 
	private DateTimeConverter dateTimeConverter;
	
	@Override
	@Deprecated
	protected void installFormatters(FormatterRegistry registry) {
		registry.addFormatter(topicDtoFormatter);
		registry.addFormatter(locationDtoFormatter);
		registry.addFormatter(employeeDtoFormatter);
		
		registry.addFormatter(new Formatter<Date>() {
			
			@Override
			public String print(Date date, Locale locale) {
				return "";
			}

			@Override
			public Date parse(String text, Locale locale) throws ParseException {
				if (!StringUtils.isEmpty(text)) {
					try {
						Date date = dateTimeConverter.parseDate(text);
						return date;
					} catch (ParseException e) {
						try {
							Date time = dateTimeConverter.parseTime(text);
							return time;
						} catch (ParseException e1) {
							throw e1;
						}
					}
				}
				return null;
			}
		});
	}
	
}
