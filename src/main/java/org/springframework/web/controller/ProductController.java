package org.springframework.web.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> showAllOrders() {
        List<Order> orderList;
        try {
            orderList = orderService.getAllOrders();
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No orders available ", e);
        }
        return orderList;
    }

    @GetMapping("/orders/{id}")
    public Order showOrderById(@PathVariable int id) {
        Order order;
        try {
            order = orderService.getOrderById(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found ", e);
        }
        return order;
    }

    @PostMapping("/orders")
    public Order showAddedOrder(@RequestBody Order order) {
        try {
            orderService.addOrder(order);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not added ", e);
        }
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String showDeletedOrder(@PathVariable int id) {
        try{
            orderService.deleteOrder(id);}
        catch (ObjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not deleted ", e);
        }
        return "Order with id " + id + " have been deleted";
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(Exception exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
