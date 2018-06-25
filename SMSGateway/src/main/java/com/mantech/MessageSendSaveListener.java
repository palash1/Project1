package com.mantech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.mantech.service.ReceiverService;

@Service
public class MessageSendSaveListener implements MessageHandler{
	
	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println("Save:" +message);
		
	}

}
