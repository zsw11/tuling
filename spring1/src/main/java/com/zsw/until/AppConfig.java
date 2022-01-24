package com.zsw.until;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;

/**
 * @author 54623
 * @date 2022/1/24 21:40
 */
public class AppConfig {
    // 自动代理 BeanPost
	@Bean
	public BeanNameAutoProxyCreator creator(){
		// BeanPostProcessor
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("userService");  // bean==>AOP
		beanNameAutoProxyCreator.setInterceptorNames("myAdvisor");
		return beanNameAutoProxyCreator;
	}
}
