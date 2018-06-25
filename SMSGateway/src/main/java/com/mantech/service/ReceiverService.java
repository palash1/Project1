package com.mantech.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.mantech.data.SMS;

@Service
public class ReceiverService {
	
	private ExecutorService executorService;
	private BlockingQueue<SMS> q;
	
	public ReceiverService(SendService sendService) {
		
		q = new ArrayBlockingQueue<SMS>(1000);
		executorService = Executors.newFixedThreadPool(20);
		SMSSendTask smsSendTask=new SMSSendTask(q,sendService);
		Thread senderThread=new Thread(smsSendTask);
		senderThread.start();
	}

	public void receive(Message<?> message) {
		ProcessTask processTask = new ProcessTask(message, q);
		executorService.execute(processTask);
	}
	
	@PreDestroy
    public void destroy() {
		executorService.shutdown();
    }
}
