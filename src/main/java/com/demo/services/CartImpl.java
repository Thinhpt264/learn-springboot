package com.demo.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Item;

@Service
public class CartImpl implements CartService {

	@Override
	public int exist(int id, List<Item> cart) {
	for (int i= 0 ; i < cart.size() ; i++) {
		if(cart.get(i).getProduct().getId() == id) {
			return i;
		}
	}
		return -1;
	}

	@Override
	public double total(List<Item> cart) {
		double total = 0;
		for (Item item : cart) {
			total += item.getProduct().getPrice()*item.getQuantity();
		}
		return total;
	}

}
