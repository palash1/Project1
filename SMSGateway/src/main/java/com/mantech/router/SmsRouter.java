package com.mantech.router;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.mantech.data.SMS;

@MessageEndpoint
public class SmsRouter {
	
	@Router(inputChannel="smsRouterChannel")
	public String smsRoute(SMS sms) {System.out.println("SmsRouter1:"+sms);
	    if (sms.isUSSD()) {
	        return "smsUSSDChannel";
	    }
	    System.out.println("SmsRouter2:"+sms);
	    return "smsChannel";
	}
	

}
