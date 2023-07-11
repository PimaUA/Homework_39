package org.springframework.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.entities.Product;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.service.ProductService;

import java.time.LocalDate;
import java.util.List;

@RestController
//@Controller
@RequestMapping("/hello")
public class ProductController {
    @Autowired
    ProductService productService;


  /*  @PostMapping("/login")
    public CurrentUser login(@Validated @RequestBody LoginForm form, BindingResult bindingResult,
                                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            throw new AppException("Invalid username or password");
        }

        try {
            request.login(form.getUsername(), form.getPassword());
        } catch (ServletException e) {
            throw new AppException("Invalid username or password");
        }

        var auth = (Authentication) request.getUserPrincipal();
        var user = (User) auth.getPrincipal();
        //log.info("User {} logged in.", user.getUsername());

        return new CurrentUser(user.getId(), user.getNickname());
    }
*/




    @GetMapping("/products")
    public List<Product> showAllProducts() {
        List<Product> productList;
        try {
            productList = productService.getAllProducts();
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No products available ", e);
        }
        return productList;
    }

    @GetMapping("/products/{id}")
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
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    public Product showAddedProduct(@RequestBody Product product) {
        try {
            productService.addProduct(product);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not added ", e);
        }
        return product;
    }

    @DeleteMapping("/deleteProduct/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    public String showDeletedProduct(@PathVariable int id) {
        //var c= SecurityContextHolder.getContext().getAuthentication();
        try {
            productService.deleteProduct(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not deleted ", e);
        }
        return "Product with id " + id + " have been deleted";
    }

  /*  @GetMapping("/products")
    public String showAllOrdersView(Model model) {
        List<Order> orderList;
        try {
            orderList = orderService.getAllOrders();
            model.addAttribute("orderList", orderList);
        } catch (OrderListNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No orders available", e);
        }
        return "allOrdersView";
    }

    @RequestMapping("/addId")
    public String makeNewId() {
        return "idInputView";
    }

    @GetMapping("/getOrderById")
    public String showGotOrderByIdView(@ModelAttribute("order")
                                       Order order, Model model) throws OrderNotFoundException {
        try {
            int id = order.getId();
            order = orderService.getOrderById(id);
            model.addAttribute(order);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found ", e);
        }
        return "foundByIdOrderView";
    }

    @PostMapping("/addProduct")
    public String makeNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProductView";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        try {
            productService.addProduct(product);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not saved ", e);
        }
        return "redirect:addProduct";
    }*/
}
