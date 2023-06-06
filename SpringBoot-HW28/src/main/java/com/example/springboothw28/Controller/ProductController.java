package com.example.springboothw28.Controller;

import com.example.springboothw28.Model.Orders;
import com.example.springboothw28.Model.Product;
import com.example.springboothw28.Model.User;
import com.example.springboothw28.Service.OrderService;
import com.example.springboothw28.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity getAllProduct() {
        List<Product> productList = productService.getAllProduct();
        return ResponseEntity.status(200).body(productList);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product, @PathVariable Integer productId){
        productService.updateProduct(product, productId);
        return ResponseEntity.status(200).body("Product Updated");
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.status(200).body("Product Deleted");
    }

    @GetMapping("/getproductId/{productId}")
    public ResponseEntity getProductById(@PathVariable Integer productId){
        Product product = productService.getProductId(productId);
        return ResponseEntity.status(200).body(product);
    }


}
