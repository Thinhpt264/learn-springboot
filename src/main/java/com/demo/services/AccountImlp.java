package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Account;

@Service
public class AccountImlp implements AccountService {
	private List<Account> accounts;
		
	
	public AccountImlp() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account("acc1", "123", "Name 1"));
		accounts.add(new Account("acc2", "456", "Name 2"));
		accounts.add(new Account("acc3", "123", "Name 3"));
	}


	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		for (Account account : accounts) {
			if(account.getUsername().equalsIgnoreCase(username) && account.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		}
		
		return false;
	}

}
