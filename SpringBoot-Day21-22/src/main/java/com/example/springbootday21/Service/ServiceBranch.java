package com.example.springbootday21.Service;

import com.example.springbootday21.ApiException.ApiException;
import com.example.springbootday21.DTO.BranchDto;
import com.example.springbootday21.DTO.CustomerDetailsDto;
import com.example.springbootday21.Model.Branch;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Model.CustomerDetails;
import com.example.springbootday21.Model.Merchant;
import com.example.springbootday21.Repository.RepositoryBranch;
import com.example.springbootday21.Repository.RepositoryMerchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceBranch {

    private final RepositoryBranch repositoryBranch;
    private final RepositoryMerchant repositoryMerchant;
    public List<Branch> getBranch(){

        return repositoryBranch.findAll();
    }

    public void addBranch(Branch branch){

        repositoryBranch.save(branch);
    }

    public void updateBranch(Branch branch, Integer id){
        Branch oldbranch= repositoryBranch.findBranchById(id);
        if(oldbranch==null){
            throw new ApiException("branch not found");
        }

        oldbranch.setName(branch.getName());
        oldbranch.setArea(branch.getArea());

        repositoryBranch.save(oldbranch);
    }


    public void deleteBranch(Integer id){
        Branch branch= repositoryBranch.findBranchById(id);
        if(branch==null){
            throw new ApiException("branch not found");
        }

        repositoryBranch.delete(branch);
    }

    public void assignMerchantToBranch(Integer m_id,Integer b_id){
        Merchant m= repositoryMerchant.findMerchantById(m_id);
        Branch b=repositoryBranch.findBranchById(b_id);

        if(m==null || b==null){
            throw new ApiException("not found");
        }

        b.setMerchant(m);
        repositoryBranch.save(b);
    }

//    public void updatebranch(BranchDto branchDto , Integer m_id, Integer b_id){  //add to exicet customer , handel with Dto
//
//        Merchant m = repositoryMerchant.findMerchantById(m_id);
//        if (m==null){
//            throw new ApiException("teacher not found");
//        }
//        Branch branch= new Branch(branchDto.getName(),branchDto.getArea());
//        repositoryBranch.save(branch);
//    }
    public void updateBranch(BranchDto branchDto, Integer m_id, Integer b_id) {
        Merchant merchant = repositoryMerchant.findMerchantById(m_id);
        if (merchant == null) {
            throw new ApiException("Merchant not found with ID: " + m_id);
        }

        Branch branch = repositoryBranch.findBranchById(b_id);
        if (branch == null) {
            throw new ApiException("Branch not found with ID: " + b_id);
        }

        branch.setName(branchDto.getName());
        branch.setArea(branchDto.getArea());
        repositoryBranch.save(branch);
    }
}


