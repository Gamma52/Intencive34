package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

import ru.aston.tarakanov_aa.task1.Exception.CodeException;
import ru.aston.tarakanov_aa.task1.Exception.SetPriceException;

public abstract class Tour implements Discount{
	private BigDecimal avgPrice;
	private String city;
	private Region region;
	private User user;
	
	public Tour(BigDecimal avgPrice, String city, Region region, User user) throws SetPriceException {
		if (avgPrice.compareTo(new BigDecimal("0")) < 0) {
			throw new SetPriceException("price must be great 0", CodeException.CREATE_TOUR_EXCEPTION);
		}
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
