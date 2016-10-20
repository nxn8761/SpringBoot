package com.hello.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hello.beans.Cricket;
import com.hello.beans.XMLResponse;

@RestController
public class JsonResponseController {

	@RequestMapping(value ="/xmlResponse",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<XMLResponse> jsonResponse()
	{
		List<Cricket> responseList = new ArrayList<Cricket>();
		Cricket cricket =  new Cricket();
		cricket.setBall("SG");
		cricket.setBat("MRF");
		cricket.setDob(getSQLDateinMMDDYYYYFromString("2015-12-01"));
		responseList.add(cricket);
		
		cricket =  new Cricket();
		cricket.setBall("CORK");
		cricket.setBat("WILLS");
		cricket.setDob(getSQLDateinMMDDYYYYFromString("2014-11-01"));
		
		responseList.add(cricket);
		XMLResponse response = new XMLResponse();
		response.setCricketList(responseList);
		
		return new ResponseEntity<XMLResponse>(response,HttpStatus.OK);
		//return responseList;
	}
	
	@RequestMapping(value="/receiveJSON", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void receiveJSON(@RequestBody List<Cricket> cricketList)
	{
		System.out.println(cricketList.get(0).getBall());
		System.out.println(cricketList.get(1).getBall());
	}
	
	@RequestMapping(value="/receiveXML", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<XMLResponse> receiveXML(@RequestBody XMLResponse xmlResponse)
	{
		return new ResponseEntity<XMLResponse>(xmlResponse,HttpStatus.OK);
		
	}
	
	public static java.sql.Date getSQLDateinMMDDYYYYFromString(String dateString)
	  {
	    SimpleDateFormat sdf = null;
	    java.sql.Date sqlDate = null;
	    try 
	    {
	    	sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	sqlDate = new java.sql.Date(sdf.parse(dateString).getTime());
	    } 
	    catch (Exception e) 
	    {
	    	
	    }
	   return sqlDate;
   }
	   
}
