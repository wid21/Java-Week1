package com.example.springbootday21.Controller;

import com.example.springbootday21.ApiResonse.ApiResponse;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Service.ServiceCustomer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor

public class ControllerCustomer {

    private final ServiceCustomer serviceCustomer;
    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        List<Customer> customerList=serviceCustomer.getAllCustomers();
        return ResponseEntity.status(200).body(customerList);
    }


    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        serviceCustomer.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer id){
        serviceCustomer.updateCustomer(customer,id);
        return ResponseEntity.status(200).body("customer Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        serviceCustomer.deleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted");

    }

}
