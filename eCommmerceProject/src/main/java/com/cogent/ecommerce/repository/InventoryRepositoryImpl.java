package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.model.Inventory;
import com.cogent.ecommerce.utils.DBUtils;

	
	public String addInventory(Inventory inventory) {
			// TODO Auto-generated method stub
			Connection connection = dbUtils.getConnection();

			String insertStatement = "insert into  Inventory (invId, userId, productId,productQty,productPrice) values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = null;

			try {
				// if(connection!=null)
				preparedStatement = connection.prepareStatement(insertStatement);
				preparedStatement.setString(1, inventory.getInventoryId());
				preparedStatement.setString(2, inventory.getUserId());
				preparedStatement.setString(4, inventory.getProductId());
				preparedStatement.setInt(5,    inventory.getProductQty());
				preparedStatement.setDouble(6, inventory.getProductPrice());
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
			


		public String deleteInventoryById(String id) {
			// TODO Auto-generated method stub
			Connection con = dbUtils.getConnection();
			String deleteStatement = "delete from inventory where inventoryId = ?";
			int results = 0;
			PreparedStatement preparedStatement = null;
			try {

				preparedStatement.setString(1, id);
				results = preparedStatement.executeUpdate();
				if (results == 0)
					System.out.println(" No  Records of Inventory Found to Delete ");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				dbUtils.closeConnection(con);
			}

			return (results + "Number of Inventory Records are Deleted ");

		}


		public void deleteAllInventorys() {
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
			String query = "DELETE FROM inventory";
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
	

		public Optional<List<Inventory>> getInventoryById(String id) {
			// TODO Auto-generated method stub
			//return null;
			
			
			
		}

		public Optional<List<Inventory>> getInventorys() {
			// TODO Auto-generated method stub
			return null;
		}

		public String updateInventory(Inventory inventory) {
			// TODO Auto-generated method stub
			Connection connection =dbUtils.getConnection();
		 	String query = "Update inventory set userId =?, productId =?,  productQty=?,  productPrice=?  where inventoryId = ?";
		 	PreparedStatement preparedStatement = null;
		 	int count = 0;
		 	
		 	try {
		 		
		 		preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(5, inventory.getinventoryId());
			    preparedStatement.setString(1, inventory.getuserId());
			    preparedStatement.setString(2, inventory.getproductQty());
			    preparedStatement.setString(4, inventory.getproductPrice());
			    count =preparedStatement.executeUpdate();
		 	
		 	if (count ==0) 
		 		System.out.println("Inventory Records Not Updated");
		 	
		 	}
		 	 catch (SQLException e) {
		// TODO: handle exception
	  e.printStackTrace();
	}
	finally {

		dbUtils.closeConnection(connection);
	}
		return (" Inventory Records are Finally Updated!!");	
				 // Optional.empty();	
		 	}
 	
	
		public boolean isInventoryExists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		public String updateInventory() {
			return null;
			// TODO Auto-generated method stub
		
			
			
			//return null;
		}
	}
		