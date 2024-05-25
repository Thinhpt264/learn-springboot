package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Account;
import com.demo.entities.Product;
import com.demo.services.AccountService;
import com.demo.services.ProductService;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "ajax1", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax1() {
		return "Hello Ajax";
		
	}
	
	@GetMapping(value = "ajax2", produces = MimeTypeUtils.TEXT_HTML_VALUE)
	public String ajax2() {
		return "<b> <u>Hello Ajax </u> </b>";
		
	}
	
	@GetMapping(value = "ajax3", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax3(@RequestParam("keyword") String keyword) {
		return "keyword " + keyword;
		
	}
	
	@GetMapping(value = "ajax4", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax4(@RequestParam("min") double min , @RequestParam("max") double max ) {
		return "Min: " + min + ", Max: " + max  ;
		
	}
	
	@PostMapping(value = "login", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax5(@RequestParam("username") String username , @RequestParam("password") String password ) {
		return accountService.login(username, password) ? "Valid" : "Invalid";
		
	}
	
	@GetMapping(value = "find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public Product find() {
		return productService.findById(1);
		
	}
	
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<Product> findAll() {
		return productService.findall();
		
	}
	
}
