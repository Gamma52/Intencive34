package ru.aston.tarakanov_aa.task4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.aston.tarakanov_aa.task4.Entity.User;
import ru.aston.tarakanov_aa.task4.Connection.ConnectorToH2Base;
import ru.aston.tarakanov_aa.task4.Dao.UserDao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoTest {
	
	private static UserDao userDao;
	
	@BeforeAll
	static void init() throws SQLException{
		Connection connection = ConnectorToH2Base.getConnection();
		Statement stmp = connection.createStatement();
		stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/orders.sql'");
		stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/users.sql'");
	    userDao = new UserDao();
	}
	
	@Test
	void findAllTest() {
		List<User> userList = userDao.findAll();
	    assertEquals(userList.get(0).getName(), "Vasya");
	}

	@Test
	void findEntityByIdTest() {
		assertEquals(userDao.findEntityById(1).getSurname(), "Petrov");
	}

	@Test
	void deleteTest() {		
	    assertTrue(userDao.delete(2));
	}

	@Test
	void createTest() {
		assertTrue(userDao.create(new User("Anna", "Chesnokova", "+71221363122", "chesnokova@mail.ru")));
	}

	@Test
	void updateTest() {
		User user = new User(3, "Anna", "Chesnokova", "+71221363122", "chesnokova@mail.ru", 4);
	    assertEquals(userDao.update(user).getName(), "Anna");
	 }

	@Test
	void getUsersWhithOrdersTest(){		
	    assertEquals(userDao.getUsersWhithOrders().getOrdersList().get(0).getProduct(), "box");
	}
}
