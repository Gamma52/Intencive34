package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

public class BusTour extends Tour {	
	
	private final BigDecimal DISCOUNT_BUS = BigDecimal.valueOf(0.6);

	public BusTour(BigDecimal avgPrice, String city, Region region, User user) {
		super(avgPrice, city, region, user);		
	}

	
	@Override
	public BigDecimal getDiscount() {
		BigDecimal discount = getAvgPrice().multiply(DISCOUNT_BUS);
		if (getRegion() == Region.Central) {			
			return discount.multiply(BigDecimal.valueOf(0.95));
		} 	
		return discount;
	}

}
