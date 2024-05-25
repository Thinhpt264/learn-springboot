package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Item;
import com.demo.entities.Product;
import com.demo.services.CaculateService;
import com.demo.services.CartService;
import com.demo.services.DemoService;
import com.demo.services.ProductService;
import com.demo.services.RectangleService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping({"", "index"  })
	public String Index(HttpSession session ,ModelMap modelMap) {
		if(session.getAttribute("cart") != null ) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			modelMap.put("cart", cart);
			modelMap.put("total", cartService.total(cart));
		}
		return "cart/index";
	}
	
	@GetMapping({"buy/{id}"})
	public String Buy(@PathVariable("id") int id, HttpSession session) {
		Product product = productService.findById(id);
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(product, 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = cartService.exist(id, cart);
			if(index == -1) {
				cart.add(new Item(product, 1));
				
			}else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				
			}
			session.setAttribute("cart", cart);
			
		}
		return "redirect:/cart/index";
	}
	
	@GetMapping({"remove/{index}"})
	public String Remove(@PathVariable("index") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	@PostMapping({"update"})
	public String Update(@RequestParam("quantities") int[] quantities, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(quantities[i]);
		}
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
}
