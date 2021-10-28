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

import com.cogent.ecommerce.model.Supplier;
import com.cogent.ecommerce.model.User;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class SupplierRepositoryImpl implements SupplierRepository {
	
	@Autowired
	DBUtils dbUtils;

	public String addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		//return null;
		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into  Supplier ( supplierId, supplierName,productId,productName,orderId,invId,grandTotalPrice) values(?,?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, supplier.getSupplierId());
			preparedStatement.setString(2, supplier.getSupplierName());
			preparedStatement.setString(3, supplier.getProductId());
			preparedStatement.setString(4,supplier.getProductName());
			preparedStatement.setString(5, supplier.getOrderId());
			preparedStatement.setString(6, supplier.getInvId());
			preparedStatement.setString(7,supplier.getGrandTotalPrice());
			
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
	public String deleteSupplierById(String id) {
		// TODO Auto-generated method stub
		//return null;
		Connection con = dbUtils.getConnection();
		String deleteStatement = "delete from user where supplierId = ?";
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
	public void deleteAllSuppliers() {
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
		String query = "DELETE FROM supplier";
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
	public Optional<List<Supplier>> getSupplierById(String id) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<User> arrayList = new ArrayList();

	String query = "select * from supplier";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			User user = new User();

			user.setSupplierId(resultSet.getString("supplierId"));
			user.setSupplierName(resultSet.getString("supplierName"));
			user.setSupplierProductName(resultSet.getString("supplierproductId"));
			user.setSupplierOrderId(resultSet.getString("supplierOrderId"));
			user.setSupplierInvIdId(resultSet.getString("supplierInvId"));
			user.setSupplierGrandTotalPrice(resultSet.getString("supplierGrandTotalPrice"));
			
			
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

	public Optional<List<Supplier>> getSuppliers() {
		// TODO Auto-generated method stub
		//return null;
	Connection connection = dbUtils.getConnection();
	ArrayList<Suppliers> arrayList = new ArrayList<>();

	String query = "select * from supplier";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
		preparedStatement = connection.prepareStatement(query);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Supplier supplier = new Supplier();

//this one is supposed to be lower case c but it  but it change to Cart.model it change from  c to C then set to cartId / create method for no error
			
			supplier.setSupplierId(resultSet.getString("supplierId"));
			supplier.setSupplierName(resultSet.getString("supplierName"));
			supplier.setSuppliertProductId(resultSet.getString("supplierProductId"));
			supplier.setSupplierProductName(resultSet.getInt("supplierProductName"));
			supplier.setSupplierOrderId(resultSet.getDouble("supplierOrderId"));
			supplier.setSupplierInvId(resultSet.getInt("supplierInvId"));
			supplier.setSupplierGrandTotalPrice(resultSet.getDouble("supplierGrandTotalPrice"));
			
			arrayList.add(supplier); // it create parameter cart here to remove error
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
	public String updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		//return null;
	Connection connection =dbUtils.getConnection();
 	String query = "Update supplier set supplierName=?,  productId=?,productName=?, orderId=?,invId,grandTotalPrice=? where supplierId = ?";
 	PreparedStatement preparedStatement = null;
 	int count = 0;
 	
 	try {
 		
 		preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(7, supplier.SupplierId());
	    preparedStatement.setString(1, supplier.getSupplierName());
	    preparedStatement.setString(2, supplier.getSupplierProductId());
	    preparedStatement.setInt(3, supplier.get.SupplierProductName());
	    preparedStatement.setDouble(4, supplier.get.SupplierOrderId());
	    preparedStatement.setDouble(5, supplier.get.SupplierInvId());
	    preparedStatement.setDouble(6, supplier.get.SupplierGrandTotalPrice());
		
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

	public boolean isSupplierExists(String id) {
		// TODO Auto-generated method stub
		//return false;
	}

	@Override
	public String updateSupplier() {
		// TODO Auto-generated method stub
		//return null;
		Connection connection =dbUtils.getConnection();
	 	String query = "Update supplier set supplierName=?,  productId=?,productName=?, orderId=?,invId,grandTotalPrice=? where supplierId = ?";
	 	PreparedStatement preparedStatement = null;
	 	int count = 0;
	 	
	 	try {
	 		
	 		preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(7, supplier.SupplierId());
		    preparedStatement.setString(1, supplier.getSupplierName());
		    preparedStatement.setString(2, supplier.getSupplierProductId());
		    preparedStatement.setInt(3, supplier.get.SupplierProductName());
		    preparedStatement.setDouble(4, supplier.get.SupplierOrderId());
		    preparedStatement.setDouble(5, supplier.get.SupplierInvId());
		    preparedStatement.setDouble(6, supplier.get.SupplierGrandTotalPrice());
			
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
	

	return (" Hooray  Role Records are Finally Updated!!");	
			 // Optional.empty();	

	 	}
		
		
		
		
	}	
	
