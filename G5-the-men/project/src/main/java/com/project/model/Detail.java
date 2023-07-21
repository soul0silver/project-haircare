package com.project.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Detail implements Serializable {
    private int id;
    private int[] proId;
    private int[] count;
}
