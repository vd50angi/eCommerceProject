package com.cogent.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cogent.ems.mongodb.config.DBConfig;
import com.cogent.emsmongodb.utils.BeanOne;
import com.cogent.emsmongodb.utils.BeanTwo;

	@Configuration
	@ComponentScan("com.cogent.ems.mongodb")
	@Import(DBConfig.class)
	public class Config {
	//application specific
		@Autowired
		BeanTwo beanTwo;
		
		@Bean("beanOne") // the pourpose if "bean one" is to let that bean know wht bean are u suing or elsew it will goes as default
		   //@Lazy(value = true)//load the bean /create object lazily
		   public BeanOne getBeanOne() {
		     
			return new BeanOne(beanTwo);
		   }

		   @Bean("beanTwo")
		   public BeanTwo getBeanTwo() {
		      return new BeanTwo();
		   }

	}

	
	
	
	
	

}
