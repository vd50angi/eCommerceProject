package com.cogent.ecommerce.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.cogent.emsmongodb.utils.BeanTwo;

public class BeanOne {
	BeanTwo beanTwo;
	@Autowired
	public BeanOne(BeanTwo beanTwo ) {
	      
		//this.beanTwo = beanTwo;
		
		System.out.println("BeanOne Initialized");
	   
	}

	

	public void doSomthing() {
	   
		System.out.println("Inside doSomthing() method of BeanOne");
	   }
	
	
	
	
	
	
	
	

}
