package com.example.springboothw28;

import com.example.springboothw28.ApiException.ApiException;
import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Repository.OrderRepository;
import com.example.springboothw28.Repository.ProductRepository;
import com.example.springboothw28.Repository.UserRepository;
import com.example.springboothw28.Service.OrderService;
import com.example.springboothw28.Service.ProductService;
import com.example.springboothw28.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    OrderService orderService;
    @InjectMocks
    ProductService productService;
    @InjectMocks
   UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    OrderRepository orderRepository;
    @Mock
    ProductRepository productRepository;

    User user;
    Product product1;
    Product product2;
    Orders order1;
    Orders order2;
    List<Orders> ordersList;
    List<Product> products;

    @BeforeEach
    void setUp() {
        user = new User(null, "Wid", "12345", "ADMIN", null);
        product1 = new Product(null, "Lashes", 20, null);
        product2 = new Product(null, "Lip stick", 35,null);

        order1 = new Orders(null,3,new Date(),"new",20,user,product1);
        order2 =new Orders(null,3,new Date(),"new",35,user,product2);

        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        ordersList = new ArrayList<>();
        ordersList.add(order1);
        ordersList.add(order2);
    }

    @Test
    public void getOrderbyIdTest(){
     when(orderRepository.findOrdersById(order1.getId())).thenReturn(order1);
        Orders orderA = orderService.getOrderbyId(user.getId(), order1.getId());
        Assertions.assertThat(orderA).isEqualTo(order1);
        verify(orderRepository,times(1)).findOrdersById(order1.getId());
    }

    @Test
    public void addProduct(){
        productService.addProduct(product1);
        verify(productRepository,times(1)).save(product1);
    }

    @Test
    public void updateProduct(){
        when(productRepository.findProductById(product1.getId())).thenReturn(product1);
        productService.updateProduct(product2,product1.getId());
        verify(productRepository,times(1)).findProductById(product1.getId());
        verify(productRepository,times(1)).save(product1);
    }
    @Test
    public void deleteProductTest() {
        when(productRepository.findProductById(product1.getId())).thenReturn(product1);
        productService.deleteProduct(product1.getId());
        verify(productRepository,times(1)).delete(product1);
    }
    @Test
    public void changeStatusTest(){
        when(orderRepository.findOrdersById(order1.getId())).thenReturn(order1);
        orderService.changeStatuse(order1.getStatus(),order1.getId());
        verify(orderRepository,times(1)).findOrdersById(order1.getId());
        verify(orderRepository, times(1)).save(order1);
    }

    @Test
    public void getUserbyIdTest(){
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        User userA= userService.getUserId(user.getId());
        Assertions.assertThat(userA).isEqualTo(user);
        verify(userRepository,times(1)).findUserById(user.getId());
    }

}