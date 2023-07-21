package com.project.service.productServiceImp;

import com.project.File.myFile;
import com.project.model.Product;
import com.project.service.productService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
@Service
@NoArgsConstructor
@Component
public class productServiceImp implements productService {
    private List<Product> products;
    myFile myFile=new myFile();


    @Override
    public void add(Product p) throws Exception {
        products=myFile.readFile();
        p.setId(products.size()+1);
        products.add(p);
        myFile.write(products);
    }

    @Override
    public List<Product> create(List<Product> p) throws Exception {
        products=p;
        myFile.write(products);
        return products;
    }

    @Override
    public void update(Product product) throws Exception {
        products=myFile.readFile();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==product.getId()) {
                products.get(i).setCateId(product.getCateId());
                products.get(i).setDescription(product.getDescription());
                products.get(i).setImage(product.getImage());
                products.get(i).setName(product.getName());
                products.get(i).setPrice(product.getPrice());
                break;}
        }
        myFile.write(products);
    }

    @Override
    public void delete(int id) throws Exception {
        products=myFile.readFile();
        for (int i=0;i<products.size();i++)
            if (products.get(i).getId()==id) {
                products.remove(i);
                break;
            }
        myFile.write(products);
    }

    @Override
    public List<Product> review() throws IOException {
       return myFile.readFile();
    }

    @Override
    public Product find(int id) throws IOException {
        products=myFile.readFile();
        Product p = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id) {p=products.get(i);break;}
        }
        return p;
    }




}



