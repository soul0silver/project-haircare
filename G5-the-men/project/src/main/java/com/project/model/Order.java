package com.project.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Order implements Serializable {
    private int id;
    private String name;
    private String tel;
    private String address;
    private int total;
    private String status;
    private String date;
}
