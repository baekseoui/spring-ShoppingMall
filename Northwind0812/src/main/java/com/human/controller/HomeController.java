package com.human.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "/main/main";
	}
	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public void main(Principal principal,Model model) throws IOException {
		logger.info("main.jsp");
		
//		if(!principal.getName().isEmpty()) {
//			String loginID=principal.getName();
//			model.addAttribute("login_Id",loginID);
//		}else {
//			logger.info("세션 id 없음");
//		}
		
	}
	
}
