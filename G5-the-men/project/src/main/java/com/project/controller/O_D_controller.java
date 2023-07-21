package com.project.controller;

import com.project.model.Detail;
import com.project.model.Order;
import com.project.model.Product;
import com.project.service.productServiceImp.O_d_svImp;
import com.project.service.productServiceImp.productServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping(path = "/product",method = RequestMethod.POST)
public class O_D_controller {
    O_d_svImp od = new O_d_svImp();
    productServiceImp psv=new productServiceImp();

    @GetMapping("/list")
    public String viewOd(Model mo) throws IOException {
        mo.addAttribute("order", od.showOd());
        return "/product/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Order o) throws IOException {
        od.saveOd(o);
        return "redirect:/product/list";
    }

    @GetMapping("/creat/{id}")
    public String edit(Model mo, @PathVariable int id) throws IOException {
        Order o= od.find(id);
        mo.addAttribute("or", o);
        return "/product/create";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model mo,@PathVariable int id,Model mo2,Model mo3,Model tot ) throws IOException {
        List<Product> products=new ArrayList<Product>();
        List<Integer> total=new ArrayList<Integer>();
        Detail detail=od.findDe(id);
        int[] a= detail.getProId();
        for (int i=0;i<a.length;i++){
            products.add(psv.find(a[i]));
            total.add(detail.getCount()[i]*psv.find(detail.getProId()[i]).getPrice());
        };
        Order order=od.find(id);
        tot.addAttribute("total",total);
        mo3.addAttribute("order",order);
        mo.addAttribute("de",detail);
        mo2.addAttribute("prod",products);
        return "/product/detail";
    }
}
