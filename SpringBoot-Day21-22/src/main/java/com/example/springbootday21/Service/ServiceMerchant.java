package com.example.springbootday21.Service;

import com.example.springbootday21.ApiException.ApiException;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Model.Merchant;
import com.example.springbootday21.Repository.RepositoryMerchant;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceMerchant {

   private final RepositoryMerchant repositoryMerchant;
    public List<Merchant> getAllMerchant(){

        return repositoryMerchant.findAll();
    }
    public void addMerchant(Merchant merchant){

        repositoryMerchant.save(merchant);
    }
    public void updateMerchant(Merchant merchant,Integer id){
        Merchant oldmerchant= repositoryMerchant.findMerchantById(id);
        if(merchant==null){
            throw new ApiException("customer not found");
        }

        oldmerchant.setName(merchant.getName());
        oldmerchant.setBranchSet(merchant.getBranchSet());

        repositoryMerchant.save(merchant);
    }


    public void deleteMerchant(Integer id){
        Merchant merchant= repositoryMerchant.findMerchantById(id);
        if(merchant==null){
            throw new ApiException("merchant not found");
        }

        repositoryMerchant.delete(merchant);
    }
}
