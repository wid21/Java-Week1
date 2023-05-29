package com.example.springbootday21.Repository;

import com.example.springbootday21.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailesRepository extends JpaRepository<CustomerDetails,Integer> {
}
