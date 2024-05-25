package com.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"demo", "abc", ""})
public class DemoController {
	
	@RequestMapping(value = {"", "index", "def"}, method = RequestMethod.GET)
	public String  index(ModelMap modelMap) {
		modelMap.put("id", 124);
		modelMap.put("username", "acc1");
		modelMap.put("status", true);
		modelMap.put("price", 4.5);
		modelMap.put("quantity", 2);
		modelMap.put("photo", "IMG_0623.JPG");
		modelMap.put("width", 70);		
		modelMap.put("height", 100);		
		modelMap.put("today", new Date());	
		List<String> names = new ArrayList<>();
		names.add("name 1");
		names.add("name 2");
		names.add("name 3");
		names.add("name 4");
		modelMap.put("names", names);
		return "demo/index";
	}
	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public String index2() {
		return "demo/index2";
	}
	@RequestMapping(value = "index3/{id}", method = RequestMethod.GET)
	public String index3(@PathVariable("id") int id) {
		System.out.println("id: " + id);
		return "demo/index3";
	}
	@RequestMapping(value = "index4/{id}/{username}", method = RequestMethod.GET)
	public String index4(@PathVariable("id") int id,
			@PathVariable("username") String username) {
		System.out.println("id: " + id);
		System.out.println("username: " + username);
		return "demo/index3";
	}
	@RequestMapping(value = "index5", method = RequestMethod.GET)
	public String index5(@RequestParam("id") int id, @RequestParam("username") String username) {
		System.out.println("id: " + id);
		System.out.println("username: " + username);
		return "demo/index3";
	}
}
