package com.mantech.transformer;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


public class SmsTransformer extends AbstractTransformer{

	@Override
	protected Object doTransform(Message<?> message) throws Exception {
		 
		return null;
	}

}
