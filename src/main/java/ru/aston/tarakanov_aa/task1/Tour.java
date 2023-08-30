package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

public abstract class Tour implements Discount{
	private BigDecimal avgPrice;
	private String city;
	private Region region;
	private User user;
	
	public Tour(BigDecimal avgPrice, String city, Region region, User user) {
		this.setAvgPrice(avgPrice);
		this.setCity(city);
		this.setRegion(region);
		this.setUser(user);
	}
	
	public abstract BigDecimal getDiscount();

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getCountry() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return ""+user.getSourName()+" "+user.getName()
				+", city "+city+", region "+region.toString()
				+", price "+avgPrice;
	}
}
