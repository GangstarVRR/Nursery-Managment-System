package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrdersException;
import com.masai.model.Orders;
import com.masai.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersRepository ordersRepo;

	@Override
	public Orders addOrders(Orders order) {
		
		return ordersRepo.save(order);
	}

	@Override
	public Orders updateOrders(Orders order) {
		
		Optional<Orders> opt = ordersRepo.findById(order.getBookingOrderId());
		Orders updatedOrder = opt.orElseThrow(() -> new OrdersException("Orders is not found"));
		
		updatedOrder.setOrderDate(order.getOrderDate());
		updatedOrder.setQuantity(order.getQuantity());
		updatedOrder.setTransactionMode(order.getTransactionMode());
		updatedOrder.setTotalCost(order.getTotalCost());
		updatedOrder.setPlanters(order.getPlanters());
		
		return ordersRepo.save(updatedOrder);
	}

	@Override
	public Orders deleteOrders(int orderId) {
		Optional<Orders> opt = ordersRepo.findById(orderId);
		Orders orders = opt.orElseThrow(() -> new OrdersException("Orders is not found for given orderId "+orderId));
		ordersRepo.deleteById(orderId);
		
		return orders;
	}

	@Override
	public Orders viewOrders(int orderId) {
		
		Optional<Orders> opt = ordersRepo.findById(orderId);
		return opt.orElseThrow(() -> new OrdersException("Orders is not found for given orderId "+orderId));
		
	}

	@Override
	public List<Orders> viewAllOrders() {

		List<Orders> list = ordersRepo.findAll();
		if(list.isEmpty()) throw new OrdersException("No Orders available at this moment");
		
		return list;
	}

}
