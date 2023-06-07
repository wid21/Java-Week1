package com.example.springboothw28;

import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Repository.OrderRepository;
import com.example.springboothw28.Repository.ProductRepository;
import com.example.springboothw28.Repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    User user,user1,user2;
    Orders order1, order2 ;
    Product product1, product2;

    @BeforeEach
    void setUp() {

        user = new User(null, "Wid", "12345", "ADMIN", null);
        user1 =new User(null, "Omar", "O1234", "CUSTOMER", null);
        user2 =new User(null, "Anan", "A1123", "CUSTOMER", null);

        product1 = new Product(null, "Lashes", 20,null);
        product2 = new Product(null, "Lip stick", 35,null);

        order1 = new Orders(null, 2, new Date(), "new", 35.0, user, product2);
        order2 = new Orders(null, 3, new Date(), "new", 20.0, user, product1);

        order2.setProduct(product1);
    }

    @Test
    public void findUserByIdTest(){
        userRepository.save(user2);
        user1=userRepository.findUserById(user2.getId());
        Assertions.assertThat(user1).isEqualTo(user2);

    }

    @Test
    public void findMyUserByUsername(){
        userRepository.save(user1);
        user = userRepository.findUserByUsername(user1.getUsername());
        Assertions.assertThat(user).isEqualTo(user1);

    }
    @Test
    public void findProductByIdTest() {
        productRepository.save(product1);
        Product product = productRepository.findProductById(product1.getId());
        Assertions.assertThat(product).isEqualTo(product1);
    }

    @Test
    public void findOrdersByIdTest(){
        userRepository.save(user);
        productRepository.save(product1);
        orderRepository.save(order2);
        Orders orders=orderRepository.findOrdersById(order2.getId());
        Assertions.assertThat(orders).isEqualTo(order2);
    }

    @Test
    public void findOrdersByUser(){
        userRepository.save(user);
        productRepository.save(product1);
        productRepository.save(product2);
        orderRepository.save(order1);
        orderRepository.save(order2);
       List<Orders> orderList = orderRepository.findOrdersByUser(user);
        Assertions.assertThat(orderList.get(0).getUser().getId()).isEqualTo(user.getId());
    }


}