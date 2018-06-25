package com.mantech.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.messaging.Message;

import com.mantech.data.SMS;
import com.mantech.utils.JSON;

public class ProcessTask implements Runnable{

	private Message<?> message = null;
	private BlockingQueue<SMS> q = null;
	
	public ProcessTask(Message<?> message, BlockingQueue<SMS> q) {
		
		this.message = message;
		this.q = q;
	}
	
	@Override
	public void run() {
		
		try {
			String dataStr=message.getPayload().toString();
			SMS sms= JSON.fromJson(dataStr, SMS.class);
			sms.setBody("HHH-" + sms.getBody());
			q.add(sms);
			
		}catch(Exception e) {
			
		}
		
	}
}
