package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Cert;

@Service
public class CertImlp implements CertService{

	@Override
	public List<Cert> findAll() {
		List<Cert> certs = new ArrayList<Cert>();
		certs.add(new Cert(1, "aaaa"));
		certs.add(new Cert(2, "bbbb"));
		certs.add(new Cert(3, "cccc"));
		// TODO Auto-generated method stub
		return certs;
	}
	
}
