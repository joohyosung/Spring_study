package kosta.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.web.dto.ProductDTO;
import kosta.web.exception.BasicException;
import kosta.web.exception.ErrorInfo;
import lombok.extern.slf4j.Slf4j;

@Service //id="userServiceImpl"
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
   private List<ProductDTO> list;
	
	public UserServiceImpl() {
		System.out.println(11111);
		log.info("생성....");
	}

	@Override
	public void ageCheck(int age) throws BasicException {
		log.info("list = {}", list);
		
		log.info("age ={}" , age);
		if(age <= 18)throw new BasicException(ErrorInfo.INVALID_AGE);

	}

	@Override
	public void idCheck(String id) throws BasicException {
		//기능
		log.info("id ={}" , id);
		if("jang".equals(id)) throw new BasicException(ErrorInfo.INVALID_ID);
		
	}

}
