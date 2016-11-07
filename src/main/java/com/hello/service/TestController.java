package com.hello.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hello.beans.Cricket;
import com.hello.beans.XMLResponse;
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
	
	
	// tutorial:  http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/ 
	
	// GET call
	public static void getEmployees()
	{
	    final String uri = "http://localhost:8081/xmlResponse";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
	
	// POST call with Automatic conversion 
	public static void getEmployeesPostDemoWithAutoConversion()
	{
	    final String uri = "http://localhost:8081/jsonResponse";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    XMLResponse result = restTemplate.postForObject(uri, HttpMethod.POST,XMLResponse.class);
	     
	    
	    for(Cricket c:result.getCricketList())
	    {
	    	System.out.println(c.getBall() + " "+ c.getBat());
	    }
	}
	
	// POST call with string response
	
	public static void getEmployeesPostDemo()
	{
	    final String uri = "http://localhost:8081/jsonResponse";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.postForObject(uri, HttpMethod.POST,String.class);
	     
	    System.out.println("getEmployeesPostDemo METHOD() " + result);
	    
	}
	
	// REQUEST WITH HEADERS
	public static void getEmployeesWithHeader()
	{
	    final String uri = "http://localhost:8081/xmlResponse";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	     
	    System.out.println(" getEmployeesWithHeader METHOD() " + result.getBody());
	}
	
	
	// REQUEST WITH HEADERS AND REQUEST OBJECT -- didnt test
	private static void getEmployeesWithHeaderAndRequestObject()
	{
	    final String uri = "http://localhost:8081/xmlResponse";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<XMLResponse> result = restTemplate.exchange(uri, HttpMethod.POST, entity, XMLResponse.class);
	     
	    System.out.println(result);
	}
	
}
