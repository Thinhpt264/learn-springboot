package com.demo.services;

import org.springframework.stereotype.Service;

@Service("caculateService")
public class CaculateImpl implements CaculateService{

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}
	
	
}
