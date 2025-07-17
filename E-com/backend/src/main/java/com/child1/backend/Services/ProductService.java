package com.child1.backend.Services;


import com.child1.backend.model.Product;
import com.child1.backend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {




    @Autowired
    private ProductRepository productRepository;

     public List<Product> getAllProducts() {
         return productRepository.findAll();
     }

     public Product createProduct(Product product , MultipartFile image) {
            try {
                product.setImageName(image.getOriginalFilename());
                product.setImageType(image.getContentType());
                product.setImageData(image.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
         return productRepository.save(product);
     }

     public Product getProductById(int id) {
         return productRepository.findById((long) id).orElse(null);
     }
        public Product updateProduct(Product product, int id) {
            Product existingProduct = productRepository.findById((long) id).
                    orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImageName(product.getImageName());
            existingProduct.setImageType(product.getImageType());
            existingProduct.setImageData(product.getImageData());
            return productRepository.save(existingProduct);

        }

        public void deleteProduct(int id) {
            productRepository.deleteById((long) id);

        }

}
