package com.project.File;

import com.project.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class myFile {
    File img;

    public myFile() {

    }

    public List<Product> readFile() throws IOException {
        List<Product> path=new ArrayList<Product>();
        try {
            FileInputStream fileInputStream = new FileInputStream("imgPath.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            path= (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            img = new File("imgPath.txt");
            List<Product> a=new ArrayList<Product>();
            write(a);
        }
        return path;
    }
    public void write(List<Product> a) throws IOException {
        FileOutputStream fOut=new FileOutputStream("imgPath.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fOut);
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        fOut.close();
    }
}

