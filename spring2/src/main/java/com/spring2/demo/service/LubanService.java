package com.spring2.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LubanService {

	public User test() {
		System.out.println("===");
		return new User("xxx");
	}
}
