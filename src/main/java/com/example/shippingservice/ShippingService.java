package com.example.shippingservice;


import hu.webuni.shippingservice.dto.ShippingOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ShippingService {

    @Async
    public void shipOrder(ShippingOrderDTO shippingOrderDTO, String generatedId) {
        log.info("Thread name controller: " + Thread.currentThread().getName());
        log.info("ASYNC method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.error("FINISHED!!!!");

    }
}
