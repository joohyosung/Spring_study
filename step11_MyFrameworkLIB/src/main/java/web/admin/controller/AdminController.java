package web.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import web.mvc.service.TestService;

public class AdminController implements Controller {
	
	@Autowired
	private TestService service;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("관리자 전용입니다..");
		System.out.println("service = " + service);
		
		return new ModelAndView("result");//admin/result.jsp
	}
}
