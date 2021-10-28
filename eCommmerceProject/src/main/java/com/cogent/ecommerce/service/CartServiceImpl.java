package com.cogent.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.repository.CartRepository;

public class CartServiceImpl implements CartService {
	
	
	private static CartServiceImpl cartService;
	private   CartServiceImpl() {
}
	
			public static CartServiceImpl getInstance() {
				
             //   if(cartService==null) {  //do this step   for singleton  
				//return cartRepository;
				
			//	synchronized (CartService.class) { //start of synchronized  block method
			//	if(cartService==null) {  //we need to mention EmployeeRepository.class) name above because this part is static
			//	cartService= new CartServiceImpl();
			//	return cartService;
			//}            //end of synchronized block*/
			
			//	}
            //    }
			
			
			//return cartService;
				
	@Autowired
	CartRepository cartRepository;
		
}
			public String addCart(Cart cart) {
				// TODO Auto-generated method stub
				 return cartRepository.addCart(cart);
			}

			public String deleteById(String id) throws IOException {
				// TODO Auto-generated method stub
				return cartRepository.deleteCartById(id);
			}

			public void deleteAllCart() {
				// TODO Auto-generated method stub
				cartRepository.deleteAllCarts();
			}

			public Cart getCartById(String id) throws IOException {
				// TODO Auto-generated method stub
				return cartRepository.getCartByID(id);
			}

			public List<Cart> getCart() {
				// TODO Auto-generated method stub
				return cartRepository.getCart();
			}

			public String updateCart(String id, Cart Cart) throws IOException {
				// TODO Auto-generated method stub
				return cartRepository.upddateCart(id, cart);
			}

			public boolean isCartExist(String id) {
				// TODO Auto-generated method stub
				return false;
			}


}
