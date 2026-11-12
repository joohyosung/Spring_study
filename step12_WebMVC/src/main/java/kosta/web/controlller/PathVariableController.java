package kosta.web.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PathVariableController {

	@RequestMapping({"/{type}/{id}.do"})
	public void aa(@PathVariable String type, @PathVariable String id) {
		log.info("여기 오니??");
		log.info("type={}, id={}", type, id);
	}
	
	
	@GetMapping("/{id}")  // 
	public String bb(@PathVariable String id) {
		log.info("id={}", id);
		
		return "result";
	}
	
	////////////////////////////////
	@RequestMapping("/{type}/{kind}/{no}")
	public String cc(
			@PathVariable("type") String userType,
			@PathVariable String kind,
			@PathVariable int no) {
		log.info("cc method call userType:{}",userType);
		log.info("cc method call kind:{}",kind);
		log.info("cc method call no:{}",no);
		
		//기능을 완료 한후에  다른 Controller를 실행하고 싶다.
		/*
		 * viewName에 
		 *  1) redirect:url주소  
		 *  2) forward:url주소
		 */
		
		//return "rem/a.do";///WEB-INF/views/rem/a.jsp 이동
		
		return "redirect:/rem/a.do";
		//return "forward:/rem/a.do";
		
	}
	
	
}








