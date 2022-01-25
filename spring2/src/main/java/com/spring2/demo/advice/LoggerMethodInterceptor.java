package com.spring2.demo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerMethodInterceptor implements MethodInterceptor {

	// 可以理解为环绕通知，可以更加自由的控制是在方法执行前，后进行调用
	@Override
	public Object invoke(MethodInvocation i) throws Throwable {
		System.out.println("method "+i.getMethod()+" is called on "+
				i.getThis()+" with args "+i.getArguments());
		Object ret=i.proceed();
		System.out.println("method "+i.getMethod()+" returns "+ret);
		return ret;
	}
}
