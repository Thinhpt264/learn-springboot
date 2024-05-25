package com.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entities.Product;

@Controller
@RequestMapping("demo2")
public class Demo2Controller {
//	@RequestMapping(value = {"", "index" , "/"}, method = RequestMethod.GET)
	@GetMapping({"", "index", "/"})
	public String  index(ModelMap modelMap) {
		Product product = new Product(1, "Mai Phuong", "IMG_0623.JPG", new Date(), 4.5, 2);
		modelMap.put("product", product);
		return "demo2/index";
	}
	
	@GetMapping({"index2"})
	public String  index2(ModelMap modelMap) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Mai Phuong", "IMG_0623.JPG", new Date(), 4.5, 2));
		products.add(new Product(2, "Mai Phuong 1", "IMG_0623.JPG", new Date(), 5.5, 3));
		products.add(new Product(3, "Mai Phuong 2", "IMG_0623.JPG", new Date(), 6.5, 5));
		modelMap.put("products", products);
		return "demo2/index2";
	}
}
