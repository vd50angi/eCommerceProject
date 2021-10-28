package com.cogent.ecommerce.repository;

public interface CatalogRepository {
	public String addCatalog(Catalog catalog );
	public String deleteCatalogById(String id) ;
	public void deleteAllCatalogs();
	public Optional<List<Catalog>> getCatalogById(String id) ;
	public Optional<List<Catalog>> getCatalog();
	public String updateCatalog( Catalog catalog);
	public boolean isCatalogExists(String id);
	String updateCatalog();
	
		
	
	
	
	
	
	
	
	
	

}
