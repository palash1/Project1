package com.mantech.transformer;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import com.mantech.data.SMS;
import com.mantech.data.SmsQuery;

@MessageEndpoint
public class SmsToQueryTransformer{

	@Transformer(inputChannel = "smsToQueryTransformerChannel", outputChannel = "mobileOrVehicleChannel")
	protected SmsQuery smsToQueryTransformer(SMS sms) throws Exception {
		
		String parts[] = sms.getBody().split("\\s+", 2);
		
		SmsQuery smsQuery=new SmsQuery();
		smsQuery.setMobileNo(sms.getMobileNo());
		smsQuery.setType(parts[0]);
		smsQuery.setValue(parts[1]);
		System.out.println("SmsToQueryTransformer:"+smsQuery);
		
		return smsQuery;
	}

}
