package com.mantech.receiver;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.mantech.data.SMS;
import com.mantech.data.SmsQuery;

@MessageEndpoint
public class MobileReceiver {
	
	@ServiceActivator(inputChannel = "mobileChannel", outputChannel = "sendSMSCollectorChannel")
    public SMS mobileReceiver(SmsQuery smsQuery) {
		
		String body="MM-Result-";
		SMS sms = new SMS();
		sms.setMobileNo(smsQuery.getMobileNo());
		sms.setBody(body+smsQuery.getValue());
		
		try {
			Thread.sleep(30*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MobileReceiver@@@"+sms);
        return sms;
    }
}
