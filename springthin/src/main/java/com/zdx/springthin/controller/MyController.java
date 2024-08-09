package com.zdx.springthin.controller;

import com.zdx.common.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/thin")
    public Student thin() {
        return new Student("zdx", 18);
    }

    @GetMapping("/async")
    public Student async() {
        System.out.println(Thread.currentThread().getId());

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(myService.
                    async(finalI));
        }
        List<String> errList = new ArrayList<>();

        for (CompletableFuture<Void> task : tasks) {
            try {
                task.get();
            } catch (InterruptedException e) {
               // e.printStackTrace();
                //throw new RuntimeException(e);
                errList.add(e.getMessage());
            } catch (ExecutionException e) {
               // e.printStackTrace();
                //throw new RuntimeException(e);
                errList.add(e.getCause().getMessage());
            }

        }
        System.out.println(errList);
        return new Student("sync", 18);
    }
}
