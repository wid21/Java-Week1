package com.example.springboothw21.Controller;

import com.example.springboothw21.ApiResponse.ApiResponse;
import com.example.springboothw21.Dto.DtoAddress;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Service.ServiceAddress;
import com.example.springboothw21.Service.ServiceTeacher;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class ControllerAddress {

    private final ServiceAddress serviceAddress;
    private final ServiceTeacher serviceTeacher;

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid DtoAddress dto){

        serviceAddress.addAdress(dto);
        return ResponseEntity.status(200).body("Address added");

    }

        @PutMapping("/update")
        public ResponseEntity updateAddress(@Valid @RequestBody Address address){
            serviceAddress.updateAddress(address);
            return ResponseEntity.status(200).body("Address Updated");
        }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressForTeacher(@PathVariable Integer id) {
        serviceAddress.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted ");
    }





}

