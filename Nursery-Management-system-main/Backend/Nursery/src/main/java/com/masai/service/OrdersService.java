package com.masai.service;

import java.util.List;

import com.masai.exception.OrdersException;
import com.masai.model.Orders;

public interface OrdersService {
	
	public Orders addOrders(Orders order);
	public Orders updateOrders(Orders order) throws OrdersException;
	public Orders deleteOrders(int orderId) throws OrdersException;
	public Orders viewOrders(int orderId) throws OrdersException;
	public List< Orders> viewAllOrders() throws OrdersException;

}
