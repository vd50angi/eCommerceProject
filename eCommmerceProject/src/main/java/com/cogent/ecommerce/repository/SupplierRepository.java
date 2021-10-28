package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Supplier;

public interface SupplierRepository {
	
	public String addSupplier(Supplier supplier );
	public String deleteSupplierById(String id);
	public void deleteAllSuppliers();
	public Optional<List<Supplier>> getSupplierById(String id) ;
	public Optional<List<Supplier>> getSuppliers();
	public String updateSupplier( Supplier supplier);
	public boolean isSupplierExists(String id);
	String updateSupplier();
	
	
	
	

}
