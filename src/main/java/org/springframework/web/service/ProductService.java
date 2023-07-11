package org.springframework.web.service;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.entities.Product;
import org.springframework.web.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        Product product;
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        } else {
            throw new ObjectNotFoundException(id,"product"); // check
        }
        return product;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
        LOGGER.info("Product "+product+" added");
    }

    public void deleteProduct(int id) {
        Product product;
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            LOGGER.info("Product "+optionalProduct+" deleted");
        } else {
            throw new ObjectNotFoundException(id,"product");  //check
        }
    }
}
