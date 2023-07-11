package org.springframework.web.exception_handling;

public class OrderListNotFoundException extends RuntimeException{

    public OrderListNotFoundException() {
        super("The specified list of orders does not exist");
    }
}
