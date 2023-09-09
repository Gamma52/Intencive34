package ru.aston.tarakanov_aa.task4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ru.aston.tarakanov_aa.task4.Connection.ConnectorToH2Base;
import ru.aston.tarakanov_aa.task4.Dao.OrderDao;
import ru.aston.tarakanov_aa.task4.Entity.Order;

public class OrderDaoTest {
	 
	private static OrderDao orderDao;
	
	@BeforeAll
	static void init() throws SQLException{
		Connection connection = ConnectorToH2Base.getConnection();
		Statement stmp = connection.createStatement();
		stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/orders.sql'");
		stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/users.sql'");
	    orderDao = new OrderDao();
	}
	
	@Test
    void findAll() {
        List<Order> orderList = orderDao.findAll();
        assertEquals(orderList.get(0).getProduct(), "box");
    }

    @Test
    void findEntityById() {
        assertEquals(orderDao.findEntityById(4).getProduct(), "bird");
    }

    @Test
    void delete() {
        assertTrue(orderDao.delete(3));
    }

    @Test
    void create() {   
        assertTrue(orderDao.create(new Order("Monitor", 12.2, 144.0)));
    }

    @Test
    void update() {
        Order order = new Order(1, "Monitor", 12.2, 144.0);
        assertEquals(orderDao.update(order).getProduct(), "Monitor");
    }
}
