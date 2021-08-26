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
	
	@RequestMapping(value="/error/sqlError")
	public ModelAndView sqlError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/sqlError");
		return mav;
	}
	
	@RequestMapping(value="/error/uploadError")
	public ModelAndView uploadError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/uploadError");
		return mav;
	}
	@RequestMapping(value="/error/joinError")
	public ModelAndView joinError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/joinError");
		return mav;
	}
	@RequestMapping(value="/error/accessError")
	public ModelAndView accessError(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/accessError");
		return mav;
	}
}
