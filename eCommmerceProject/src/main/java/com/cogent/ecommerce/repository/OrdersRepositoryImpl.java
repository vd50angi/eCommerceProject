package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.model.Catalog;
import com.cogent.ecommerce.model.Orders;
import com.cogent.ecommerce.utils.DBUtils;

@Repository

public class OrdersRepositoryImpl implements OrdersRepository {
	
	@Autowired
	DBUtils dbUtils;

	public String addOrders(Orders orders) {
		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into  Orders (ordersId, userId, invId, productId,totalPrice,grandTotalPrice) values(?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, orders.getOrdersId());
			preparedStatement.setString(2, orders.getUserId());
			preparedStatement.setString(3, orders.getInvId());
			preparedStatement.setString(4, orders.getProductId());
			preparedStatement.setInt(5,    orders.getProductQty());
			preparedStatement.setDouble(6, orders.getgrandTotalPrice());
			preparedStatement.execute();
		
			return "Success";
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return null; // Optional.empty();
	}
	
		// TODO Auto-generated method stub
		//return null;
	
	public String deleteOrdersById(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//return null;
		Connection con = dbUtils.getConnection();
		String deleteStatement = "delete from orders where ordersId = ?";
		int results = 0;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement.setString(1, id);
			results = preparedStatement.executeUpdate();
			if (results == 0)
				System.out.println(" No  Records of Orders Found to Delete ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			dbUtils.closeConnection(con);
		}

		return (results + "Number of Orders Records are Deleted ");

	}
	
	@Override
	public void deleteAllOrderss() {
		// TODO Auto-generated method stub
	
		int count = 0;
		Connection connection = null;
		try {
			connection = dbUtils.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "DELETE FROM orders";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			count = ps.executeUpdate();
			if (count == 0)
				System.out.println("No Records Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		System.out.println(count + " records deleted");
	
	}	
		
@Override
	public Optional<List<Orders>> getOrdersById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<Orders> arrayList = new ArrayList();

	String query = "select * from orders";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Orders orders = new Orders();

			orders.setOrderstId(resultSet.getString("ordersId"));
			orders.setOrdersUserNameId(resultSet.getString("ordersUserName"));
			orders.setOrdersUserInvId(resultSet.getString("ordersInvName"));
			orders.setOrdersProductId(resultSet.getString("ordersProductId"));
			orders.setOrdersTotalPrice(resultSet.getString("ordersTotalPrice"));
			orders.setOrdersGrandTotalPrice(resultSet.getString("grandTotalPrice"));
			arrayList.add(orders);

		}

		return Optional.empty();

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		dbUtils.closeConnection(connection);
	}

	return Optional.empty();

}
@Override
	public Optional<List<Orders>> getOrders() {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<Orders> arrayList = new ArrayList<>();

	String query = "select * from orders";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Orders orders = new Orders();

//this one is supposed to be lower case c but it  but it change to Cart.model it change from  c to C then set to cartId / create method for no error
			
			orders.setCartId(resultSet.getString("userId"));
			orders.setCartId(resultSet.getString("productId"));
			orders.setCartProductId(resultSet.getString("productId"));
			orders.setCartProductQty(resultSet.getInt("productQty"));
			orders.setCartTotalPrice(resultSet.getDouble("totalPrice"));
			arrayList.add(orders); // it create parameter cart here to remove error
		}

		return Optional.empty();

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		dbUtils.closeConnection(connection);
	}

	return Optional.empty();

}

	public boolean isOrdersExists(String id) {
		// TODO Auto-generated method stub
		return false;
	
	
	}	
	

}
