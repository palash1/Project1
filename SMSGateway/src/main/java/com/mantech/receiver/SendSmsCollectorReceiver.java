package com.mantech.receiver;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.mantech.data.SMS;

@Component
public class SendSmsCollectorReceiver {

	@ServiceActivator(inputChannel = "sendSMSCollectorChannel", outputChannel="sendSMSChannel")
    public String sendSmsCollectorReceiver(SMS sms) {
		System.out.println("SendSmsCollectorReceiver:"+sms);
        return sms.toString();
    }
}
