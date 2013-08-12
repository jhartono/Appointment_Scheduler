package com.bluetree.indonesia.appointment.dto;

import java.io.Serializable;
import java.util.Date;

public class Timeslot implements Serializable {
	
	private static final long serialVersionUID = -6709161617893776731L;
	
	private int startMinute;
	private Date startTime;
	private int endMinute;
	private Date endTime;
	
	public int getStartMinute() {
		return startMinute;
	}
	
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public int getEndMinute() {
		return endMinute;
	}
	
	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
