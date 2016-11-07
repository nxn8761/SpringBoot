package com.hello;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // @Configuration, @EnableAutoConfiguration and @ComponentScan
//@ComponentScan("org.springframework.controllers")
public class Application
{
	@Value("${app.name}")
	public String appName;
	
	
	 public static void main(String[] args) {
	        ApplicationContext ctx = SpringApplication.run(Application.class, args);
	        
	        System.out.println("hello world");
	        
	        System.out.println("hello world");
	        
	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	           // System.out.println(beanName);
	        }
	    }
	 
	 
	 @PostConstruct
		public void postConstructs()
		{
		 	int a= 3;
		 	int b=5;
		 	int c = a+b;
		 	
		 	System.out.println(appName + "c is "+ c);
		}
}


