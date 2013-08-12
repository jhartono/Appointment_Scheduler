package com.bluetree.indonesia.appointment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends AbstractController {
	
	private static final long serialVersionUID = -4445347678946167032L;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

}
