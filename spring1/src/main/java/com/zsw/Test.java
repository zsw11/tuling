package com.zsw;

import com.zsw.aspect.MyAspect;
import com.zsw.service.UserService;
import com.zsw.until.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(UserService.class, MyAspect.class);
		UserService aService = applicationContext1.getBean("userService", UserService.class);
		aService.test();

	}
}