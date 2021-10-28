package com.cogent.ecommerce.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

public class DBConfig {
	
	@Configuration
	@PropertySource("classpath:application.properties")

	
		
		
			
			//db related
				@Autowired //this anotation this will help u enrollment object to the spring
				           //**autowired did singleton environment & confuguration all at one
				Environment environment; //getinstance(); //is an interface..to get the property values /thid the reference of type interface
				 //we need object , created by spring/ we need  need to inform spring  the environmenttal object
				/* do we need already created object from the spring? inject the already created object/  Dependency injection (DI)*/
				//spring will bring autowired
				
				// data source==.1
				//singleton object
				//@Bean//used to get /hold singleton object
				

				//methhod level annotation
				@Bean//used to get /hold singleton object
				
				public DataSource getDataSource() {
				BasicDataSource basicDataSource = new BasicDataSource();
				basicDataSource.setUrl(null);
			    basicDataSource.setUsername(null);
			    basicDataSource.setPassword(null);
			    basicDataSource.setDriver(null);
				return basicDataSource;
			    
					
					
				}

		

		}
		
		
		
		
		
		
		
		



	
	
	
	

}
