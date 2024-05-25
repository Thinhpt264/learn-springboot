package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectangleImpl implements RectangleService {
	@Autowired
	private CaculateService caculateService;
	
	@Override
	public double area(double a, double b) {
		// TODO Auto-generated method stub
		return caculateService.mul(a, b) ;
	}

	@Override
	public double perimeter(double a, double b) {
		// TODO Auto-generated method stub
		return caculateService.mul(caculateService.add(a, b), 2);
	}

}
