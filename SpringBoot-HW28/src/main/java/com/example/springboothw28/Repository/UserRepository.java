package com.example.springboothw28.Repository;

import com.example.springboothw28.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer Id);

    User findUserByUsername(String username);
}
