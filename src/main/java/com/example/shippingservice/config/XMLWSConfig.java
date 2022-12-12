package com.example.shippingservice.config;


import com.example.shippingservice.soap.CustomerShipment;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.xml.ws.Endpoint;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class XMLWSConfig {

    private final Bus bus;
    private final CustomerShipment customerShipment;

    @Bean
    public Endpoint publishEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, customerShipment);
        endpoint.publish("/shipment");
        return endpoint;
    }
}
