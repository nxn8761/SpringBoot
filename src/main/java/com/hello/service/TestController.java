package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.dao.TemplateDAO;

@RestController
public class TestController
{
	@Autowired
	TemplateDAO templateDAO;
	
	
	@RequestMapping("/testMethod")
	public void testMethod() throws Exception 
	{
		System.out.println("testMethod");
		templateDAO.getDetails();
		templateDAO.getDetailsByusingNamedParameterTemplate();
		templateDAO.insertByTemplate(); 
	}
}
