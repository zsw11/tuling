package com.zsw.service;

import org.springframework.stereotype.Component;

/**
 * @author 54623
 * @date 2022/1/24 21:28
 */
@Component
public class UserService {
    public UserService() {
        System.out.println("构造方法--------------------");
    }

    public void test() {
        System.out.println(" -------------------test");
    }
}
