package com.cogent.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.repository.OrdersRepository;

@Service
	public class OrdersServiceImpl implements OrdersService {
	//
//		private static OrdersRepository ordersRepository;
//		private OrdersRepositoryImpl() {}
	//	
	//	
//		public static OrdersRepository getInstance() {
//			
//			if(ordersRepository==null) {
//				ordersRepository= new OrdersRepositoryImpl();
//				return ordersRepository;
//			}
//			return ordersRepository;
//		}

		@Autowired
		OrdersRepository ordersRepository;	
	
		@Override
		public String addOrders(Orders orders) {
			// TODO Auto-generated method stub
			return ordersRepository.addOrders(orders);
		}

		@Override
		public Optional<String> deleteOrdersById(String id) {
			// TODO Auto-generated method stub
			return ordersRepository.deleteOrdersById(id);
		}
		

		@Override
		public void deleteAllOrders() {
			// TODO Auto-generated method stub
			ordersRepository.deleteAllOrders();
		}

		@Override
		public Optional<Orders> getOrderByID(String id) {
			// TODO Auto-generated method stub
			return orderRepository.getOrderByID(id);
		}

		@Override
		public Optional<List<Orders>> getOrder() {
			// TODO Auto-generated method stub
			return orderRepository.getOrder();
		}

		@Override
		public Optional<String> updateOrder(String id, Orders order) {
			// TODO Auto-generated method stub
			return orderRepository.upddateOrder(id, order);
		}

		@Override
		public boolean isOrderExist(String Id) {
			// TODO Auto-generated method stub
			return orderRepository.isOrdersExist(Id);
		}

	}	
	

}
