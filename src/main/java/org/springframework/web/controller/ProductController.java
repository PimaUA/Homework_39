package org.springframework.web.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.entities.Product;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    public List<Product> showAllProducts() {
        List<Product> productList;
        try {
            productList = productService.getAllProducts();
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No products available ", e);
        }
        return productList;
    }

    @GetMapping("/getProduct/{id}")
    public Product showProductById(@PathVariable int id) {
        Product product;
        try {
            product = productService.getProductById(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found ", e);
        }
        return product;
    }

    @PostMapping("/addProduct")
    public Product showAddedProduct(@RequestBody Product product) {
        try {
            productService.addProduct(product);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not added ", e);
        }
        return product;
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String showDeletedProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not deleted ", e);
        }
        return "Product with id " + id + " have been deleted";
    }
}
