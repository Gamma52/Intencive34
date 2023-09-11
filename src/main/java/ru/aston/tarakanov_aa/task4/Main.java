package ru.aston.tarakanov_aa.task4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ru.aston.tarakanov_aa.task4.Connection.ConnectorToH2Base;
import ru.aston.tarakanov_aa.task4.Dao.*;
import ru.aston.tarakanov_aa.task4.Entity.Order;
import ru.aston.tarakanov_aa.task4.Entity.User;
import ru.aston.tarakanov_aa.task4.Dto.UsersWhithOrders;



public class Main {

	public static void main(String[] args) {
        
        try {
        	Connection connection = ConnectorToH2Base.getConnection();
			Statement stmp = connection.createStatement();
			stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/orders.sql'");
			stmp.execute("RUNSCRIPT FROM 'classpath:ru/aston/tarakanov_aa/task4/SQL/users.sql'");

			
			UserDao userDao = new UserDao();			
			UsersWhithOrders uo = userDao.getUsersWhithOrders();
			List<User> userList = uo.getUsersList();
			List<Order> orderList = uo.getOrdersList();
			for(int i=0; i < userList.size(); i++) {
				System.out.println(userList.get(i).getName() + " have order: " + 
													orderList.get(i).getProduct());
			}	
			connection.close();
			stmp.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
        
        

	}

}
