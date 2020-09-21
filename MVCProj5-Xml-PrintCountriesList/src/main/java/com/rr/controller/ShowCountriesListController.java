package com.rr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.rr.service.IshowCountriesListService;
import com.rr.service.ShowCountriesListServiceImpl;

public class ShowCountriesListController extends AbstractController{
	private IshowCountriesListService service;
	
	public ShowCountriesListController(IshowCountriesListService service) {
		this.service=service;
	}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)throws Exception {
		ArrayList<String> countries=new ArrayList<String>();
		countries=service.showCountriesList();
		//System.out.println(countries);
		return new ModelAndView("result","scl",countries);
	}
}
