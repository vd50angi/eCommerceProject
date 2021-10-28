package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Role;

public interface RoleRepository {
	public String addRole(Role role );
	public String deleteRoleById(String id) ;
	public void deleteAllRoles();
	public Optional<List<Role>> getRoleById(String id) ;
	public Optional<List<Role>> getRoles();
	public String updateRole( Role role);
	public boolean isRoleExists(String id);
		
	
	
	
	

}
