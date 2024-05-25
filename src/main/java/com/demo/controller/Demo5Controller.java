package com.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Language;
import com.demo.helpers.FileHelper;
import com.demo.services.LanguageService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("demo5")
public class Demo5Controller {
	
	@Autowired
 	 private LanguageService languageService;
	
	@GetMapping({"","index", "/"})
	public String  index(HttpSession session) {
		session.setAttribute("id", 1234);
		session.setAttribute("username", "acc1");
		session.setAttribute("language", languageService.find());
		session.setAttribute("languages", languageService.findAll());
		//Huy session
		session.removeAttribute("username");
		return "redirect:/demo5/index2";
	}
	@GetMapping({"index2"})
	public String  index2(HttpSession session) {
		if(session.getAttribute("id") != null) {
			int id = Integer.parseInt(session.getAttribute("id").toString());
			System.out.println("id: " + id);
		}
		if(session.getAttribute("username") != null) {
			String username = session.getAttribute("username").toString();
			System.out.println("username: " + username);
		}
		if(session.getAttribute("language") != null) {
			Language language = (Language) session.getAttribute("language");
			System.out.println(language.toString());
		}
		
		if(session.getAttribute("languages") != null) {
			List<Language> languages = (List<Language>) session.getAttribute("languages");
			System.out.println("Print Language List");
			for (Language language : languages) {
				System.out.println(language.toString());
			}
			
		}
		
		return "demo5/index";
	}
	@GetMapping({"index3"})
	public String  index3(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("msg", "Done");
		return "redirect:/demo5/index4";
	}
	@GetMapping({"index4"})
	public String  index4(HttpSession session) {
		
		return "demo5/index2";
	}
}
