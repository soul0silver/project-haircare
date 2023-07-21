package com.project.controller;

import com.project.model.Product;
import com.project.model.Solution;
import com.project.service.productServiceImp.SolutSvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SolutionController {
    @Autowired
    SolutSvImp solutSvImp;
    @PostMapping("/add")
    public List<Solution> postList(@RequestBody List<Solution> s) throws Exception {
        return solutSvImp.create(s);
    }
    @GetMapping("/view")
    public List<Solution>  getHome() throws IOException {
        return solutSvImp.review();}
}
