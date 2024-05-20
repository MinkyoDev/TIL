package com.shinhan.myapp.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

// global exceptionó��
@ControllerAdvice
public class ExceptionHandlerController {

	Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler
	public String errorProcess500(Exception ex) {
		logger.info("===500 error===");
		logger.info(ex.getClass().getPackageName());
		logger.info(ex.getClass().getSimpleName());
		logger.info(ex.getMessage());
		ex.printStackTrace();
		return "error/error500";
	}
	
	// ��û�ּҰ� �߸��Ǿ�����, static�ڿ��� �浹
	@ExceptionHandler(NoHandlerFoundException.class)
	public String errorProcess404(HttpServletRequest request) {
		logger.info("===404 error===");
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", "404error");
		return "error/error404";
	}
}
