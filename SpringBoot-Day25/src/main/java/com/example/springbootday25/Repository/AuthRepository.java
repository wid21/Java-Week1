package com.example.springbootday25.Repository;

import com.example.springbootday25.Model.MyUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser, Integer> {

MyUser findUserByUsername(String name);

MyUser findMyUserById(Integer id);
}
