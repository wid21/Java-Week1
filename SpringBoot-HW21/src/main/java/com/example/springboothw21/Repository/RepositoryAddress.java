package com.example.springboothw21.Repository;

import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAddress extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
}
