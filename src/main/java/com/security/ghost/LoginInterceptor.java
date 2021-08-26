package com.security.ghost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
   /**
    * This implementation always returns {@code true}.
    */
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		   throws Exception {
      HttpSession session = request.getSession();
      
      try {
          if (session != null && session.getAttribute("id") != null) {
              return true;
          } else {
              ModelAndView modelAndView = new ModelAndView("redirect:/");
              modelAndView.setViewName("error/accessError");
              throw new ModelAndViewDefiningException(modelAndView);
          }
      } catch (Exception e) {
          ModelAndView modelAndView = new ModelAndView("redirect:/");
          modelAndView.setViewName("error/accessError");
          throw new ModelAndViewDefiningException(modelAndView);
      }
   }

   /**
    * This implementation is empty.
    */
   @Override
   public void postHandle(
         HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
         throws Exception {
      HttpSession session = request.getSession();
      
      if(session.getAttribute("id") == null) {
    	  mav.setViewName("error/accessError");
      }
   }


}