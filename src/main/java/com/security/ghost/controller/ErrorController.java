package com.security.ghost.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value="/error/loginError")
	public ModelAndView loginError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/loginError");
		return mav;
	}
	
	@RequestMapping(value="/error/registerIDPassNickError")
	public ModelAndView registerIDPassNickError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/registerIDPassNickError");
		return mav;
	}
	
	@RequestMapping(value="/error/registerPhoneEmailError")
	public ModelAndView registerPhoneEmailError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/registerPhoneEmailError");
		return mav;
	}
	
}
