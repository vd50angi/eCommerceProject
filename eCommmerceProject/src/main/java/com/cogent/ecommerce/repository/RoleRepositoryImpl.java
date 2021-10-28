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
import com.cogent.ecommerce.model.Role;
import com.cogent.ecommerce.utils.DBUtils;

@Repository

public class RoleRepositoryImpl implements RoleRepository {
	
	@Autowired
	DBUtils dbUtils;

	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		//return null;
		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into  Role (roleId, roleName) values(?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, role.getRoleId());
			preparedStatement.setString(2, role.getRoleName());
			
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
	public String deleteRoleById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection con = dbUtils.getConnection();
	String deleteStatement = "delete from role where roleId = ?";
	int results = 0;
	PreparedStatement preparedStatement = null;
	try {

		preparedStatement.setString(1, id);
		results = preparedStatement.executeUpdate();
		if (results == 0)
			System.out.println(" No  Records of Role Found to Delete ");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {

		dbUtils.closeConnection(con);
	}

	return (results + "Number of Role Records are Deleted ");

}		
@Override
	public void deleteAllRole() {
		// TODO Auto-generated method stub
	int count = 0;
	Connection connection = dbUtils.getConnection();
	String query = "DELETE FROM roles";
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
	public Optional<List<Role>> getRoleById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<Category> arrayList = new ArrayList<>();

	String query = "select * from role";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Role role = new Role();

			role.setRolesId(resultSet.getString("roleId"));
			role.setRoleName(resultSet.getString("roleName"));
			arrayList.add(role);

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

	public Optional<List<Role>> getRole() {
		// TODO Auto-generated method stub
	Connection connection = dbutils.getConnection();
	ArrayList<Category> arrayList = new ArrayList<>();

	String query = "select * from roles";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Role roles = new Role();

			Role.set roleId(resultSet.getString("roleId"));
			Role.set roleName(resultSet.getString("roleName"));
		
			arrayList.add(role);

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
	public String updateRole(Role role) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection =dbUtils.getConnection();
 	String query = "Role set rolename=?,   where roleId = ?";
 	PreparedStatement preparedStatement = null;
 	int count = 0;
 	
 	try {
 		
 		preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(2, role.roleId());
	    preparedStatement.setString(1, role.getroleName());
	    
	   count =preparedStatement.executeUpdate();
 	
 	if (count ==0) 
 		System.out.println("Role Records Not Updated");
 	 	
 	}
	
 	 catch (SQLException e) {
// TODO: handle exception
e.printStackTrace();
}
finally {

dbUtils.closeConnection(connection);
}

return ("Role Records are Finally Updated!!");	
		 // Optional.empty();	

 	}	
@Override
	public boolean isRoleExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
