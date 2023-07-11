package org.springframework.web.exception_handling;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("The specified order does not exist");
    }
}
