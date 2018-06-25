package com.mantech.router;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.mantech.data.SmsQuery;

@MessageEndpoint
public class MobileOrVehicleRouter {
	
	@Router(inputChannel="mobileOrVehicleChannel")
	public String mobileOrVehicleRouter(SmsQuery smsQuery) {
		
		System.out.println("MobileOrVehicleRouter:"+smsQuery);
		if(smsQuery.getType().equalsIgnoreCase("M") || smsQuery.getType().equalsIgnoreCase("S")) {
			System.out.println("MobileOrVehicleRouter(M):mobileChannel");
			return "mobileChannel";
		}else if(smsQuery.getType().equalsIgnoreCase("V")) {
			System.out.println("MobileOrVehicleRouter(V):vehicleChannel");
			return "vehicleChannel";
		}else {
			System.out.println("MobileOrVehicleRouter(H):helpChannel");
			return "helpChannel";
		}
	}

}
