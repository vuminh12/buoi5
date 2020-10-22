package com.in28minutes.springboot.controller;


import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.StatusResponse;
import com.in28minutes.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customers/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.postCustomer(customer);
    }

    @GetMapping(value = "/customers/list",consumes = "application/json")
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }

    @GetMapping(value = "/customer/{cusId}",consumes = "application/json")
    public Customer getCustomerById(@PathVariable("cusId") Integer id){
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "/customer/delete/{cusId}",consumes = "application/json")
    public StatusResponse deleteCustomerById(@PathVariable("cusId") Integer id){
        boolean status =   customerService.deleteCustomerById(id);
        if(status){
            return new StatusResponse(true);
        }
        return new StatusResponse(false);
    }
}
