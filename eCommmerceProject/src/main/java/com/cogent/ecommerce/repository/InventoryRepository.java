package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Inventory;

public interface InventoryRepository {
	
	public String addInventory(Inventory inventory );
	public String deleteInventoryById(String id) ;
	public void deleteAllInventorys();
	public Optional<List<Inventory>> getInventoryById(String id) ;
	public Optional<List<Inventory>> getInventorys();
	public String updateInventory( Inventory catalog);
	public boolean isInventoryExists(String id);
	String updateInventory();


}
