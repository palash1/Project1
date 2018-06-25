package com.mantech.receiver;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.mantech.data.SMS;
import com.mantech.data.SmsQuery;

@MessageEndpoint
public class HelpReceiver {
	
	@ServiceActivator(inputChannel = "helpChannel", outputChannel = "sendSMSCollectorChannel")
    public SMS mobileReceiver(SmsQuery smsQuery) {
		
		String body="Help-Result-";
		SMS sms = new SMS();
		sms.setMobileNo(smsQuery.getMobileNo());
		sms.setBody(body+smsQuery.getValue());
		
		System.out.println("HelpReceiver@@@"+sms);
        return sms;
    }
}
