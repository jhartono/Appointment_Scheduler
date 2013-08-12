package com.bluetree.indonesia.appointment.facade;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.dto.Timeslot;

@Component
public class TimeslotBuilderImpl implements TimeslotBuilder {

	private static final long serialVersionUID = -5652712672910655083L;
	
	@Inject 
	private DateTimeConverter dateTimeConverter;

	@Override
	public List<Timeslot> buildTimeslots(Date startTime, Date endTime,
			int duration) throws ParseException {
		List<Timeslot> timeslots = new ArrayList<Timeslot>();
		int startMinute = convertToMinutes(startTime);
		int endMinute = convertToMinutes(endTime);
		
		while (startMinute < endMinute) {
			Timeslot timeslot = new Timeslot();
			timeslot.setStartMinute(startMinute);
			timeslot.setEndMinute(startMinute + duration);
			timeslot.setStartTime(convertToDate(timeslot.getStartMinute()));
			timeslot.setEndTime(convertToDate(timeslot.getEndMinute()));
			
			timeslots.add(timeslot);
			startMinute = startMinute + duration;
		}
		
		return timeslots;
	}
	
	private int convertToMinutes(Date time) {
		String strTime = dateTimeConverter.formatTime(time);
		String[] strTimes = strTime.split(":");
		String hour = strTimes[0];
		String minute = strTimes[1];
		
		return (Integer.parseInt(hour) * 60) + Integer.parseInt(minute);
	}
	
	private Date convertToDate(int minutes) throws ParseException {
		int hour = minutes / 60;
		int minute = minutes % 60;
		
		String strTimes = StringUtils.leftPad(Integer.toString(hour), 2) + ":" + 
				StringUtils.leftPad(Integer.toString(minute), 2);
		return dateTimeConverter.parseTime(strTimes);
	}

}
