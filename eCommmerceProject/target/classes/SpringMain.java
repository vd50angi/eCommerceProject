import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cogent.ems.mongodb.config.Config;

public class SpringMain {
	
	@Component
	public static void main(String[] args) {
		
		
		
		//to get that object
		//we have  2 ways ( this 2 ways are containers ==> where containers will manage the object life cycle
		//bean factory
		//application context
		//if you dont want to provide bean name  then provide the expected bean name as a method name which dataSource with lowercase
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
	
	DataSource dataSource =applicationContext.getBean("dataSource",DataSource.class);
	/*if u will no tprovide any name to the bean thenn 
	 *  by default it will take  methoid as bean name*/
	
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.hashCode());
	DataSource dataSource2 = applicationContext.getBean("dataSource",DataSource.class);
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.equals(dataSource2));
	
	
	}
	
	
	

}

	
	
	
	

}
