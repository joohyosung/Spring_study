package kosta.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kosta.web.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice//A convenience annotation that is itself annotated with @ControllerAdvice and @ResponseBody
@Slf4j
public class GlobalAjaxExceptionHandler {
	
	@ExceptionHandler(AjaxException.class)
	public ResponseEntity<?> error(AjaxException e){
		log.info("msg = {}" , e.getErrorInfo().getMessage());
		
		ResponseDTO dto = 
				ResponseDTO
				.builder()
				.status(e.getErrorInfo().getStatus())
				.msg(e.getErrorInfo().getMessage())
				.build();
		
		return ResponseEntity
				.status(e.getErrorInfo().getStatus())
				.body(dto);
	}

}
