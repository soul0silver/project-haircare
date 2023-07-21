package com.project.File;
import com.project.model.Detail;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
@NoArgsConstructor
public class FileDetail {
    File detail;
    public List<Detail> readFile() throws IOException {
        List<Detail> path=new ArrayList<Detail>();
        try {
            FileInputStream fileInputStream = new FileInputStream("Detail.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            path= (List<Detail>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            detail = new File("Detail.txt");
            List<Detail> a=new ArrayList<Detail>();
            write(a);
        }
        return path;
    }
    public void write(List<Detail> a) throws IOException {
        FileOutputStream fOut=new FileOutputStream("Detail.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fOut);
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        fOut.close();
    }
}
