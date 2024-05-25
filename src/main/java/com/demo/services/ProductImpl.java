package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Product;

@Service
public class ProductImpl implements ProductService {

	@Override
	public Product find() {
		// TODO Auto-generated method stub
		return new Product(1, "Mai Phuong", "IMG_0623.JPG", new Date(), 4.5, 2);
	}

	@Override
	public List<Product> findall() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Mai Phuong", "IMG_0623.JPG", new Date(), 4.5, 2));
		products.add(new Product(2, "Mai Phuong 1", "IMG_0623.JPG", new Date(), 5.5, 3));
		products.add(new Product(3, "Mai Phuong 2", "IMG_0623.JPG", new Date(), 6.5, 5));
		return products;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Mai Phuong", "IMG_0623.JPG", new Date(), 4.5, 2));
		products.add(new Product(2, "Mai Phuong 1", "IMG_0623.JPG", new Date(), 5.5, 3));
		products.add(new Product(3, "Mai Phuong 2", "IMG_0623.JPG", new Date(), 6.5, 5));
		for (Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

}
