package com.rr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ShowCountriesListServiceImpl implements IshowCountriesListService {

	public ArrayList<String> showCountriesList() {
		Locale[] locale=Locale.getAvailableLocales();
		ArrayList<String> countries=new ArrayList<String>();
		for(Locale l:locale) {
			String country=l.getDisplayCountry();
			if(country.trim().length()>0 && !countries.contains(country))
				countries.add(country);
		}
		Collections.sort(countries);
		return countries;
	}
}
