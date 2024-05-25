package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.services.CaculateService;
import com.demo.services.DemoService;
import com.demo.services.ProductService;
import com.demo.services.RectangleService;
@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"", "index"  })
	public String Index(ModelMap modelMap) {
		modelMap.put("products", productService.findall());
		return "product/index";
	}
	
	@GetMapping("detail/{id}")
	public String details(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("product", productService.findById(id));
		return "product/details";
	}
}
