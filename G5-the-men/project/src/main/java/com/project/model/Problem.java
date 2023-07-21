package com.project.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Problem implements Serializable {
    private int id;
    private String title;
    private String content;
    private String intro;
    private String pic;
}
