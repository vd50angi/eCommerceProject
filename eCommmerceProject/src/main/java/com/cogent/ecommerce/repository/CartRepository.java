package com.cogent.ecommerce.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Cart;

public interface CartRepository {


public String addCart(Cart cart );
public String deleteCartById(String id) throws ClassNotFoundException, SQLException ;
public void deleteAllCarts() throws ClassNotFoundException, SQLException;
public Optional<List<Cart>> getCartById(String id) ;
public Optional<List<Cart>> getCart();
public String updateCart(Cart cart);
public boolean isCartExists(String id);
String updateCart();
Optional<java.awt.List> getCart(Cart cart);


	
	
	
	
	

}
