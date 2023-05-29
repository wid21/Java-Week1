package com.example.springbootday21.Service;

import com.example.springbootday21.ApiException.ApiException;
import com.example.springbootday21.DTO.CustomerDetailsDto;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Model.CustomerDetails;
import com.example.springbootday21.Repository.CustomerDetailesRepository;
import com.example.springbootday21.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceCustomerDetailes {
    private final CustomerDetailesRepository customerDetailesRepository;
    private final CustomerRepository customerRepository;

    public void addetailes(CustomerDetailsDto detailsDto){  //add to exicet customer , handel with Dto

        Customer cu = customerRepository.findCustomerById(detailsDto.getCustomer_id());
        if (cu==null){
            throw new ApiException("can not add details customer not found");
        }
        CustomerDetails customerDetails= new CustomerDetails(null, detailsDto.getGender(), detailsDto.getAge(), detailsDto.getEmail(), cu);
        customerDetailesRepository.save(customerDetails);
    }

    public void updatedetailes(CustomerDetails customerDetails){
        Customer c  =customerRepository.findCustomerById(customerDetails.getId());
        if (c == null) {
            throw new ApiException("Address not found");
        }

        customerDetails.setAge(customerDetails.getAge());
        customerDetails.setEmail(customerDetails.getEmail());
        customerDetails.setGender(customerDetails.getGender());
        customerDetails.setCustomer(customerDetails.getCustomer());

        customerRepository.save(c);
    }
    }

