package com.example.shippingservice;


import hu.webuni.shippingservice.dto.ShippingOrderDTO;
import hu.webuni.shippingservice.dto.ShippingOrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class ShippingService {


    @Autowired
    @Qualifier("shipmentTemplate")
    private JmsTemplate jmsTemplate;

    public static final String REQUEST_QUEUE="SHIPMENT_IN";


    @Async
    public void shipOrder(ShippingOrderDTO shippingOrderDTO, String generatedId) {
        log.info("Thread name controller: " + Thread.currentThread().getName());
        log.info("ASYNC method");
        try {
            Thread.sleep(10000);
            pushResponse(generatedId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.error("FINISHED!!!!");
    }

    public void pushResponse(String generatedId) {
        String methodName = "pushResponse";
        log.info(methodName + " " + "started");

        Random random = new Random();
        String orderStatus = random.nextBoolean() ? "DELIVERED" : "SHIPMENT_FAILED";

        ShippingOrderMessage shippingOrderDTO = ShippingOrderMessage.builder().orderStatus(orderStatus).externalId(generatedId).build();
        jmsTemplate.convertAndSend(REQUEST_QUEUE, shippingOrderDTO);
        log.info("Shipment has been succesfully sent....");
        log.info(methodName + " " + "ended");
    }



}
