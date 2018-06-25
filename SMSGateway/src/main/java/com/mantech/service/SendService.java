package com.mantech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mantech.MQTTGateway;
import com.mantech.data.SMS;
import com.mantech.utils.JSON;

@Service
public class SendService {

	@Autowired
	private MQTTGateway mqttGateway;
	
	public void send(SMS sms) {
		
		String messageJSON;
		try {
			messageJSON=JSON.toJson(sms);
			mqttGateway.sendToMqtt(messageJSON);
		}catch(JsonProcessingException ex) {
			ex.printStackTrace();
		}
	}
}
