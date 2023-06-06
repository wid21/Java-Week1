package com.example.springboothw28.Repository;


import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findProductById(Integer id);

    //List<Product> findProductByO(Orders orders);


}
