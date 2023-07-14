package org.springframework.web.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

   @ExceptionHandler
    public ResponseEntity<ProductIncorrectData> handleException(ProductNotFoundException exception) {
        ProductIncorrectData productIncorrectData = new ProductIncorrectData();
        productIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(productIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProductIncorrectData> handleException(ProductListNotFoundException exception) {
        ProductIncorrectData productIncorrectData = new ProductIncorrectData();
        productIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(productIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProductIncorrectData> handleException(Exception exception) {
        ProductIncorrectData productIncorrectData = new ProductIncorrectData();
        productIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(productIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
