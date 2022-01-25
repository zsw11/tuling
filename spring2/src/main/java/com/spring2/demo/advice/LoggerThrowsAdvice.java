package com.spring2.demo.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LoggerThrowsAdvice implements ThrowsAdvice {

	// 当方法执行出现异常时执行，异常抛出增强
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("aop throwing");
	}
}
