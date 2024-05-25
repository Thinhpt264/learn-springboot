package com.demo.entities;

public class City {
	private int id;
	private String name;
	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	public City() {
		super();
	}
	
	
	
}
