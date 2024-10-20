package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Orders;
import com.masai.exception.OrdersException;
import com.masai.service.OrderService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    // Method to add a new order
    @PostMapping("/orders")
    public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order) throws OrdersException {
        // Call the service to add the order
        Orders savedOrder = orderService.addOrder(order);
        // Return the saved order with HTTP status 201 (Created)
        return new ResponseEntity<Orders>(savedOrder, HttpStatus.CREATED);
    }

    // Method to update an existing order by ID
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer orderId, @Valid @RequestBody Orders order)
            throws OrdersException {
        // Call the service to update the order
        Orders updatedOrder = orderService.updateOrder(order, orderId);
        // Return the updated order with HTTP status 200 (OK)
        return new ResponseEntity<Orders>(updatedOrder, HttpStatus.OK);
    }

    // Method to delete an order by ID
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable Integer orderId) throws OrdersException {
        // Call the service to delete the order
        Orders deletedOrder = orderService.deleteOrderById(orderId);
        // Return the deleted order with HTTP status 200 (OK)
        return new ResponseEntity<Orders>(deletedOrder, HttpStatus.OK);
    }

    // Method to view an order by ID
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId) throws OrdersException {
        // Call the service to view a specific order
        Orders order = orderService.viewOrder(orderId);
        // Return the order with HTTP status 200 (OK)
        return new ResponseEntity<Orders>(order, HttpStatus.OK);
    }

    // Method to view all orders
    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> viewAllOrder() throws OrdersException {
        // Call the service to view all orders
        List<Orders> orderList = orderService.viewAllOrders();
        // Return the list of orders with HTTP status 200 (OK)
        return new ResponseEntity<List<Orders>>(orderList, HttpStatus.OK);
    }
}
