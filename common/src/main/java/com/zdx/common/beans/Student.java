package com.zdx.common.beans;

import lombok.Data;

@Data
public class Student {

    private String name;

    private int age;

    private String version;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.version = "1.0";
    }

}
