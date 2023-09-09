package ru.aston.tarakanov_aa.task4.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import ru.aston.tarakanov_aa.task4.Connection.ConnectorToH2Base;
import ru.aston.tarakanov_aa.task4.Dto.UsersWhithOrders;
import ru.aston.tarakanov_aa.task4.Entity.User;
import ru.aston.tarakanov_aa.task4.Entity.Order;

public class UserDao implements DaoDataEntityLayer<User>{
	private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";
    private static final String SQL_CREATE_USER = "INSERT INTO users (name, surname, telephone, email) " +
            																				"VALUES (?, ?, ?, ?)";
    
    private static final String SQL_UPDATE_USER_BY_ID = "UPDATE users SET name = ?, surname = ?, telephone = ?, " +
    																		"email = ?, order_id = ? WHERE id = ?";

    private static final String SQL_SELECT_USERS_JOIN_ORDERS
            = "SELECT * FROM users JOIN orders ON users.order_id = orders.id";
    
    private Connection connection;
    
    public UserDao() throws SQLException {
			this.connection = ConnectorToH2Base.getConnection();
    }

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()){
                users.add(new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getLong(6)));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
	}

	@Override
	public User findEntityById(long id) {
		User user = null;
	    try(PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
	    	statement.setLong(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        if(resultSet.next()){
	        	user = new User(resultSet.getInt(1), resultSet.getString(2),
	        					resultSet.getString(3), resultSet.getString(4),
	                            resultSet.getString(5), resultSet.getInt(6));
	        }
	        resultSet.close();
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    return user;
	}

	@Override
	public boolean delete(long id) {
		boolean isDelete = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0){
                isDelete = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
	}

	@Override
	public boolean create(User user) {
		boolean isCreate = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_CREATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getTelephone());
            statement.setString(4, user.getEmail());           
            if (statement.executeUpdate() > 0){
                isCreate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isCreate;
	}

	@Override
	public User update(User user) {
		User resultUser = null;
        try(PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getTelephone());
            statement.setString(4, user.getEmail());
            statement.setLong(5, user.getOrder_id());
            statement.setLong(6, user.getId());
            if (statement.executeUpdate() > 0){
                resultUser = findEntityById(user.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultUser;
	}
	
	
	public UsersWhithOrders getUsersWhithOrders() {
        List<User> userList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USERS_JOIN_ORDERS);
            while (resultSet.next()){
            	userList.add(new User(resultSet.getLong(1),
            						  resultSet.getString("name"),
            						  resultSet.getString("surname"),
            						  resultSet.getString("telephone"),
            						  resultSet.getString("email"),
            						  resultSet.getLong("order_id")));
            	
            	orderList.add(new Order(resultSet.getLong(7),
            							resultSet.getString("product"),
            							resultSet.getDouble("weight"),
            							resultSet.getDouble("price")));            	
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new UsersWhithOrders(userList, orderList);
    }
}
