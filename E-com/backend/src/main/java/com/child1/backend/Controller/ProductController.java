package com.child1.backend.Controller;


import com.child1.backend.Services.ProductService;
import com.child1.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

     @GetMapping("/products")
     public List<Product> getAllProducts() {
         return productService.getAllProducts();
     }

     @PostMapping("/products")
     public Product createProduct(@RequestBody Product product) {
         return productService.createProduct(product);
     }
}
