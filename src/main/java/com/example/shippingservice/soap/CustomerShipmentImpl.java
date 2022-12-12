package com.example.shippingservice.soap;

import com.example.shippingservice.ShippingService;
import com.example.shippingservice.util.ShipmentIdGeneratorUtil;
import hu.webuni.shippingservice.dto.ShippingOrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerShipmentImpl implements CustomerShipment{

    private final ShippingService shippingService;
    private final ShipmentIdGeneratorUtil shipmentIdGeneratorUtil;

    @Override
    public String shipOrder(ShippingOrderDTO shippingOrderDTO) {
        log.info(shippingOrderDTO.toString());
        String generatedId= shipmentIdGeneratorUtil.genShippmentId();
        shippingService.shipOrder(shippingOrderDTO,generatedId);
        return generatedId;
    }



}






