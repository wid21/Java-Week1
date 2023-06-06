package com.example.springboothw28.Service;

import com.example.springboothw28.ApiException.ApiException;
import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Repository.OrderRepository;
import com.example.springboothw28.Repository.UserRepository;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public void register(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole("CUSTOMER");
        userRepository.save(user);
    }

    public void updateUser(Integer userId, User user) {
        User oldUser = userRepository.findUserById(userId);
        oldUser.setUsername(user.getUsername());
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        oldUser.setPassword(hash);
        userRepository.save(oldUser);
    }

    public void deleteUser(User user) {

        List<Orders> orders =orderRepository.findOrdersByUser(user);
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setUser(null);
        }
        User oldUser = userRepository.findUserById(user.getId());
        userRepository.delete(oldUser);
    }

    public User getUserId(Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null){
            throw new ApiException("User Not found");
        }
        return user;
    }



}
