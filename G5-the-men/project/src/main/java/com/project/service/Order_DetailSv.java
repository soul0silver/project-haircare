package com.project.service;

import com.project.model.Detail;
import com.project.model.Order;

import java.io.IOException;
import java.util.List;
import java.util.List;

public interface Order_DetailSv {
    public List<Order> saveOd(Order o) throws IOException;
    public List<Order> showOd() throws IOException;
    public List<Detail> showDe() throws IOException;
    public Order find(int id) throws IOException;
    public void add(Order o) throws IOException;
    public Detail findDe(int id) throws IOException;
    public void addDe(Detail d) throws IOException;
}
