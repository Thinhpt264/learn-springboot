package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.services.CaculateService;
import com.demo.services.DemoService;
import com.demo.services.RectangleService;
@Controller
@RequestMapping("demo3")
public class Demo3Controller {
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private CaculateService caculateService;
	
	@Autowired
	private RectangleService rectangleService;
	@GetMapping( {"", "index", "/"} )
	public String Index(ModelMap modelMap) {
		modelMap.put("msg1", demoService.Hello());
		modelMap.put("msg2", demoService.hi("Mai Phuong"));
		modelMap.put("result1", caculateService.add(1.2, 2.8));
		modelMap.put("result2", caculateService.mul(1.3, 1.8));
		modelMap.put("area", rectangleService.area(3, 4));
		modelMap.put("perimeter", rectangleService.perimeter(3, 4));
		
		return "demo3/index";
	}
	
	@GetMapping({"index3"})
	public String index3() {
		return "demo3/index3";
	}
	
}
