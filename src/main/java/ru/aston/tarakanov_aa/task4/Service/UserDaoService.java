package ru.aston.tarakanov_aa.task4.Service;

import java.util.List;

import ru.aston.tarakanov_aa.task4.Dao.UserDao;
import ru.aston.tarakanov_aa.task4.Entity.User;

public class UserDaoService {
	
	private UserDao userDao;
	
	public UserDaoService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getFirstTwoUsers() {		
		return userDao.findAll().stream().limit(2).toList();
	}
	
	public String getUserNameById(long id) {
		return userDao.findEntityById(id).getName();
	}
	
	public boolean deleteUsersByName(String name) {
		List<User> userList = userDao.findAll();
		List<Long> idList = userList.stream()
								.filter((x) -> x.getName().equals(name))
								.map((x) -> x.getId()).toList();
		
		for(Long id:idList) {
			if(!userDao.delete(id.longValue())) {
				return false;
			}
		}
		return true;
	}
	
	public List<User> setEmailForGroupUsers(String email, List<User> userList) {
		return userList.stream().map(userDao::update).toList();		
	}
}
