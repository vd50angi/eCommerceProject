package com.cogent.ecommerce.service;

import java.io.IOException;
import java.util.List;


import com.cogent.ecommerce.model.Cart;

public interface CartService {
	public String addCart(Cart cart);
	public String deleteById(String id)throws  IOException;;
	public void deleteAllCart();
	public Cart getCartById(String id) throws  IOException;
	public List<Cart> getCart();
	public String updateCart(String id, Cart Cart)throws  IOException;
	public boolean isCartExist(String id);
}
	
	
	
	
	


