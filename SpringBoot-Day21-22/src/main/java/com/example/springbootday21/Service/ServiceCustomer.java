package com.example.springbootday21.Service;

import com.example.springbootday21.ApiException.ApiException;
import com.example.springbootday21.Model.Customer;
import com.example.springbootday21.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCustomer {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer,Integer id){
        Customer oldCustomer= customerRepository.findCustomerById(id);
        if(oldCustomer==null){
            throw new ApiException("customer not found");
        }

        oldCustomer.setName(customer.getName());
        customerRepository.save(oldCustomer);
    }


    public void deleteCustomer(Integer id){
        Customer customer= customerRepository.findCustomerById(id);
        if(customer==null){
            throw new ApiException("customer not found");
        }

        customerRepository.delete(customer);
    }

}
