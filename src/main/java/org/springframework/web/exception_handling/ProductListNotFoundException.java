package org.springframework.web.exception_handling;

public class ProductListNotFoundException extends RuntimeException{

    public ProductListNotFoundException() {
        super("The specified list of products does not exist");
    }
}
