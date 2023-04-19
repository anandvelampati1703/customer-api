package com.acc.training.customerapi.controller;
import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.service.CustomerService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private CustomerService service;
    
    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {
        Customer result = service.createCustomer(body);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {
        if (id.length()<5 || id.length()>8){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Customer result = service.getCustomer(id);
        if (result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(result);
    }
    
    
}
