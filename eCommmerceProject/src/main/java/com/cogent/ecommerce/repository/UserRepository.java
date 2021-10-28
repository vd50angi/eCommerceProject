package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.User;

public interface UserRepository {
	public String addUser(User user );
	public String deleteUserById(String id) ;
	public void deleteAllUsers();
	public Optional<List<User>>getUserById(String id) ;
	public Optional<List<User>> getUser();
	public String updateUser(User user);
	public boolean isUserExists(String id);
	String updateUser();	
	
	
	
	

}
