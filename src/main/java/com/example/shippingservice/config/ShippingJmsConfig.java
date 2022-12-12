package com.example.shippingservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
public class ShippingJmsConfig {

    @Bean
    public MessageConverter configConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setObjectMapper(objectMapper);
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        return messageConverter;
    }

    @Bean
    public ConnectionFactory shipmentConnector(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:9998");
        return connectionFactory;
    }

    @Bean(name = "shipmentTemplate")
    public JmsTemplate jmsTemplate(ObjectMapper objectMapper){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(shipmentConnector());
        template.setMessageConverter(configConverter(objectMapper));
        return template;
    }

}
