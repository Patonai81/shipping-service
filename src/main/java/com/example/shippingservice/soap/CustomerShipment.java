package com.example.shippingservice.soap;

import hu.webuni.shippingservice.dto.ShippingOrderDTO;

import javax.jws.WebService;

@WebService
public interface CustomerShipment {
    String shipOrder(ShippingOrderDTO shippingOrderDTO);

}