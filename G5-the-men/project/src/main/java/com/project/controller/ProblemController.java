package com.project.controller;

import com.project.model.Problem;
import com.project.service.productServiceImp.ProblemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProblemController {
    @Autowired
    ProblemServiceImp problemServiceImp;
    @GetMapping("/prob")
    public List<Problem> getProb() throws IOException {
        return problemServiceImp.review();
    }

    @PostMapping("/newprob")
    public List<Problem> setProb(@RequestBody List<Problem> problems) throws Exception {
        return problemServiceImp.create(problems);
    }
}
