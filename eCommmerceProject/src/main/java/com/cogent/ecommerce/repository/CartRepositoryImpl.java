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
import com.cogent.ecommerce.utils.DBUtils;

	@Repository
	public class CartRepositoryImpl implements CartRepository {
  //private static employeeRepository
		

		@Autowired
		DBUtils dbUtils;

		public String addCart(Cart cart) {
			// TODO Auto-generated method stub
			//return null;
			Connection connection = dbUtils.getConnection();

			String insertStatement = "insert into  Cart (cartId, userId, invId, productId,productQty,totalPrice) values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = null;

			try {
				// if(connection!=null)
				preparedStatement = connection.prepareStatement(insertStatement);
				preparedStatement.setString(1, cart.getCartId());
				preparedStatement.setString(2, cart.getUserId());
				preparedStatement.setString(3, cart.getInvId());
				preparedStatement.setString(4, cart.getProductId());
				preparedStatement.setInt(5,    cart.getProductQty());
				preparedStatement.setDouble(6, cart.getTotalPrice());
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
	@Override
		public String deleteCartById(String id) {
			// TODO Auto-generated method stub
			//return null;
			Connection con = dbUtils.getConnection();
			String deleteStatement = "delete from cart where cartId = ?";
			int results = 0;
			PreparedStatement preparedStatement = null;
			try {

				preparedStatement.setString(1, id);
				results = preparedStatement.executeUpdate();
				if (results == 0)
					System.out.println(" No  Records of Cart Found to Delete ");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				dbUtils.closeConnection(con);
			}

			return (results + "Number of Cart Records are Deleted ");

		}
	@Override
		public void deleteAllCarts()  {
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
			String query = "DELETE FROM cart";
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
		public Optional<List<Cart>> getCartById(String id) {
			// TODO Auto-generated method stub
			//return null;
			
			Connection connection = dbUtils.getConnection();
			ArrayList<Cart> arrayList = new ArrayList();

			String query = "select * from cart";
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				preparedStatement = connection.prepareStatement(query);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Cart cart = new Cart();

					cart.setCatId(resultSet.getString("cartId"));
					cart.setCatId(resultSet.getString("cartName"));
					arrayList.add(cart);

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
		public Optional<List<Cart>> getCart() {
			// TODO Auto-generated method stub
			Connection connection = dbUtils.getConnection();
			ArrayList<Cart> arrayList = new ArrayList<>();

			String query = "select * from cart";
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				preparedStatement = connection.prepareStatement(query);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Cart cart = new Cart();
		
	//this one is supposed to be lower case c but it  but it change to Cart.model it change from  c to C then set to cartId / create method for no error
					
					cart.setCartId(resultSet.getString("userId"));
					cart.setCartId(resultSet.getString("productId"));
					cart.setCartProductId(resultSet.getString("productId"));
					cart.setCartProductQty(resultSet.getInt("productQty"));
					cart.setCartTotalPrice(resultSet.getDouble("totalPrice"));
					arrayList.add(cart); // it create parameter cart here to remove error
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
		public String updateCart(Cart cart) {
			// TODO Auto-generated method stub
		
			Connection connection =dbUtils.getConnection();
		 	String query = "Update cart set userId=?,  invId=?, productId=?, productQty=?,  totalPrice=? where cartId = ?";
		 	PreparedStatement preparedStatement = null;
		 	int count = 0;
		 	
		 	try {
		 		
		 		preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(6, cart.CartId());
			    preparedStatement.setString(1, cart.getUserId());
			    preparedStatement.setString(2, cart.getInvId());
			    preparedStatement.setInt(3, cart.get.ProductQty());
			    preparedStatement.setDouble(4, cart.get.TotalPrice());
			   count =preparedStatement.executeUpdate();
		 	
		 	if (count ==0) 
		 		System.out.println("Cart Records Not Updated");
		 	 	
		 	}
			
		 	 catch (SQLException e) {
		// TODO: handle exception
	  e.printStackTrace();
	}
	finally {

		dbUtils.closeConnection(connection);
	}

		return (" Cart Records are Finally Updated!!");	
				 // Optional.empty();	

		 	}

		public boolean isCartExists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		public String updateCart() {
			// TODO Auto-generated method stub
			return null;
		}

		public Optional<java.awt.List> getCart(Cart cart) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
