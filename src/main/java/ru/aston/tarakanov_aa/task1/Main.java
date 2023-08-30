package ru.aston.tarakanov_aa.task1;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(21, "Ivan", "Petrov");
		User user2 = new User(23, "Artem", "Sidorov");
		User user3 = new User(26, "Oleg", "Morozov");
		
		Tour tour1 = new AirplaneTour(new BigDecimal("15000"), "Sarov", Region.Central, user1);
		Tour tour2 = new AirplaneTour(new BigDecimal("25000"), "Esentuki", Region.Kavkaz, user2);
		Tour tour3 = new BusTour(new BigDecimal("37000"), "Ekaterenburg", Region.Ural, user3);
		
		List<Tour> tour = new ArrayList<Tour>();
		tour.add(tour1);
		tour.add(tour2);
		tour.add(tour3);
		
		DailyTourList tourList = new DailyTourList(tour);
		System.out.println("Sum all orders: "+tourList.sumAllOrders());

		for(Tour t:tourList.getSortedList()) {			
			System.out.println(t.toString());			
		}
	}

}
