package com.bluetree.indonesia.appointment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluetree.indonesia.appointment.dto.CityDto;
import com.bluetree.indonesia.appointment.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController extends AbstractController {
	
	private static final long serialVersionUID = 4324948602410834112L;
	
	@Inject
	private CityService cityService;

	@RequestMapping(value = "/search", method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<String> getResources(@RequestParam(value="q") String query) {
	    List<CityDto> cities = cityService.findByNameStartingWith(query);
	    return translateToNameList(cities);
	}

	private List<String> translateToNameList(List<CityDto> cities) {
		List<String> names = new ArrayList<String>();
		for (CityDto cityDto : cities) {
			names.add(cityDto.getName());
		}
		return names;
	}

}
