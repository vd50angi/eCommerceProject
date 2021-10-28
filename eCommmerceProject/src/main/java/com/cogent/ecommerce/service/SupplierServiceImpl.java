package com.cogent.ecommerce.service;

private static SupplierService supplierService;
//private SupplierServiceImpl() {}
//
//public static SupplierService getInstance() {
//	if(supplierService==null) {
//		supplierService= new SupplierServiceImpl();
//		return supplierService;
//	}
//	return supplierService;
//}
@Autowired
SupplierRepository SupplierRepository;
@Override
public String addRole(Role role) {
	// TODO Auto-generated method stub
	return roleRepository.addRole(role);
}
	
	
	

}
