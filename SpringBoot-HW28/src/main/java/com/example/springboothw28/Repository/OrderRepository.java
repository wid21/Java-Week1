package com.example.springboothw28.Repository;

import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository  extends JpaRepository<Orders,Integer> {



  Orders findOrdersById(Integer id);

  List<Orders> findOrdersByUser(User user);

  List<Orders> findOrdersByUserId(Integer id);


}
