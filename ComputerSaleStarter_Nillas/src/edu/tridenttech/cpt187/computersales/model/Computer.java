package edu.tridenttech.cpt187.computersales.model;

public class Computer {
	private String name;
	private String model;
	private String description;
	private double price;

	// NOTE: the constructor should NOT be public
	Computer(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	// TODO -- turn this into a copy constructor
	// NOTE: the constructor should NOT be public
	Computer() {
	}

	public double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
