package com.mantech.data;

public class SMS {
	
	private Integer type=0;
	private Integer other=0;
	private boolean isRequest=true;
	private String mobileNo;
	private String body;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public boolean isUSSD() {
		if(type==1) {
			return true;
		}
		return false;
	}
	
	public Integer getOther() {
		return other;
	}
	public void setOther(Integer other) {
		this.other = other;
	}
	public boolean isRequest() {
		return isRequest;
	}
	public void setRequest(boolean isRequest) {
		this.isRequest = isRequest;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "SMS [type=" + type + ", other=" + other + ", isRequest=" + isRequest + ", mobileNo=" + mobileNo
				+ ", body=" + body + "]";
	}
	
}
