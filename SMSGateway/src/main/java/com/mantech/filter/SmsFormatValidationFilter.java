package com.mantech.filter;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.mantech.data.SMS;

@MessageEndpoint
public class SmsFormatValidationFilter{

	@Filter(inputChannel = "smsFormatValidationChannel", outputChannel="smsToQueryTransformerChannel", discardChannel="garbageSmsChannel")
	public boolean smsFormatValidationFilter(SMS sms) {
		
		System.out.println("SmsFormatValidationFilter::"+sms);
		return true;
	}

}
