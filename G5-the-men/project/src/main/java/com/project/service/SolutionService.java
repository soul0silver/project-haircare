package com.project.service;

import com.project.model.Product;
import com.project.model.Solution;

import java.io.IOException;
import java.util.List;

public interface SolutionService {
    public List<Solution> create(List<Solution> p) throws Exception;
    public void update(int id) throws Exception;
    public void delete(int id) throws Exception;
    public List<Solution> review() throws IOException;
    public Solution find(int id);
}
