package org.example.productcatalogservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String getMessage() {
        return "Welcome to the Product Catalog Service";
    }
}
