package com.project.controller;

import com.project.model.Product;
import com.project.service.productServiceImp.productServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/product",method = RequestMethod.POST)
public class ProCtrl {
    productServiceImp psv=new productServiceImp();
    @GetMapping("/product")
    public String showPro(Model model) throws IOException {
        model.addAttribute("pro",psv.review());
        return "product/product";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model) throws IOException {
        Product product=psv.find(id);
        model.addAttribute("pro",product);
        return "product/edit";
    }
    @PostMapping("/saveP")
    public String update(@ModelAttribute Product product) throws Exception {
        psv.update(product);
        return "redirect:/product/product";
    }
    @GetMapping("/deleteP/{id}")
    public String delete(Model model,@PathVariable int id) throws Exception {
        psv.delete(id);
        model.addAttribute("pro",psv.review());
        return "product/product";
    }
    @GetMapping("/createP")
    public String createP(Model mo,Model mo1) throws Exception {
        Product product=new Product();
        List<Product> productList=psv.review();
        int s=productList.size();
        mo1.addAttribute("size",s);
        mo.addAttribute("product",product);
        return "product/createP";
    }
    @PostMapping(path = "/addP")
    public String addP(@ModelAttribute Product product) throws Exception {
        psv.add(product);
        return "redirect:/product/product";
    }
}
