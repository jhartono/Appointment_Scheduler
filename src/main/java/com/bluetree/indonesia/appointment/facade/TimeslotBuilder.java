package com.bluetree.indonesia.appointment.facade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.bluetree.indonesia.appointment.dto.Timeslot;

public interface TimeslotBuilder extends Serializable {
	
	List<Timeslot> buildTimeslots(Date startTime, Date endTime, int duration) throws ParseException;

}
