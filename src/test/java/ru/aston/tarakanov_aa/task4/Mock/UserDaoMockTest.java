package ru.aston.tarakanov_aa.task4.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.aston.tarakanov_aa.task4.Dao.UserDao;
import ru.aston.tarakanov_aa.task4.Entity.User;
import ru.aston.tarakanov_aa.task4.Service.UserDaoService;

public class UserDaoMockTest {
	private static List<User> userList; 
	private static UserDao userDaoMock;
	
	@BeforeAll
	static void init() {
		User user1 = new User(1, "Olga", "Petrova", "+7199123742", "petrova@gmail.com", 10);
		User user2 = new User(2, "Masha", "Ivanova", "+7922123742", "ivanova@gmail.com", 20);
		User user3 = new User(3, "Olga", "Lapova", "+7333123742", "lapova@gmail.com", 30);
		
		userList = new ArrayList<User>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		userDaoMock = Mockito.mock(UserDao.class);
		Mockito.when(userDaoMock.findAll()).thenReturn(userList);		
	}
	
	@Test
	void getFirstTwoUsersTest() {
		 UserDaoService userService = new UserDaoService(userDaoMock);
		 List<User> firstUsers = userService.getFirstTwoUsers();
		 assertEquals(firstUsers.size(), 2);
    }
	
	@Test
	void getUserNameByIdTest(){
		Mockito.when(userDaoMock.findEntityById(1))
							.thenReturn(new User(1, "Olga", "Petrova", "+7199123742", "petrova@gmail.com", 10));
		UserDaoService userService = new UserDaoService(userDaoMock);
		assertEquals(userService.getUserNameById(1), "Olga");
	}
	
	@Test
	void deleteUsersByNameTest() {		
		Mockito.when(userDaoMock.delete(2)).thenReturn(true);
		UserDaoService userService = new UserDaoService(userDaoMock);
		assertTrue(userService.deleteUsersByName("Masha"));
	}
	
	@Test
	void setEmailForGroupUsersTest(){		
		Mockito.when(userDaoMock.update(userList.get(0)))
								.thenReturn(new User(1, "Olga", "Petrova", "+7199123742", "test@gmail.com", 10));
		Mockito.when(userDaoMock.update(userList.get(1)))
								.thenReturn(new User(2, "Masha", "Ivanova", "+7922123742", "test@gmail.com", 20));
		Mockito.when(userDaoMock.update(userList.get(2)))
								.thenReturn(new User(3, "Olga", "Lapova", "+7333123742", "test@gmail.com", 30));
		UserDaoService userService = new UserDaoService(userDaoMock);
		List<User> updated = userService.setEmailForGroupUsers("test@gmail.com", userList);
		assertEquals(updated.get(0).getEmail(), "test@gmail.com");
	}
}
