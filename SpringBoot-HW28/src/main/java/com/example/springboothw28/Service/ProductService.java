package com.example.springboothw28.Service;

import com.example.springboothw28.ApiException.ApiException;
import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Repository.OrderRepository;
import com.example.springboothw28.Repository.ProductRepository;
import com.example.springboothw28.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
        private final ProductRepository productRepository;
        private final OrderRepository orderRepository;
        private final UserRepository userRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product, Integer productId) {
        Product product1=productRepository.findProductById(productId);
        if (product1 == null){
            throw new ApiException("product Not Found");
        }
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);
    }

    public void deleteProduct(Integer productId) {
        Product product = productRepository.findProductById(productId);
        if (product == null) {
            throw new ApiException("Do not have product");
        }
        productRepository.delete(product);
    }

    public Product getProductId(Integer productId) {
        Product product = productRepository.findProductById(productId);
        if (product == null){
            throw new ApiException("product Not found");
        }
        return product;
    }

        }




