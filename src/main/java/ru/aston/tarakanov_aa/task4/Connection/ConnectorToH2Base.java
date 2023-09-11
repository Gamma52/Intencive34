package ru.aston.tarakanov_aa.task4.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorToH2Base {	
	private static Connection connection;	
	
	private ConnectorToH2Base() {};
	
	public static Connection getConnection() throws SQLException {
		if (connection == null){
			connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "admin", "password");			
		}
		return connection;
	}
}
