package com.example.springboothw28.Controller;


import com.example.springboothw28.Dto.OrderDto;
import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Repository.UserRepository;
import com.example.springboothw28.Service.OrderService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    @PutMapping("/chaStatus/{orderId}/{status}")
    public ResponseEntity changeStatus(@Valid @PathVariable String status, @PathVariable Integer orderId) {
        orderService.changeStatuse(status, orderId);
        return ResponseEntity.status(200).body("status changed ");
    }

@PostMapping("/add")
public ResponseEntity addOrder(@AuthenticationPrincipal User user, @RequestBody OrderDto dto){
    Double price = orderService.addOrder(user.getId(), dto);
    return ResponseEntity.status(200).body("Your total Price for order  is " + price);
}

    @GetMapping("/get")
    public ResponseEntity getorder(@AuthenticationPrincipal User user) {
        List<Orders> orders = orderService.getCustomerOrders(user.getId());
        return ResponseEntity.status(200).body(orders);
    }

    @GetMapping("/get-orderId/{orderId}")
    public ResponseEntity getOrderById(@AuthenticationPrincipal User user, @PathVariable Integer orderId) {
        Orders order = orderService.getOrderbyId(user.getId(), orderId);
        return ResponseEntity.status(200).body(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal User user, @PathVariable Integer orderId){
        orderService.deleteOrder(user.getId(), orderId);
        return ResponseEntity.status(200).body("order deleted ");
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal User user , @RequestBody OrderDto dto, @PathVariable Integer orderId){
        Double price = orderService.updateOrder(user.getId(), dto, orderId);
        return ResponseEntity.status(200).body("Order Updated new Total is " + price);
    }


}
