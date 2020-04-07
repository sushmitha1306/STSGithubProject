package com.wipro.Sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long id;
	@ApiModelProperty(notes = "The name of product")
	private String name;
	@ApiModelProperty(notes = "The product brand")
	private String brand;
	@ApiModelProperty(notes = "The product origin")
    private String madein;
	@ApiModelProperty(notes = "The price of product")
    private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
				+ "]";
	}
	public Product(String name, String brand, String madein, double price) {
		super();
		
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
