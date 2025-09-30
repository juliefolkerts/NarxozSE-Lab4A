package kz.lab4.springboot.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

}
