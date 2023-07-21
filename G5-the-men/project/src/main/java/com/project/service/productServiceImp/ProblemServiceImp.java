package com.project.service.productServiceImp;

import com.project.File.FileProblem;
import com.project.model.Problem;
import com.project.model.Solution;
import com.project.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@Component
public class ProblemServiceImp implements ProblemService {
    private List<Problem> problems;
    @Autowired
    private FileProblem fileProblem;
    @Override
    public List<Problem> create(List<Problem> p) throws Exception {
        problems=p;
        fileProblem.write(p);
        return p;
    }

    @Override
    public void update(int id) throws Exception {


    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public List<Problem> review() throws IOException {
        problems=fileProblem.readFile();
        return problems;
    }

    @Override
    public Problem find(int id) {
        Problem b=new Problem();
        for (Problem a:problems)
            if (a.getId()==id) {b=a;break;}
        return b;
    }
}
