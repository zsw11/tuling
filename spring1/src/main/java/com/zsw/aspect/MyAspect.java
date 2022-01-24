package com.zsw.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 54623
 * @date 2022/1/24 21:13
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(public void com.zsw.service.UserService.test())")
    public void lubanBefore() {
        System.out.println("aop功能");
    }
}

