package com.example.shippingservice.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShipmentIdGeneratorUtil {

    public String genShippmentId () {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        log.info("Generated id: "+generatedString);
        return generatedString;
    }


}
