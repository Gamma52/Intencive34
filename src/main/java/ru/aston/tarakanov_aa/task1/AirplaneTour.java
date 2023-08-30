package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

public class AirplaneTour extends Tour {
	
	private final BigDecimal DISCOUNT_AIR = new BigDecimal("0.95"); //BigDecimal.valueOf(0.95);
	
	public AirplaneTour(BigDecimal avgPrice, String city, Region region, User user) {
		super(avgPrice, city, region, user);
	}
	
	
	@Override
	public BigDecimal getDiscount() {
		BigDecimal discount = getAvgPrice().multiply(DISCOUNT_AIR);
		if (getRegion() == Region.Ural) {			
			return discount.multiply(BigDecimal.valueOf(0.8));
		} 	
		return discount;
	}
	
}
