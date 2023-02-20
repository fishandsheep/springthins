package com.zdx.springthin.controller;

import com.zdx.common.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/thin")
    public Student thin() {
        return new Student("zdx", 18);
    }

}
