package kosta.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;



/**
 전체 프로젝트에서 발생하는 예외를 전역으로 처리하는 전용 클래스
*/

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler({BasicException.class})
	public ModelAndView error(BasicException e) {
		log.info("error BasicException : {} " , e.getErrorInfo().getMessage());
		
		//WEB-INF/views/error/error.jsp이동 
		return new ModelAndView("error/error", "errorInfo", e.getErrorInfo());
	}
	
	
}






