package com.mantech;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MQTTGateway {

	void sendToMqtt(String data);
}
