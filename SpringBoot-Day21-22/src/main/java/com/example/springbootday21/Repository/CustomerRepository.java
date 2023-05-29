package com.example.springbootday21.Repository;

import com.example.springbootday21.Model.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);


}
