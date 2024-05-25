package com.demo.services;

import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService{
	@Override
	public String Hello() {
		return "Hello World";
	}
	
	public String hi(String fullname) {
		return "hi " + fullname;
	}
	
}
