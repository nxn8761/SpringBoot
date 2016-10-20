package com.hello.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController
{

	@RequestMapping(value= "/welcome", method=RequestMethod.POST)
	public String welcomeMethod()
	{
		return "Welcome Greetings!!";
		
	}
}
