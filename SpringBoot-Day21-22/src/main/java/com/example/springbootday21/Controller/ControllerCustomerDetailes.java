package com.example.springbootday21.Controller;

import com.example.springbootday21.DTO.CustomerDetailsDto;
import com.example.springbootday21.Model.CustomerDetails;
import com.example.springbootday21.Service.ServiceCustomerDetailes;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customerdetails")
@RequiredArgsConstructor
public class ControllerCustomerDetailes {

    private final ServiceCustomerDetailes serviceCustomerDetailes;

    @PostMapping("/add")
    public ResponseEntity addeta(@RequestBody @Valid CustomerDetailsDto dto){

        serviceCustomerDetailes.addetailes(dto);
        return ResponseEntity.status(200).body("details added");

    }
    @PutMapping("/update")
    public ResponseEntity updateCustomerdetailes(@Valid @RequestBody CustomerDetails customerDetails){
        serviceCustomerDetailes.updatedetailes(customerDetails);
        return ResponseEntity.status(200).body("customer detailes Updated");
    }
}
