package com.rr.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageImpl implements IWishMessageService {

	public String getWishMessage() {
		LocalDateTime ldt=LocalDateTime.now();
		//get cuurent hour of the day
		int hour=ldt.getHour();
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
