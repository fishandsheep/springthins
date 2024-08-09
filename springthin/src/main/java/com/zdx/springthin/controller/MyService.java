package com.zdx.springthin.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Async("eagerDtpExecutor")
    public CompletableFuture<Void> async(int i) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        if (i % 2 == 0) {
            i = i / 0;
        }
        return CompletableFuture.completedFuture(null);
    }
}
