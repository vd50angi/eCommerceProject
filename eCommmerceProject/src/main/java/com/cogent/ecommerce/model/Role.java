package com.cogent.ecommerce.model;

///import com.cogent.ecommerce.exception.InvalidPriceException;

public class Role {
	

	private String roleId;
	private String roleName;


	private  Role(String roleId, String roleName) {

		   super();
		   
		   this.roleId = roleId;
		   this.roleName = roleName;
		   
		
		}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
		
	
	
	
	
	

}
