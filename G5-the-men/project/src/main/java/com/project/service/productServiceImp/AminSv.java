package com.project.service.productServiceImp;

import com.project.model.Admin;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
@Getter
public class AminSv {

    int time= LocalTime.now().getHour();
    Boolean res=false;
    Admin admin=new Admin();
    public Admin check(String us,String pass){

        if (us.equals("SoulSilver")&& pass.equals("000111222"))
        {
            if (time>=0 && time<12) admin.setMess("Good morning Master!");
            else  if (time>=12 && time<19)  admin.setMess("Good afternoon Master!");
            else if (time>=19 && time<=23)  admin.setMess("Good evening Master!");
            res=true;
            admin.setMaster("SoulSilver");admin.setPass("000111222");
            return admin;
        }
         return null;

    }
    public String mess(){
        return admin.getMess();
    }
}
