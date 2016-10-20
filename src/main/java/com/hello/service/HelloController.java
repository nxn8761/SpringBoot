package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.dao.CUSTDAO;

@RestController
public class HelloController {
    
	@Autowired
	private CUSTDAO cUSTDAO;
	
	// url: http://localhost:8081/testurl
	
	// https://springboot-ws-qa.apps-np.homedepot.com/testurl
	
    @RequestMapping("/testurl")
    public String index() {
    	
    	/** DAO Connection */
    	
    	cUSTDAO.getDetails();
    	cUSTDAO.test();
    	
        return "Greetings from Spring Boot! ";
    }
    
}
