package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Language;
import com.demo.entities.Role;

@Service
public class RoleImlp implements RoleService {

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(1, "Role 1"));
		roles.add(new Role(2, "Role 2"));
		roles.add(new Role(3, "Role 3"));
		roles.add(new Role(4, "Role 4"));
		return roles;
	}
	
}
