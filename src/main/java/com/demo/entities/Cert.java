package com.demo.entities;

public class Cert {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cert(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Cert() {
		super();
	}
	
	 
}
