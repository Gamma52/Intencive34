package ru.aston.tarakanov_aa.task4.Dto;

import java.util.List;

import ru.aston.tarakanov_aa.task4.Entity.Order;
import ru.aston.tarakanov_aa.task4.Entity.User;

public class UsersWhithOrders {
	private List<User> usersList;
	private List<Order> ordersList;	
	
	public UsersWhithOrders(List<User> usersList, List<Order> ordersList) {
		this.setUsersList(usersList);
		this.setOrdersList(ordersList);
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
	
}
