package com.example.springbootday21.Controller;

import com.example.springbootday21.ApiResonse.ApiResponse;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Model.Merchant;
import com.example.springbootday21.Service.ServiceMerchant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class ControllerMerchant {

    private final ServiceMerchant serviceMerchant;

    @GetMapping("/get")
    public ResponseEntity getAllMerchant(){
        List<Merchant> merchantList=serviceMerchant.getAllMerchant();
        return ResponseEntity.status(200).body(merchantList);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant){
        serviceMerchant.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, @PathVariable Integer id){
        serviceMerchant.updateMerchant(merchant,id);
        return ResponseEntity.status(200).body("Merchant Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        serviceMerchant.deleteMerchant(id);
        return ResponseEntity.status(200).body("Merchant deleted");

    }
}
