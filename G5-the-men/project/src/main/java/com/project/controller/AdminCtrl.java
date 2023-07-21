package com.project.controller;

import com.project.model.Admin;
import com.project.service.productServiceImp.AminSv;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@Getter
@NoArgsConstructor
public class AdminCtrl {
     AminSv aminSv=new AminSv();
    Admin admin;
     private int a=0;
     @GetMapping("/login")
     public String log(Model model){
         admin=new Admin();
         model.addAttribute("ad",admin);
         return "product/log";
     }
     @PostMapping("/check")
    public String check(@ModelAttribute Admin admin){
         if (aminSv.check(admin.getMaster(),admin.getPass())==(null))
         return "redirect:login";
         else
         {
             admin=aminSv.check(admin.getMaster(),admin.getPass());
             return "redirect:hel";
         }

     }
     @GetMapping("/hel")
    public String hello(Model model){
         String mess=aminSv.mess();
         model.addAttribute( "mess",mess);
         return "product/hello";
     }
}
