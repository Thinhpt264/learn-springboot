package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Language;

@Service
public class LanguageImlp implements LanguageService {

	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language(1, "VN"));
		languages.add(new Language(2, "US"));
		languages.add(new Language(3, "UK"));
		languages.add(new Language(4, "Thailand"));
		return languages;
	}

	@Override
	public Language find() {
		// TODO Auto-generated method stub
		return new Language(5, "Language 6");
	}
	
}
