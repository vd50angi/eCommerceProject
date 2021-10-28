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

import com.cogent.ecommerce.model.Category;
import com.cogent.ecommerce.utils.DBUtils;


@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	@Autowired
	DBUtils dbUtils;

	public String addCategory(Category category) {
		// TODO Auto-generated method stub
		//return null;
		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into  Category (categoryId, categoryName) values(?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, category.getCategoryId());
			preparedStatement.setString(2, category.getCategoryName());
			
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
	public void deleteAllCategories() {
		// TODO Auto-generated method stub
		int count = 0;
		Connection connection = dbUtils.getConnection();
		String query = "DELETE FROM categories";
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
	public Optional<List<Category>> getCategoryById(String id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		ArrayList<Category> arrayList = new ArrayList<>();

		String query = "select * from category";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category employee = new Category();

				category.setCategoryId(resultSet.getString("categoryId"));
				category.setCategoryName(resultSet.getString("categoryName"));
				arrayList.add(category);

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

//@Override
	public Optional<List<Category>> getCategory() {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		ArrayList<Category> arrayList = new ArrayList<>();

		String query = "select * from category";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category role = new Category();

				Category.set categoryId(resultSet.getString("categoryId"));
				Category.set categoryName(resultSet.getString("categoryName"));
			
				arrayList.add(category);

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
	public String updateCategory(Category category) {
		// TODO Auto-generated method stub
		//return null;
		Connection connection =dbUtils.getConnection();
	 	String query = "Update category set catname=?,   where catId = ?";
	 	PreparedStatement preparedStatement = null;
	 	int count = 0;
	 	
	 	try {
	 		
	 		preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(2, category.catId());
		    preparedStatement.setString(1, category.getcatName());
		    
		   count =preparedStatement.executeUpdate();
	 	
	 	if (count ==0) 
	 		System.out.println("Category Records Not Updated");
	 	 	
	 	}
		
	 	 catch (SQLException e) {
	// TODO: handle exception
  e.printStackTrace();
}
finally {

	dbUtils.closeConnection(connection);
}

	return (" Category Records are Finally Updated!!");	
			 // Optional.empty();	

	 	}
@Override
	public boolean isCategoryExists(String id) {
	// TODO Auto-generated method stub
	return false;
	}

@Override	
public String updateCategory() {
		// TODO Auto-generated method stub
		Connection connection =dbUtils.getConnection();
	 	String query = "Update category set categoryName =? where categoryId = ?";
	 	PreparedStatement preparedStatement = null;
	 	int count = 0;
	 	
	 	try {
	 		
	 		preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(2, category.getCategoryId());
		    preparedStatement.setString(1, category.getCategoryName());
		   
	 	    count =preparedStatement.executeUpdate();
	 	
	 	if (count ==0) 
	 		System.out.println("Role Records  Not Updated");
	 	 
	 	}
	 		
	 	
	 	 catch (SQLException e) {
	// TODO: handle exception
   e.printStackTrace();
}
 finally {
 
	dbUtils.closeConnection(connection);
}

	return (" Hooray  Role Records are Finally Updated!!");	
			 // Optional.empty();	

	 	}


	public Optional<java.awt.List> getCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
@Override
	public String deleteCategoryById(String id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		String deleteStatement = "delete from category where categoryId = ?";
		int results = 0;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement.setString(1, id);
			results = preparedStatement.executeUpdate();
			if (results == 0)
				System.out.println(" No  Records of Category Found to Delete ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			dbUtils.closeConnection(con);
		}

		return (results + "Number of Category Records are Deleted ");

	}		
		
		
		
		//return null;
	}
