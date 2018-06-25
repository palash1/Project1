package com.mantech.gateway;

import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway(defaultRequestChannel = "sendSMSChannel")
public interface SmsSendGateway {

    void sendToMqtt(String data);

}
