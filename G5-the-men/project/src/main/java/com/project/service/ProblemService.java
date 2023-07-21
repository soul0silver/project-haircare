package com.project.service;

import com.project.model.Problem;
import com.project.model.Solution;

import java.io.IOException;
import java.util.List;

public interface ProblemService {
    public List<Problem> create(List<Problem> p) throws Exception;
    public void update(int id) throws Exception;
    public void delete(int id) throws Exception;
    public List<Problem> review() throws IOException;
    public Problem find(int id);
}
