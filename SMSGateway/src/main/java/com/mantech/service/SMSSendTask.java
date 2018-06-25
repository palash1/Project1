package com.mantech.service;

import java.util.concurrent.BlockingQueue;

import com.mantech.data.SMS;

public class SMSSendTask implements Runnable{

	private BlockingQueue<SMS> q = null;
	private SendService sendService = null;
	
	public  SMSSendTask(BlockingQueue<SMS> q,SendService sendService) {
		
		this.q=q;
		this.sendService = sendService;
	}
	
	@Override
	public void run() {
		try {
			
			while(true) {
				try {
					
						SMS sms = q.take();
						sendService.send(sms);
					}catch(Exception e) {
						e.printStackTrace();
					}
				
			} 
		}catch(Exception e) {
			
		}
		
	}

}
