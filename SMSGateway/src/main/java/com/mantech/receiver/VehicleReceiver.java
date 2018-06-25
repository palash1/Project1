package com.mantech.receiver;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.mantech.data.SMS;
import com.mantech.data.SmsQuery;

@MessageEndpoint
public class VehicleReceiver {
	
	@ServiceActivator(inputChannel = "vehicleChannel", outputChannel = "sendSMSCollectorChannel")
    public SMS vehicleReceiver(SmsQuery smsQuery) {
		
		String body="VV-Result-";
		SMS sms = new SMS();
		sms.setMobileNo(smsQuery.getMobileNo());
		sms.setBody(body+smsQuery.getValue());
		System.out.println("VehicleReceiver@@@"+sms);
        return sms;
    }
}
