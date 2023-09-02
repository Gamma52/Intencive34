package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;

import ru.aston.tarakanov_aa.task1.Exception.SetPriceException;

public class BusTour extends Tour {	
	
	private final BigDecimal DISCOUNT_BUS = BigDecimal.valueOf(0.6);

	public BusTour(BigDecimal avgPrice, String city, Region region, User user) throws SetPriceException {
		super(avgPrice, city, region, user);		
	}

	
	@Override
	public BigDecimal getDiscount() {
		BigDecimal discount = getAvgPrice().multiply(DISCOUNT_BUS);
		if (getRegion() == Region.CENTRAL) {			
			return discount.multiply(BigDecimal.valueOf(0.95));
		} 	
		return discount;
	}

}
