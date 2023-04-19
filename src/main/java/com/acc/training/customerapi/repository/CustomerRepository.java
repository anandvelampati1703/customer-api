package com.acc.training.customerapi.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String, Customer> customerDB = new HashMap<>();

    static{
        initCustomerDatabase();
    }

    private static void initCustomerDatabase(){
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerName("John");
        customer.setCustomerAddress("123 Main St");
        customerDB.put(customer.getCustomerId(), customer);
    }

    public Customer getCustomer(@Valid String id) {
        return customerDB.get(id);
    }

    public Customer saveCustomer(@Valid Customer body) {
        customerDB.put(body.getCustomerId(),  body);
        return customerDB.get(body.getCustomerId());
    }
    
}
