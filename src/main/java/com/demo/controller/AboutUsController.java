package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entities.Address;
import com.demo.entities.Employee;
import com.demo.services.CertService;
import com.demo.services.LanguageService;
import com.demo.services.RoleService;

@Controller
@RequestMapping("aboutus")
public class AboutUsController {
	@GetMapping({"", "index", "/"})
	public String index() {
		
		return "aboutus/index";
	}
}
