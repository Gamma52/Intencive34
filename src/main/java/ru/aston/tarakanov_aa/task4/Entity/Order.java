package ru.aston.tarakanov_aa.task4.Entity;

public class Order {
	private long id;
	private String product;
	private double weight;
	private double price;
	
	public Order(String pruduct, double weight, double price) {	
		this.product = pruduct;
		this.weight = weight;
		this.price = price;
	}
	  
	public Order(long id, String pruduct, double weight, double price) {
		this.id = id;
		this.product = pruduct;
		this.weight = weight;
		this.price = price;
	}
	
	public long getId() {
		return this.id;
	}
	  
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	  

}
