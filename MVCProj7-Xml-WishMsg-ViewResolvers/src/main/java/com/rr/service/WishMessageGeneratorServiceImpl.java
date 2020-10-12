package com.rr.service;

import java.util.Calendar;

public class WishMessageGeneratorServiceImpl implements WishMessageService {

	public String generateMessage() {
		int hour=0;
		Calendar calendar=null;
		//get calendar class object
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish message
		if(hour<12)
			return "good morning";
		else if(hour<16)
			return "good afternoon";
		else if(hour<20)
			return "good evening";
		else
		return "good night";
	}

}
