package com.example.springbootday21.Controller;

import com.example.springbootday21.ApiResonse.ApiResponse;
import com.example.springbootday21.DTO.BranchDto;
import com.example.springbootday21.Model.Branch;
import com.example.springbootday21.Model.Merchant;
import com.example.springbootday21.Service.ServiceBranch;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
@RequiredArgsConstructor
public class ControllerBranch {

    private final ServiceBranch serviceBranch;

    @GetMapping("/get")
    public ResponseEntity getAllMerchant(){
        List<Branch> branchList=serviceBranch.getBranch();
        return ResponseEntity.status(200).body(branchList);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Branch branch){
        serviceBranch.addBranch(branch);
        return ResponseEntity.status(200).body(new ApiResponse("Branch added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Branch branch, @PathVariable Integer id){
        serviceBranch.updateBranch(branch,id);
        return ResponseEntity.status(200).body("Branch Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranch(@PathVariable Integer id){
        serviceBranch.deleteBranch(id);
        return ResponseEntity.status(200).body("Branch deleted");

    }

    @PutMapping("/addm/{m_id}/{b_id}")
    public ResponseEntity getBranchMerchant(@PathVariable Integer m_id , @PathVariable Integer b_id){
        serviceBranch.assignMerchantToBranch(m_id,b_id);
        return ResponseEntity.status(200).body(new ApiResponse("Branch added"));
    }

    @PutMapping("/updateBranch/{m_id}/{b_id}")
    public ResponseEntity updateBranch(@RequestBody BranchDto branchDto,@PathVariable Integer m_id, @PathVariable Integer b_id){
        serviceBranch.updateBranch(branchDto,m_id,b_id);
        return ResponseEntity.status(200).body(new ApiResponse("Branch upfdated"));
    }
}
