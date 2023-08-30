package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyTourListTest {

	DailyTourList tourList;
	
	@BeforeEach
	void initDailyTourList() {
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
		
		tourList = new DailyTourList(tour);
	}
	
	@Test
	void sumAllOrdersTest() {
		assertEquals(new BigDecimal("77000"), tourList.sumAllOrders());
	}
	
	@Test
	void getSortedListTest() {
		assertEquals(tourList.getSortedList().get(0).getUser().getSourName(), "Morozov");
		assertEquals(tourList.getSortedList().get(1).getUser().getSourName(), "Petrov");
		assertEquals(tourList.getSortedList().get(2).getUser().getSourName(), "Sidorov");
	}
}
