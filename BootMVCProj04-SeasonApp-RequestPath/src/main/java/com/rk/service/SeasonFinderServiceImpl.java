package com.rk.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SeasonFinderServiceImpl implements ISeasonFinderService{
	
	@Override
	public String findService() {
		//get system Date
		LocalDate ld=LocalDate.now();
		//get current month
		int month=ld.getMonthValue();
		//find Season
		if(month>=7&&month<=9)
			return "Rainy Season";
		else if (month>=3&&month<=6)
			return "summer season";
		else 
			return "Winter Season";
	}

}
