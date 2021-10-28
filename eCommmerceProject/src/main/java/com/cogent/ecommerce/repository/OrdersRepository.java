package com.cogent.ecommerce.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Catalog;
import com.cogent.ecommerce.model.Orders;

public interface OrdersRepository {
	public String addOrders(Orders orders );
	public String deleteOrdersById(String id) throws ClassNotFoundException, SQLException ;
	public void deleteAllOrderss();
	public Optional<List<Orders>> getOrdersById(String id) ;
	public Optional<List<Orders>> getOrders();
	public String updateCart( Catalog catalog);
	public boolean isOrdersExists(String id);
	String updateOrders();
	
		
	
	
	
	
	
	
	
	

}
