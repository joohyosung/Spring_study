package kosta.web.service;

import kosta.web.exception.BasicException;

public interface UserService {
   /**
    * check age
    * */
	void ageCheck(int age)throws BasicException;
	
	/**
	 * check id duplicate
	 * */
	void idCheck(String id) throws BasicException;
}
