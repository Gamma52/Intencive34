package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

import ru.aston.tarakanov_aa.task1.Exception.SetPriceException;

public class AirplaneTour extends Tour {
	
	private final BigDecimal DISCOUNT_AIR = new BigDecimal("0.95"); //BigDecimal.valueOf(0.95);
	
	public AirplaneTour(BigDecimal avgPrice, String city, Region region, User user) throws SetPriceException {
		super(avgPrice, city, region, user);
	}
	
	
	@Override
	public BigDecimal getDiscount() {
		BigDecimal discount = getAvgPrice().multiply(DISCOUNT_AIR);
		if (getRegion() == Region.URAL) {			
			return discount.multiply(BigDecimal.valueOf(0.8));
		} 	
		return discount;
	}
	
}
