package com.project.File;

import com.project.model.Problem;
import com.project.model.Solution;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component
@NoArgsConstructor
public class FileProblem {
    File prob;
    public List<Problem> readFile() throws IOException {
        List<Problem> path=new ArrayList<Problem>();
        try {
            FileInputStream fileInputStream = new FileInputStream("problem.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            path= (List<Problem>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            prob = new File("problem.txt");
            List<Problem> a=new ArrayList<Problem>();
            write(a);
        }
        return path;
    }
    public void write(List<Problem> a) throws IOException {
        FileOutputStream fOut=new FileOutputStream("problem.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fOut);
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        fOut.close();
    }
}
