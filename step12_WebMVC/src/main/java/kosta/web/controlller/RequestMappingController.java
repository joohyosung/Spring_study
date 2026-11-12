package kosta.web.controlller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller //생성 id="requestMappingController"
@RequestMapping("/rem")
public class RequestMappingController {
	
	@RequestMapping("/a.do")
	public ModelAndView aa() {
		System.out.println("a.do 요청됨...");
		
		///WEB-INF/views/result.jsp이동하고 그쪽의 message전달
		return new ModelAndView("result", "message", "SpringWebMVC 시작~~");
	}
	/**
	 * return : void인경우는 요청된 주소가 뷰이름이 된다.
	 *  ex) rem/b.do 요청이되면 뷰이름은 rem/b 가된다. 
	 *  
	 * @param : Model은 뷰쪽으로 전달될 데이터를 저장하기위한 객체
	 * */
	@RequestMapping({"/b.do","/c.do"})
	public void test(Model model) {
		System.out.println("rem/b.do 요청됨..");
		
		//model에 저장을 하면   requestScope에 저장된다. -> 이동방식 forward 
		model.addAttribute("message", "재미있다"); //${message}
		model.addAttribute("list", Arrays.asList("A","B","C")); //${list}
	}
	
	
	/**
	 *  @return : String인경우는 리턴값이 뷰이름이된다.
	 *  
	 *  @RequestMapping은 요청방식 구분없이 처리하는것,
	 *  만약 요청방식(http method= get,post,delete, patch,put)을 구분하고 싶다면
	 *  @GetMapping
	 *  @PostMapping
	 *  @PutMapping
	 *  @PatchMapping
	 *  @DeleteMapping
	 *  
	 * */
	//@RequestMapping("/test.do")
	@GetMapping("/test.do") //요청방식이 get일경우에만 
	public String test(HttpServletRequest request)throws Exception {
		
		String name = request.getParameter("name");
		System.out.println("name = "+ name);
		
		return "result";// WEB-INF/views/result.jsp이동
	}
	
	@PostMapping("/test.do") //요청방식이 get일경우에만 
	public String test2(HttpServletRequest request)throws Exception {
		
		String name = request.getParameter("name");
		System.out.println("name = "+ name);
		
		return "home";// WEB-INF/views/home.jsp이동
	}
	
	@RequestMapping(value = "/a.do", params = {"id"})
	public String test3(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id = "+ id);
		
		System.out.println("params설정입니다.");
		return "result";
	}

}











