package com.project.File;


import com.project.model.Solution;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class FileSolution {
    File solut;
    public List<Solution> readFile() throws IOException {
        List<Solution> path=new ArrayList<Solution>();
        try {
            FileInputStream fileInputStream = new FileInputStream("solution.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            path= (List<Solution>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            solut = new File("solution.txt");
            List<Solution> a=new ArrayList<Solution>();
            write(a);
        }
        return path;
    }
    public void write(List<Solution> a) throws IOException {
        FileOutputStream fOut=new FileOutputStream("solution.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fOut);
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        fOut.close();
    }
}

