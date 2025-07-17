package com.child1.backend.Controller;


import com.child1.backend.Services.ProductService;
import com.child1.backend.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController()
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

     @GetMapping("/products")
     public ResponseEntity<List<Product>> getAllProducts() {
         return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
     }

     @PostMapping("/products")
     public ResponseEntity<?> createProduct(@RequestPart Product product , @RequestPart MultipartFile image) {
                try{


                         Product savedProduct= productService.createProduct(product, image);

                         return  new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
                }
                catch (Exception e){
                    e.printStackTrace();
                    return new ResponseEntity<>("Error creating product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }

     }

     @GetMapping("/products/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable  int id) {
            Product product = productService.getProductById(id);
         System.out.println("Fetching product with ID: " + product);

            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Product(),HttpStatus.NO_CONTENT);
            }
        }



        @PutMapping("/products/{id}")
        public ResponseEntity<Product> updateProduct(@RequestBody Product product , @PathVariable int id) {
            Product updatedProduct = productService.updateProduct(product,id);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }

        @DeleteMapping("/products/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable int id) {
            Product product = productService.getProductById(id);
            if (product != null) {
                productService.deleteProduct(id);
                return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
        }


        @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String query) {
            List<Product> products = productService.searchProducts(query);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }


}
