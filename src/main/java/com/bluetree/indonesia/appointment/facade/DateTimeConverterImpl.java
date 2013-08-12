package com.bluetree.indonesia.appointment.facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeConverterImpl implements DateTimeConverter {

	private static final long serialVersionUID = 4575512039546552384L;

	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat TIME_FORMATTER = new SimpleDateFormat("HH:mm");

	@Override
	public String formatTime(Date time) {
		return TIME_FORMATTER.format(time);
	}

	@Override
	public Date parseTime(String time) throws ParseException {
		return TIME_FORMATTER.parse(time);
	}

	@Override
	public String formatDate(Date date) {
		return DATE_FORMATTER.format(date);
	}

	@Override
	public Date parseDate(String date) throws ParseException {
		return DATE_FORMATTER.parse(date);
	}

}
