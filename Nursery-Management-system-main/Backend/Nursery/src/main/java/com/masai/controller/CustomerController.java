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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Method to save a new customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        // Call the service to add the customer
        Customer savedCustomer = customerService.addCustomer(customer);
        // Return the saved customer with HTTP status 201 (Created)
        return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }

    // Method to update an existing customer
    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,
                                                   @RequestParam(required = false) String key) throws CustomerException {
        // Call the service to update the customer
        Customer updatedCustomer = customerService.updateCustomer(customer, key);
        // Return the updated customer with HTTP status 200 (OK)
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    // Method to delete a customer by ID
    @DeleteMapping("/customers/{customerId}/{token}/{adminId}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable Integer customerId,
                                                       @PathVariable String token,
                                                       @PathVariable Integer adminId) throws CustomerException {
        // Call the service to delete the customer
        Customer deletedCustomer = customerService.deleteCustomer(customerId, token, adminId);
        // Return the deleted customer with HTTP status 200 (OK)
        return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
    }

    // Method to get a customer by ID
    @GetMapping("/customers/{customerId}/{token}/{adminId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId,
                                                    @PathVariable String token,
                                                    @PathVariable Integer adminId) throws CustomerException {
        // Call the service to view a specific customer
        Customer customer = customerService.viewCustomer(customerId, token, adminId);
        // Return the customer with HTTP status 200 (OK)
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    // Method to get all customers
    @GetMapping("/customers/{token}/{adminId}")
    public ResponseEntity<List<Customer>> getAllCustomer(@PathVariable String token,
                                                         @PathVariable Integer adminId) throws CustomerException {
        // Call the service to view all customers
        List<Customer> customerList = customerService.viewAllCustomer(token, adminId);
        // Return the list of customers with HTTP status 200 (OK)
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }
}
