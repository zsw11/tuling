package com.spring2.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LubanAspect {

	@Pointcut("com.luban.aop.aspect.LubanAspect.test()")
	public void test() {

	}
}
