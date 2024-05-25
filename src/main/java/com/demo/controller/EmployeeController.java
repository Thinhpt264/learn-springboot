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
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private CertService certService;
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("register")
	public String register(ModelMap modelMap) {
		modelMap.put("certs", certService.findAll());
		modelMap.put("languages", languageService.findAll());
		modelMap.put("roles", roleService.findAll());
		Employee employee = new Employee();
		employee.setUsername("acc1");
		employee.setPassword("123");
		employee.setDescription("asdasdasdasdadss");
		employee.setDob(new Date());
		employee.setStatus(false);
		employee.setGender("m");
		employee.setCert(2);
		employee.setLanguages(new int[] {1,3,4});
		employee.setRole(3);
		employee.setId(123);
		employee.setAddress(new Address("123duong so 3" , "aaaa"));
		modelMap.put("employee", employee);
		return "employee/register";
	}
	
	@PostMapping("register")
	public String registering(@ModelAttribute("employee") Employee employee) {
		System.out.println("Employee Info");
		System.out.println("username: " + employee.getUsername());
		System.out.println("password: " + employee.getPassword());
		System.out.println("Description: " + employee.getDescription());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("dob: " + simpleDateFormat.format(employee.getDob()));
		System.out.println("status: " + employee.isStatus());
		System.out.println("Languages");
		for(int LanguageId : employee.getLanguages()) {
			System.out.println(LanguageId);
		}
		System.out.println("role: " + employee.getRole());
		System.out.println("Street: " + employee.getAddress().getStreet());
		System.out.println("Ward: " + employee.getAddress().getWard());
		return "redirect:/employee/register";
	}
	
}
