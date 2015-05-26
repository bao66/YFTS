package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.mail.MailMail;


@Controller
public class LoginController {
/*	@Autowired
	@Qualifier("mailMail")
	private MailMail mailMail;*/
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView mainPage() {	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("title", "Hello, welcome to Customized Spring Security");
		System.out.println("login Sucess");
		
/*		String sender="shuavagex@gmail.com";//write here sender gmail id  
		String receiver="fastmovie@126.com";//write here receiver id  
		mailMail.sendMail(sender,receiver,"hi","welcome");  */
		
		return mav;
	}
}
