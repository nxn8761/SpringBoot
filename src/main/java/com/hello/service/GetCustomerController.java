package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hello.dao.CustomersDAO;


// URL : http://localhost:8081/getCustomers

@RestController
public class GetCustomerController
{
	
	@Autowired
	CustomersDAO dao;
	
	@RequestMapping(value="getCustomers", method = RequestMethod.POST)
	public void getCustomers()
	{
		dao.getCustomerDetails();
	}
}