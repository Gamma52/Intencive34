package ru.aston.tarakanov_aa.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.aston.tarakanov_aa.task1.Exception.SetPriceException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DailyTourListTest {

	private DailyTourList tourList;
	
	@BeforeEach
	public void initDailyTourList() throws SetPriceException {
		User user1 = new User(21, "Ivan", "Petrov");
		User user2 = new User(23, "Artem", "Sidorov");
		User user3 = new User(26, "Oleg", "Morozov");
		
		Tour tour1 = new AirplaneTour(new BigDecimal("15000"), "Sarov", Region.CENTRAL, user1);
		Tour tour2 = new AirplaneTour(new BigDecimal("25000"), "Esentuki", Region.KAVKAZ, user2);
		Tour tour3 = new BusTour(new BigDecimal("37000"), "Ekaterenburg", Region.URAL, user3);
		
		List<Tour> tour = new ArrayList<Tour>();
		tour.add(tour1);
		tour.add(tour2);
		tour.add(tour3);
		
		tourList = new DailyTourList(tour);
	}
	
	@Test
	public void sumAllOrdersTest() {
		assertEquals(new BigDecimal("77000"), tourList.sumAllOrders());
	}
	
	@Test
	public void getSortedListTest() {
		assertEquals(tourList.getSortedList().get(0).getUser().getSourName(), "Morozov");
		assertEquals(tourList.getSortedList().get(1).getUser().getSourName(), "Petrov");
		assertEquals(tourList.getSortedList().get(2).getUser().getSourName(), "Sidorov");
	}
	
	@Test
    void setPriceExceptionTest() {
        assertThrows(SetPriceException.class, () -> {
            User ut = new User(21, "Ivan", "Petrov");
            BusTour busTour = new BusTour(new BigDecimal("-15"), "Ekaterenburg", Region.URAL, ut);
        });
    }
}
