package com.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileHelper;
@Controller
@RequestMapping("demo4")
public class Demo4Controller {
	@GetMapping({"","index", "/"})
	public String  index(ModelMap modelMap) {
		
		return "demo4/index";
	}
	@GetMapping({"index2"})
	public String  index2(ModelMap modelMap) {
		
		return "demo4/index2";
	}
	@PostMapping({"upload"})
	public String  upload(@RequestParam("file") MultipartFile file) {
		try {
			System.out.println("File info");
			System.out.println("name: " + file.getOriginalFilename());
			System.out.println("file size (byte): " + file.getSize());
			System.out.println("type file: " + file.getContentType());
			
			// upload file
			String filename = FileHelper.generateFileName(file.getOriginalFilename());
			File imagesFolder = new ClassPathResource("static/assets/images").getFile();
			Path path = Paths.get(imagesFolder.getAbsolutePath() + File.separator + filename);
			System.out.println(path.toString());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/demo4/index2";
	}
	
	@PostMapping({"uploads"})
	public String  uploads(@RequestParam("files") MultipartFile[] files) {
		try {
			if(files != null && files.length > 0) {
				System.out.println("files: " + files.length);
				for (MultipartFile file : files) {
					System.out.println("name: " + file.getOriginalFilename());
					System.out.println("file size (byte): " + file.getSize());
					System.out.println("type file: " + file.getContentType());
					System.out.println("-----------------------------------");
					// upload file
					String filename = FileHelper.generateFileName(file.getOriginalFilename());
					File imagesFolder = new ClassPathResource("static/assets/images").getFile();
					Path path = Paths.get(imagesFolder.getAbsolutePath() + File.separator + filename);
					System.out.println(path.toString());
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				}
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/demo4/index2";
	}
	
	@GetMapping({"searchbykeyword"})
	public String  searchByKeyWord(@RequestParam("keyword") String keyword) {
		System.out.println("keyword: " + keyword);
		return "redirect:/demo4/index";
	}
	
	@GetMapping({"searchbyprices"})
	public String  searchByPrices(@RequestParam("min") int min , @RequestParam("max") int max) {
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		return "redirect:/demo4/index";
	}
	@PostMapping({"login"})
	public String Login(@RequestParam("username") String username ,
			@RequestParam("password") String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return "redirect:/demo4/index";
	}
	@PostMapping({"update"})
	public String Update1(@RequestParam("emails") String[] emails) {
		for (String string : emails) {
			System.out.println(string + " ");
		}
		return "redirect:/demo4/index";
	}
	
}
