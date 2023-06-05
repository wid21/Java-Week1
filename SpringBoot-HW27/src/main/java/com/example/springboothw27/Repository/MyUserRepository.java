package com.example.springboothw27.Repository;

import com.example.springboothw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Integer> {


    MyUser findMyUserById(Integer id);
    MyUser findUserByUsername(String username);
}
