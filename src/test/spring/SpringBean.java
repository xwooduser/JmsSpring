package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author issuser
 *
 */
public class SpringBean<O> {
	
	public static ApplicationContext context;
	
	static{
		 context = new ClassPathXmlApplicationContext(
		"classpath:spring/spring.xml");
	}
	
	public static Object getBean(String id){
		return (Object)context.getBean(id);
	}
	
	public O getBean_(String id){
		
		return (O)context.getBean(id);
	}

}
