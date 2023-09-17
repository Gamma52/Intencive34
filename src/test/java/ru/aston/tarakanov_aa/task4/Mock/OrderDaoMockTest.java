package ru.aston.tarakanov_aa.task4.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.aston.tarakanov_aa.task4.Service.OrderDaoService;
import ru.aston.tarakanov_aa.task4.Dao.OrderDao;
import ru.aston.tarakanov_aa.task4.Entity.Order;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDaoMockTest {

	private static List<Order> orderList; 
	private static OrderDao orderDaoMock;
	
	@BeforeAll
	static void init() {
		Order order1 = new Order(1, "Bolgarka", 8.0, 20.5);
		Order order2 = new Order(2, "Telega", 15.6, 11.2);
		Order order3 = new Order(3, "Lopata", 4.0, 2.0);
		
		orderList = new ArrayList<Order>();
		
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		
		orderDaoMock = Mockito.mock(OrderDao.class);
		Mockito.when(orderDaoMock.findAll()).thenReturn(orderList);		
	}
	
	@Test
	void getOddOrdersTest() {
		 OrderDaoService orderService = new OrderDaoService(orderDaoMock);
		 List<Order> oddOrders = orderService.getOddOrders();
		 assertEquals(oddOrders.size(), 2);
    }
	
	@Test
	void getProductNameByIdTest(){
		Mockito.when(orderDaoMock.findEntityById(1))
							.thenReturn(new Order(1, "Bolgarka", 8.0, 20.5));
		OrderDaoService orderService = new OrderDaoService(orderDaoMock);
		assertEquals(orderService.getProductNameById(1), "Bolgarka");
	}
	
	@Test
	void deleteOrdersByNameTest() {		
		Mockito.when(orderDaoMock.delete(2)).thenReturn(true);
		OrderDaoService orderService = new OrderDaoService(orderDaoMock);
		assertTrue(orderService.deleteOrdersByName("Telega"));
	}
	
	@Test
	void setPriceForGroupOrdersTest(){		
		Mockito.when(orderDaoMock.update(orderList.get(0)))
								.thenReturn(new Order(1, "Bolgarka", 8.0, 10.0));
		Mockito.when(orderDaoMock.update(orderList.get(1)))
								.thenReturn(new Order(2, "Telega", 15.6, 10.0));
		Mockito.when(orderDaoMock.update(orderList.get(2)))
								.thenReturn(new Order(3, "Lopata", 4.0, 10.0));
		OrderDaoService orderService = new OrderDaoService(orderDaoMock);
		List<Order> updated = orderService.setPriceForGroupOrders(10.0, orderList);
		assertEquals(updated.get(0).getPrice(), 10.0);
	}
}
