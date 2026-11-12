package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectByController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SekectByController call...");
		
		request.setAttribute("message", "재미있다~~");
		
		return new ModelAndView("selectby.jsp", false);
	}
	
	

}
