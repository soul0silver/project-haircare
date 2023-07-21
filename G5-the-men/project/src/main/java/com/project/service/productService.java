package com.project.service;
import com.project.model.Product;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface productService {
    public void add(Product p) throws Exception;
    public List<Product> create(List<Product> p) throws Exception;
    public void update(Product product) throws Exception;
    public void delete(int id) throws Exception;
    public List<Product> review() throws IOException;
    public Product find(int id) throws IOException;

}
