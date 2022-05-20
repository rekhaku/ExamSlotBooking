package com.exam.booking.exception;

import java.util.Date;

import org.springframework.web.bind.annotation.ResponseStatus;


public class ExamBookingException extends Exception{
	
	String message;
	Date timeStamp;
	
	public ExamBookingException(String message , Date date)
	{
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
	

}
