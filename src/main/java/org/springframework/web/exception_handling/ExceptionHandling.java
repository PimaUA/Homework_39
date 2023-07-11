package org.springframework.web.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

   @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(OrderNotFoundException exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(OrderListNotFoundException exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(Exception exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
