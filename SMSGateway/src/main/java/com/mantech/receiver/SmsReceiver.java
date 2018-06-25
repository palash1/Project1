package com.mantech.receiver;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.mantech.data.SMS;

@Component
public class SmsReceiver {

	@ServiceActivator(inputChannel = "smsChannel", outputChannel="smsFormatValidationChannel")
    public SMS smsReceiver(SMS sms) {
		System.out.println("SmsReceiver:"+sms);
        return sms;
    }
}
