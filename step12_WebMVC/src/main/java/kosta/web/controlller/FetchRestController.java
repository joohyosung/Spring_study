package kosta.web.controlller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kosta.web.dto.MemberDTO;
import kosta.web.dto.ProductDTO;
import kosta.web.dto.UserDTO;
import kosta.web.exception.AjaxException;
import kosta.web.exception.ErrorInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController//A convenience annotation that is itself annotated with @Controller and @ResponseBody. 
@Slf4j
@RequiredArgsConstructor
public class FetchRestController {
	
	private final List<ProductDTO> list;

	@PostMapping("/ajax.do")
	//public UserDTO ajax(String email, String pwd) {
	public UserDTO ajax(MemberDTO dto) {
		//log.info("email:{} , pwd:{}", email, pwd);
		log.info("dto ={} ", dto);
		
		
		return UserDTO.builder()
				.id("jang")
				.name("희정")
				.addr("서울")
				.age(20).build();
	}
	//////////////////////////
	/**
	 * front단에서 
	    headers: {
	      "Content-Type": "application/json"
	    }
	    설정되면 @RequestBoday 필요하다.
	 * */
	
	@PostMapping("/ajax2.do")
	public List<ProductDTO> ajax2(@RequestBody UserDTO dto) {
		//log.info("email:{} , pwd:{}", email, pwd);
		log.info("dto ={} ", dto);
		
		
		return list;
	}
	
	/////////////////////////////////////////
	@PostMapping("/ajax3.do")
	public ResponseEntity<?> ajax3(@RequestBody UserDTO userDto){
		log.info("userDto ={} ", userDto);
		
		if(userDto.getAge() < 18) {
			throw new AjaxException(ErrorInfo.INVALID_AGE);
		}
		
		
		//return ResponseEntity.ok(list);
		
		List<String> menuList = Arrays.asList("짬뽕","짜장","탕수육");
		
		return ResponseEntity.ok(menuList);
	}
}














