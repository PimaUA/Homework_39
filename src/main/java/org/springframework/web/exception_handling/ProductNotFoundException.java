package org.springframework.web.exception_handling;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("The specified product does not exist");
    }
}
