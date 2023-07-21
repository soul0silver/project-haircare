package com.project.service.productServiceImp;

import com.project.File.FileDetail;
import com.project.File.FileOrder;
import com.project.model.Detail;
import com.project.model.Order;
import com.project.service.Order_DetailSv;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.List;
@Service
@Component
@NoArgsConstructor
public class O_d_svImp implements Order_DetailSv {
    FileOrder fileOrder=new FileOrder();
    @Autowired
    List<Order> order;
    FileDetail fileDetail=new FileDetail();
    @Autowired
    List<Detail> detail;

    @Override
    public List<Order> saveOd(Order o) throws IOException {
       List<Order> orders=fileOrder.readFile();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId()==o.getId()){
                orders.get(i).setStatus(o.getStatus());
                break;
            }
        }fileOrder.write(orders);
        return orders;
    }

    @Override
    public List<Order> showOd() throws IOException {
       List<Order> orders=fileOrder.readFile();
        return orders;

    }


    @Override
    public List<Detail>  showDe() throws IOException {
        List<Detail> details=fileDetail.readFile();
        return details;
    }

    @Override
    public Order find(int id) throws IOException {
        Order order=new Order();
        List<Order> orders=fileOrder.readFile();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId()==id) {order=orders.get(i);break;}
        }
        return order;
    }

    @Override
    public void add(Order o) throws IOException {
        List<Order> orders=fileOrder.readFile();
        o.setId(orders.size()+1);
        orders.add(o);
        fileOrder.write(orders);
    }

    @Override
    public Detail findDe(int id) throws IOException {
        List<Detail> details=fileDetail.readFile();
        Detail detail=new Detail();
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).getId() == id)
                detail= details.get(i);
        }
        return detail;
    }

    @Override
    public void addDe(Detail d) throws IOException {
        List<Detail> details=fileDetail.readFile();
        d.setId(details.size()+1);
        details.add(d);
        fileDetail.write(details);
    }
}
