package com.example.Rest_Api_Application;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private Map<Integer, String> products = new HashMap<>();

    // Get all products
    @GetMapping
    public Map<Integer, String> getAllProducts() {
        return products;
    }

    // Get product by ID
    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return products.getOrDefault(id, "Product not found");
    }

    // Create a new product
    @PostMapping
    public String createProduct(@RequestBody String name) {
        int id = products.size() + 1;
        products.put(id, name);
        return "Product created with ID: " + id;
    }

    // Update a product
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String name) {
        if (products.containsKey(id)) {
            products.put(id, name);
            return "Product updated";
        } else {
            return "Product not found";
        }
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            return "Product deleted";
        } else {
            return "Product not found";
        }
    }
}

