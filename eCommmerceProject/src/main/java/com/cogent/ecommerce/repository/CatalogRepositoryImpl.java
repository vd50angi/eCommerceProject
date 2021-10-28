package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.model.Catalog;
import com.cogent.ecommerce.utils.DBUtils;

	@Repository
	public class CatalogRepositoryImpl implements CatalogRepository {
  //private static employeeRepository
		

		@Autowired
		DBUtils dbUtils;

		public String addCatalog(Catalog catalog) {
			// TODO Auto-generated method stub
		
			Connection connection = dbUtils.getConnection();

			String insertStatement = "insert into  Catalog (productId, productName, catId, productDescription,productImage,vaues(?,?,?,?,?)";

			PreparedStatement preparedStatement = null;

			try {
				// if(connection!=null)
				preparedStatement = connection.prepareStatement(insertStatement);
				preparedStatement.setString(1, catalog.getproductId());
				preparedStatement.setString(2, catalog.getproductName());
				preparedStatement.setString(3, catalog.getcatId());
				preparedStatement.setString(4, catalog.getproductDescription());
				preparedStatement.setBytes(5, (byte[]) catalog.getproductImage());
				preparedStatement.execute();
				
				return "Success";
				// }
				// else {

				// return "fail";
				// }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbUtils.closeConnection(connection);
			}

			//return null; // Optional.empty();

		}
	
		public String deleteCatalogById(String id) {
			// TODO Auto-generated method stub
			Connection con = dbUtils.getConnection();
			String deleteStatement = "delete from catalog where catalogId = ?";
			int results = 0;
			PreparedStatement preparedStatement = null;
			try {

				preparedStatement.setString(1, id);
				results = preparedStatement.executeUpdate();
				if (results == 0)
					System.out.println(" No  Records of Catalog Found to Delete ");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				dbUtils.closeConnection(con);
			}

			return (results + "Number of Catalog Records are Deleted ");

		}


		public void deleteAllCatalogs() {
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
			String query = "DELETE FROM catalog";
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
	//update catalog
		public String updatedCatalog(Catalog catalog) {
			// TODO Auto-generated method stub
			Connection connection =dbUtils.getConnection();
		 	String query = "Update catalog set productId =?, productName =?,  productDescription=?,  ProductImage=?  where catId = ?";
		 	PreparedStatement preparedStatement = null;
		 	int count = 0;
		 	
		 	try {
		 		
		 		preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(6, catalog.getcatId());
			    preparedStatement.setString(1, catalog.getproductId());
			    preparedStatement.setString(2, catalog.getproductName());
			    preparedStatement.setString(4, catalog.getproductDescription());
				preparedStatement.setBytes(5, (byte[]) catalog.getproductImage());
			    count =preparedStatement.executeUpdate();
		 	
		 	if (count ==0) 
		 		System.out.println("Catalog Records Not Updated");
		 	
		 	}
		 	 catch (SQLException e) {
		// TODO: handle exception
	  e.printStackTrace();
	}
	finally {

		dbUtils.closeConnection(connection);
	}
		return (" Catalog Records are Finally Updated!!");	
				 // Optional.empty();	
		 	}
 	
	
		public boolean isCatalogExists(String id) {
			// TODO Auto-generated method stub
			return false;
		}


		
		}

	