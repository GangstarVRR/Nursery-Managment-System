package com.masai.service;

import java.util.List;

import com.masai.model.Orders;
import com.masai.exception.OrdersException;

public interface OrderService {

	public Orders addOrder(Orders order) throws OrdersException;

	public Orders updateOrder(Orders order, Integer orderId) throws OrdersException;

	public Orders deleteOrderById(Integer orderId) throws OrdersException;

	public Orders viewOrder(Integer orderId) throws OrdersException;

	public List<Orders> viewAllOrders() throws OrdersException;
	
}