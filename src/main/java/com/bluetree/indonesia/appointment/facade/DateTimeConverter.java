package com.bluetree.indonesia.appointment.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public interface DateTimeConverter extends Serializable {
	
	String formatDate(Date date);
	
	Date parseDate(String date) throws ParseException;
	
	String formatTime(Date time);
	
	Date parseTime(String time) throws ParseException;

}
