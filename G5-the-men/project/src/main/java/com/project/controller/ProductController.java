package com.project.controller;

import com.project.model.Product;
import com.project.service.productServiceImp.productServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
    public class ProductController {
    productServiceImp imp=new productServiceImp();

    public ProductController() throws Exception {
    }

    @PostMapping("/create")
    public List<Product> postList(@RequestBody List<Product> products) throws Exception {
        return imp.create(products);
    }
    @GetMapping("/index")
    public List<Product>  getHome() throws IOException {
        return imp.review();}

}
