package com.project.File;


import com.project.model.Order;
import com.project.model.Solution;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Component
@NoArgsConstructor
public class FileOrder {
    File order;
    public List<Order> readFile() throws IOException {
        List<Order> path=new ArrayList<Order>();
        try {
            FileInputStream fileInputStream = new FileInputStream("order.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            path= (List<Order>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            order = new File("order.txt");
            List<Order> a=new ArrayList<Order>();
            write(a);
        }
        return path;
    }
    public void write(List<Order> a) throws IOException {
        FileOutputStream fOut=new FileOutputStream("order.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fOut);
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        fOut.close();
    }
}

