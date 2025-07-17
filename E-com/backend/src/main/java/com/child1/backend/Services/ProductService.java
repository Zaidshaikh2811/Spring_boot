package com.child1.backend.Services;


import com.child1.backend.model.Product;
import com.child1.backend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {




    @Autowired
    private ProductRepository productRepository;

     public List<Product> getAllProducts() {
         return productRepository.findAll();
     }

     public Product createProduct(Product product) {
         return productRepository.save(product);
     }

}
