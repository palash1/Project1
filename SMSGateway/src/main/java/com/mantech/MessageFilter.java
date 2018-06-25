package com.mantech;

import java.io.IOException;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.mantech.data.SMS;
import com.mantech.utils.JSON;

@Component
public class MessageFilter implements MessageSelector{
	@Override
	  public boolean accept(Message<?> message) {
		String str=message.getPayload().toString();
		try {
			SMS sms= JSON.fromJson(str, SMS.class);System.out.println("Filter:"+ sms);
			 return sms.getMobileNo().equals("98369809893");
		} catch (IOException e) {
			 
		}
		return false;
	  }
}
