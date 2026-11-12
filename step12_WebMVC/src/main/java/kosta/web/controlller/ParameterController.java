package kosta.web.controlller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/param")
@Slf4j
public class ParameterController {
	
	//Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/a.do")
	//public String aa(String name, int age) {
	public String aa(String name, Integer age) {
		System.out.println("param/a.do요청됨...");
		
		int re = age+1;
		
		System.out.println("name = "+ name);
		System.out.println("age = " + age);
		
		return "result";//WEB-INF/views/result.jsp
	}
	
	@GetMapping("/b.do")
	public void bb(@RequestParam(defaultValue = "Guest", 
	                              value ="userId" ) String id, 
			       @RequestParam(defaultValue = "0") int age) {// WEB-INF/views/param/b.jsp동
		
		System.out.println("id = "+ id);
		System.out.println("age = " + age);
		
		System.out.println("param/b.do요청..");
	}
	
	/**
	 * 매개변수로 객체(Dto or v)를 받으면
	 * 매변수 앞에 @ModelAttribute 선언된다.
	 * view에 전달되는 데이터가 바인되고
	 * 그 바인딩 된 객체를 뷰에서 사용 할수 있다.
	 * 사용방법 -> 클래스이름의 첫글자만 소문자
	 *    ex) UserDTO ->  ${userDTO.속성}
	 *   
	 * */
	@PostMapping("/user.do")
	//public void user(UserDTO user) {
	public void user(@ModelAttribute("dto") UserDTO user) {
		//System.out.println("user = "+ user);
		log.info("user = {}", user);
		
	}
	
	@ModelAttribute("menu")
	public List<String> info(){
		return Arrays.asList("짜장","짬뽕","만두");
	}
	
	@ModelAttribute("mes")
	public String mes(){
		return "졸립다";
	}

}








