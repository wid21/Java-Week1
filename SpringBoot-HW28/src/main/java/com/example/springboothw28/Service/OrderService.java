package com.example.springboothw28.Service;

import com.example.springboothw28.ApiException.ApiException;
import com.example.springboothw28.Dto.OrderDto;
import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Repository.OrderRepository;
import com.example.springboothw28.Repository.ProductRepository;
import com.example.springboothw28.Repository.UserRepository;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public double addOrder(Integer customerId, OrderDto dto) {
        Product product = productRepository.findProductById(dto.getProductId());
        if (product == null) {
            throw new ApiException("Product not found");
        }

        User user1 = userRepository.findUserById(customerId);
        if (user1 == null) {
            throw new ApiException("User not found");
        }

        double totalPrice = product.getPrice() * dto.getQuantity();

        Orders newOrder = new Orders(null, dto.getQuantity(), new Date(), "new", totalPrice, user1, product);
        orderRepository.save(newOrder);
        return totalPrice;
    }

    public void deleteOrder (Integer userId, Integer orderId ){
        Orders orders=orderRepository.findOrdersById(orderId);

        if (orders == null){
            throw new ApiException("order Not Found");
        }
        if (!(userId.equals(orders.getUser().getId()))){
            throw new ApiException("Not Authorized");
        }
        if(orders.getStatus().equals("inProgress") ||orders.getStatus().equals("completed")){
            throw new ApiException("order is delivered");
        }
        orders.setUser(null);
        orderRepository.delete(orders);
    }

   public void changeStatuse(String status, Integer orderId){
       Orders orders=orderRepository.findOrdersById(orderId);
       if (orders == null){
           throw new ApiException("order Not Found");
       }
           orders.setStatus(status);
           orderRepository.save(orders);

   }
    public Orders getOrderbyId(Integer userId, Integer orderId){
        Orders order  = orderRepository.findOrdersById(orderId);
        if (order.getUser().getId()!=userId){
            throw new ApiException("not found");
        }
        return order;
    }

    public List<Orders> getCustomerOrders(Integer userId) {
        User user =userRepository.findUserById(userId);
        List<Orders>orders=orderRepository.findOrdersByUserId(userId);
        if (orders ==null){
            throw new ApiException("you do not have orders ");
        }
        return orders;
    }

    public Double updateOrder(Integer userId, OrderDto dto, Integer orderId) {
        Orders oldOrder = orderRepository.findOrdersById(orderId);
        if (oldOrder == null){
            throw new ApiException("Order Not Found");
        }

        if (!(userId.equals(oldOrder.getUser().getId()))){
            throw new ApiException("Not Authorized");
        }

        if (oldOrder.getStatus().equals("inProgress")){
            throw new ApiException("Cannot Update Order in Progress");
        }

        oldOrder.setQuantity(dto.getQuantity());
        Double totalPrice = oldOrder.getProduct().getPrice()* dto.getQuantity();
        oldOrder.setTotalPrice(totalPrice);

        orderRepository.save(oldOrder);
        return totalPrice;
    }



}
