package com.mantech.filter;

import java.io.IOException;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import com.mantech.data.SMS;
import com.mantech.utils.JSON;

@MessageEndpoint
public class SmsValidateFilter{

	@Filter(inputChannel = "smsValidationChannel", outputChannel="smsTransformerChannel")
	public boolean smsValidateFilterSelector(Message<?> message) {
		String jsonMessage=message.getPayload().toString();
		System.out.println("SmsValidateFilter1:"+jsonMessage);
		try {
			SMS sms= JSON.fromJson(jsonMessage, SMS.class);
			System.out.println("SmsValidateFilter2:"+ sms);
			 return true;
		} catch (IOException e) {
			 
		}
		return false;
	}

}
