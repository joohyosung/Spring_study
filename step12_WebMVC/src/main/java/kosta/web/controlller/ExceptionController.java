package kosta.web.controlller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ExceptionController {
	
	private final UserService userService;
	
	@RequestMapping("/exception.do")
	public String exception(String no) {
		log.info("no={}", no);
		
		int convertNo = Integer.parseInt(no);
		log.info("convertNo={}", convertNo);
		
		int result = 100/ convertNo;
		log.info("result={}", result);
		
		return "result";//WEB-INF/views/result.jsp이동
	}
	
	
	@ExceptionHandler({NumberFormatException.class , ArithmeticException.class})
	public ModelAndView error(Exception e) {
		log.info("errorMsg : {} ", e.getMessage());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errMsg", e.getMessage());
		mv.addObject("errClass", e.getClass().getName());
		mv.addObject("statusCode", HttpStatus.BAD_REQUEST);
		
		mv.setViewName("error/errorView");//WEB-INF/views/error/errorView.jsp
	    return mv;
		
	}
	
	
	/*@ExceptionHandler({ArithmeticException.class})
	public ModelAndView error(ArithmeticException e) {
		log.info("errorMsg : {} ", e.getMessage());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errMsg", e.getMessage());
		mv.addObject("errClass", e.getClass().getName());
		mv.addObject("statusCode", HttpStatus.BAD_REQUEST);
		
		mv.setViewName("error/errorView");//WEB-INF/views/error/errorView.jsp
	    return mv;
		
	}*/
	
	/////////////////////////////////////////
	/**
	 * 나이 체크 기능
	 * */
	@RequestMapping("/ageCheck.do")
    public String ageCheck(@RequestParam(defaultValue = "0") int age) {
		log.info("age ={}" , age);
		
		//전달받은 age를 서비스에 전달해서 호출한다.
		userService.ageCheck(age);
		
		
		return "result";
	}
	
	/**
	 * 아이디 체크 기능
	 * */
	@GetMapping("/idCheck.do")
	public String idCheck(String id) {
		log.info("id ={}" , id);
		
		userService.idCheck(id);
		
		return "result";
	}

}












