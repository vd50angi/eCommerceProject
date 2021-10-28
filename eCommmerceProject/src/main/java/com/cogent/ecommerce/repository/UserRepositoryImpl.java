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
import com.cogent.ecommerce.model.Category;
import com.cogent.ecommerce.model.User;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	DBUtils dbUtils;

	public String addUser(User user) {
		// TODO Auto-generated method stub
		//return null;
		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into  User ( userId, userName, password,emailId,roleId) values(?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getEmailId());
			preparedStatement.setInt(5,    user.getRoleId());
			
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
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection con = dbUtils.getConnection();
	String deleteStatement = "delete from user where userId = ?";
	int results = 0;
	PreparedStatement preparedStatement = null;
	try {

		preparedStatement.setString(1, id);
		results = preparedStatement.executeUpdate();
		if (results == 0)
			System.out.println(" No  Records of User Found to Delete ");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {

		dbUtils.closeConnection(con);
	}

	return (results + "Number of User Records are Deleted ");

}	

@Override
	public void deleteAllUsers() {
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
		String query = "DELETE FROM user";
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

	public Optional<List<User>> getUserById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<User> arrayList = new ArrayList();

	String query = "select * from user";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			User user = new User();

			user.setUserId(resultSet.getString("userId"));
			user.setUserName(resultSet.getString("userName"));
			user.setUserPassword(resultSet.getString("userpassword"));
			user.setUserEmailId(resultSet.getString("useremailId"));
			user.setUserId(resultSet.getString("userId"));
			user.setUserRoleId(resultSet.getString("userRoleId"));
			
			
			arrayList.add(user);

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
	public Optional<List<User>> getUser() {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<User> arrayList = new ArrayList<>();

	String query = "select * from user";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			User user = new User();

//this one is supposed to be lower case c but it  but it change to Cart.model it change from  c to C then set to cartId / create method for no error
			
			user.setUserId(resultSet.getString("userId"));
			user.setUserName(resultSet.getString("userName"));
			user.setUsertPassword(resultSet.getString("userPassword"));
			user.setUserEmailId(resultSet.getInt("userEmailId"));
			user.setUserRoleId(resultSet.getDouble("userRoleId"));
			arrayList.add(user); // it create parameter cart here to remove error
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
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection =dbUtils.getConnection();
 	String query = "Update user set userName=?,  password=?,emailId=?, roleId=? where userId = ?";
 	PreparedStatement preparedStatement = null;
 	int count = 0;
 	
 	try {
 		
 		preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(5, user.UserId());
	    preparedStatement.setString(1, user.getUserName());
	    preparedStatement.setString(2, user.getUserPassword());
	    preparedStatement.setInt(3, user.get.UserEmailId());
	    preparedStatement.setDouble(4, user.get.UserRoleId());
	   count =preparedStatement.executeUpdate();
 	
 	if (count ==0) 
 		System.out.println("User Records Not Updated");
 	 	
 	}
	
 	 catch (SQLException e) {
// TODO: handle exception
e.printStackTrace();
}
finally {

dbUtils.closeConnection(connection);
}

return (" User Records are Finally Updated!!");	
		 // Optional.empty();	

 	}
	
@Override
	public boolean isUserExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public String updateUser() {
		// TODO Auto-generated method stub
		//return null;
		
		Connection connection =dbUtils.getConnection();
	 	String query = "Update user set userName =? password = ?, emailId =? roleId =? where categoryId = ?";
	 	PreparedStatement preparedStatement = null;
	 	int count = 0;
	 	
	 	try {
	 		
	 		preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(2, user.getUserId());
		    preparedStatement.setString(1, user.getUserName());
		    preparedStatement.setString(2, user.getUserPassword());
		    preparedStatement.setString(1, user.getUserEmailId());
		    preparedStatement.setString(1, user.getUserRoleId());
		    
		    count =preparedStatement.executeUpdate();
	 	
	 	if (count ==0) 
	 		System.out.println("User Records  Not Updated");
	 	 
	 	}
	 		
	 	
	 	 catch (SQLException e) {
	// TODO: handle exception
   e.printStackTrace();
}
 finally {
 
	dbUtils.closeConnection(connection);
}

	return (" Hooray  User Records are Finally Updated!!");	
			 // Optional.empty();	

	 	}


	public Optional<java.awt.List> getCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}	
		
	}
	

