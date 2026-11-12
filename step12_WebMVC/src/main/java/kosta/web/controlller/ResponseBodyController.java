package kosta.web.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kosta.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Controller // 생성
@Slf4j
public class ResponseBodyController {

	@GetMapping("/responseBody.do")
	@ResponseBody //HttpMessageConvert동작에 의해 리턴값이 응답 body가된다
	public String responseBody() {
		log.info("여기 오니???");
		
		return "have a nice day!";
	}
	
	@GetMapping("/responseBody2.do")
	@ResponseBody
	public UserDTO responseBody2() {
		log.info("responseBody2 call....");
		
		return UserDTO.builder()
				.id("jang")
				.name("희정")
				.addr("서울")
				.age(20).build();
		
	}
}
