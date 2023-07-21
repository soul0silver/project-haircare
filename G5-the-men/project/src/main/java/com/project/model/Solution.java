package com.project.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Solution implements Serializable {
    private int id;
    private String title;
    private String content;
    private String pic;
}
