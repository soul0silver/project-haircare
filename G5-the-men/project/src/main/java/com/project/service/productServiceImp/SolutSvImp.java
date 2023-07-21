package com.project.service.productServiceImp;

import com.project.File.FileSolution;
import com.project.model.Solution;
import com.project.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@Component
public class SolutSvImp implements SolutionService {
    private List<Solution> solutions;
    @Autowired
    private FileSolution fileSolution;
    @Override
    public List<Solution> create(List<Solution> p) throws Exception {
        solutions=p;
        fileSolution.write(p);
        return p;
    }

    @Override
    public void update(int id) throws Exception {


    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public List<Solution> review() throws IOException {
        solutions=fileSolution.readFile();
        return solutions;
    }

    @Override
    public Solution find(int id) {
        Solution b=new Solution();
        for (Solution a:solutions)
            if (a.getId()==id) {b=a;break;}
        return b;
    }
}
