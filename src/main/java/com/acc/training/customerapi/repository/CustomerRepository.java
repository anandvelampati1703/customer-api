package com.acc.training.customerapi.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String,Customer> customerDB = new HashMap<>();

    static{
        initCustomerDatabase();
    }

    private static void initCustomerDatabase() {
        Customer cust = new Customer();
        cust.setCustomerId("12345");
        cust.setCustomerName("John Doe");
        cust.setCustomerAddress("123 Lane, NY");
        
        customerDB.put(cust.getCustomerId(), cust);
    }

    public Customer saveCustomer(@Valid Customer body) {
        customerDB.put(body.getCustomerId(), body);
        return customerDB.get(body.getCustomerId());
    }

    public Customer fetchCustomer(String id) {
        return customerDB.get(id);
    }
    
}
