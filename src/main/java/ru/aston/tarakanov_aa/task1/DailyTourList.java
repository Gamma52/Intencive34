package ru.aston.tarakanov_aa.task1;

import java.util.List;
import java.math.BigDecimal;


public class DailyTourList {
	
	private List<Tour> orderList;
	
	
	public DailyTourList(List<Tour> orderList) {
		this.orderList = orderList;		
	}
	
	
	public BigDecimal sumAllOrders() {
		BigDecimal sumAllOrders = new BigDecimal("0");
		
		for(Tour tour:orderList) {
			sumAllOrders = sumAllOrders.add(tour.getAvgPrice());			
		}
		return sumAllOrders;			
	}
	
	
	public List<Tour> getSortedList(){
		orderList.sort((o1, o2) -> o1.getUser().getSourName().compareTo(o2.getUser().getSourName()));
		return orderList;
	}
	
}
